/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/spanner/admin/database/v1/backup.proto

package com.google.spanner.admin.database.v1;

public interface BackupScheduleOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.admin.database.v1.BackupSchedule)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The name of the backup schedule.
   * </pre>
   *
   * <code>string name = 1;</code>
   *
   * @return The name.
   */
  java.lang.String getName();
  /**
   *
   *
   * <pre>
   * Required. The name of the backup schedule.
   * </pre>
   *
   * <code>string name = 1;</code>
   *
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString getNameBytes();

  /**
   *
   *
   * <pre>
   * Required. Crontab text representation for how often
   * backups are created for this schedule.
   * </pre>
   *
   * <code>string creation_spec_cron = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The creationSpecCron.
   */
  java.lang.String getCreationSpecCron();
  /**
   *
   *
   * <pre>
   * Required. Crontab text representation for how often
   * backups are created for this schedule.
   * </pre>
   *
   * <code>string creation_spec_cron = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for creationSpecCron.
   */
  com.google.protobuf.ByteString getCreationSpecCronBytes();

  /**
   *
   *
   * <pre>
   * Required. How long to keep each backup [1d-365d].
   * </pre>
   *
   * <code>string retention_duration = 3;</code>
   *
   * @return The retentionDuration.
   */
  java.lang.String getRetentionDuration();
  /**
   *
   *
   * <pre>
   * Required. How long to keep each backup [1d-365d].
   * </pre>
   *
   * <code>string retention_duration = 3;</code>
   *
   * @return The bytes for retentionDuration.
   */
  com.google.protobuf.ByteString getRetentionDurationBytes();

  /**
   *
   *
   * <pre>
   * An encryption info describing the encryption type and key resources
   * in Cloud KMS used to encrypt/decrypt the backup created by this schedule.
   * </pre>
   *
   * <code>
   * .google.spanner.admin.database.v1.CreateBackupScheduleEncryptionConfig encryption_config = 4 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return Whether the encryptionConfig field is set.
   */
  boolean hasEncryptionConfig();
  /**
   *
   *
   * <pre>
   * An encryption info describing the encryption type and key resources
   * in Cloud KMS used to encrypt/decrypt the backup created by this schedule.
   * </pre>
   *
   * <code>
   * .google.spanner.admin.database.v1.CreateBackupScheduleEncryptionConfig encryption_config = 4 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return The encryptionConfig.
   */
  com.google.spanner.admin.database.v1.CreateBackupScheduleEncryptionConfig getEncryptionConfig();
  /**
   *
   *
   * <pre>
   * An encryption info describing the encryption type and key resources
   * in Cloud KMS used to encrypt/decrypt the backup created by this schedule.
   * </pre>
   *
   * <code>
   * .google.spanner.admin.database.v1.CreateBackupScheduleEncryptionConfig encryption_config = 4 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  com.google.spanner.admin.database.v1.CreateBackupScheduleEncryptionConfigOrBuilder
      getEncryptionConfigOrBuilder();

  /**
   * <code>string optional_dummy_field = 5 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The optionalDummyField.
   */
  java.lang.String getOptionalDummyField();
  /**
   * <code>string optional_dummy_field = 5 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The bytes for optionalDummyField.
   */
  com.google.protobuf.ByteString getOptionalDummyFieldBytes();

  /**
   * <code>string required_dummy_field = 6 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The requiredDummyField.
   */
  java.lang.String getRequiredDummyField();
  /**
   * <code>string required_dummy_field = 6 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for requiredDummyField.
   */
  com.google.protobuf.ByteString getRequiredDummyFieldBytes();
}
