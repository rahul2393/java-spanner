package com.example.spanner;

import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.CreateBackupScheduleRequest;

public class CreateScheduleBackupSample {
  static void createScheduleBackupSample() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupId = "my-backup";
    String schedule = "5 4 * * *"; // At 04:05 AM everyday
    createScheduleBackupSample(projectId, instanceId, databaseId, backupId, schedule);
  }

  static void createScheduleBackupSample(
      String projectId, String instanceId, String databaseId, String backupId, String schedule) {
    Spanner spanner = SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
    DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
    BackupSchedule result =
        databaseAdminClient.createBackupSchedule(
            CreateBackupScheduleRequest.newBuilder()
                .setParent(DatabaseId.of(projectId, instanceId, databaseId).toString())
                .setBackupSchedule(BackupSchedule.newBuilder().setCreationSpecCron(schedule))
                .setBackupScheduleId(backupId)
                .build());
    System.out.printf("Created instance configuration %s\n", result.getName());
  }
}
