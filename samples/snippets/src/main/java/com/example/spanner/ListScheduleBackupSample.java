package com.example.spanner;

import com.google.api.gax.paging.Page;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.ListBackupSchedulesRequest;

public class ListScheduleBackupSample {

  static void listScheduleBackups() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    String databaseId = "my-database";
    listScheduleBackups(projectId, instanceId, databaseId);
  }

  static void listScheduleBackups(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      final DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
      Page<BackupSchedule> page =
          databaseAdminClient.listBackupSchedules(
              ListBackupSchedulesRequest.newBuilder()
                  .setParent(DatabaseId.of(projectId, instanceId, databaseId).toString())
                  .setPageSize(100)
                  .build());
      System.out.println(
          "Backup Schedule for projects/"
              + projectId
              + "/instances/"
              + instanceId
              + "/databases/"
              + databaseId);
      while (page != null) {
        for (BackupSchedule schedule : page.iterateAll()) {
          System.out.println("\t" + schedule.getName() + " " + schedule.getCreationSpecCron());
        }
        page = page.getNextPage();
      }
    }
  }
}
