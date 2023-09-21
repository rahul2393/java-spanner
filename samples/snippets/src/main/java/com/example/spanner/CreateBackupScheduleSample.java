package com.example.spanner;

import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.CreateBackupScheduleRequest;
import java.io.IOException;

public class CreateBackupScheduleSample {

  static void createBackupSchedule() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupId = "my-backup";
    String schedule = "5 4 * * *"; // At 04:05 AM everyday
    createBackupSchedule(projectId, instanceId, databaseId, backupId, schedule);
  }

  private static void createBackupSchedule(
      String projectId, String instanceId, String databaseId, String backupId, String schedule) {
    try {
      DatabaseAdminClient client = DatabaseAdminClient.create();
      BackupSchedule result =
          client.createBackupSchedule(
              CreateBackupScheduleRequest.newBuilder()
                  .setParent(DatabaseId.of(projectId, instanceId, databaseId).toString())
                  .setBackupSchedule(BackupSchedule.newBuilder().setCreationSpecCron(schedule))
                  .setBackupScheduleId(backupId)
                  .build());
      System.out.printf("Created backup schedule %s\n", result.getName());
    } catch (IOException e) {
      throw (SpannerException) e.getCause();
    }
  }
}
