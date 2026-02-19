FROM maven:3.9-eclipse-temurin-17 AS build

# Install the 'file' utility as root
USER root
RUN apt-get update && apt-get install -y file && rm -rf /var/lib/apt/lists/*
# Switch back to the default user for the maven image (e.g., 1000)
USER 1000

WORKDIR /app

# Check the build platform's architecture
RUN echo "Building on: $(uname -m)"

# COPY with --chown to match the non-root user
USER root
COPY --chown=1000:1000 . .
USER 1000

# Step 1: Install java-spanner modules
RUN mvn install -DskipTests -Dclirr.skip -Dmaven.javadoc.skip=true -Dcheckstyle.skip -pl google-cloud-spanner -am

# Step 2: Build bypass-performance fat jar
RUN cd bypass-performance && mvn package -DskipTests -Dclirr.skip -Dmaven.javadoc.skip=true -Dcheckstyle.skip

# Find the JAR
RUN JAR_PATH="$(find bypass-performance/target -maxdepth 1 -type f -name 'google-cloud-spanner-bypass-performance-*.jar' ! -name '*-tests.jar' ! -name 'original-*' | head -n 1)" \
 && test -n "$JAR_PATH" \
 && echo "Found JAR: $JAR_PATH" \
 && cp "$JAR_PATH" /app/main.jar

# Check the file type of the copied JAR
RUN file /app/main.jar

FROM eclipse-temurin:17-jre

WORKDIR /app

# Install tools as root
USER root
RUN apt-get update && apt-get install -y procps file && rm -rf /var/lib/apt/lists/*

# Check the target platform's architecture
RUN echo "Running on: $(uname -m)"

COPY --from=build /app/main.jar /app/main.jar

# Verify the copied JAR file type in the final image as root
RUN file /app/main.jar

# No USER directive here, defaults to the base image's default user (likely root)

# To run the app:
# CMD ["java", "-jar", "/app/main.jar"]

# Temporary CMD for debugging
CMD ["tail", "-f", "/dev/null"]