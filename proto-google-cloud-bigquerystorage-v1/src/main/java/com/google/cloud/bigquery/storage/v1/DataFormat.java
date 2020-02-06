/*
 * Copyright 2020 Google LLC
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
// source: google/cloud/bigquery/storage/v1/stream.proto

package com.google.cloud.bigquery.storage.v1;

/**
 *
 *
 * <pre>
 * Data format for input or output data.
 * </pre>
 *
 * Protobuf enum {@code google.cloud.bigquery.storage.v1.DataFormat}
 */
public enum DataFormat implements com.google.protobuf.ProtocolMessageEnum {
  /** <code>DATA_FORMAT_UNSPECIFIED = 0;</code> */
  DATA_FORMAT_UNSPECIFIED(0),
  /**
   *
   *
   * <pre>
   * Avro is a standard open source row based file format.
   * See https://avro.apache.org/ for more details.
   * </pre>
   *
   * <code>AVRO = 1;</code>
   */
  AVRO(1),
  /**
   *
   *
   * <pre>
   * Arrow is a standard open source column-based message format.
   * See https://arrow.apache.org/ for more details.
   * </pre>
   *
   * <code>ARROW = 2;</code>
   */
  ARROW(2),
  UNRECOGNIZED(-1),
  ;

  /** <code>DATA_FORMAT_UNSPECIFIED = 0;</code> */
  public static final int DATA_FORMAT_UNSPECIFIED_VALUE = 0;
  /**
   *
   *
   * <pre>
   * Avro is a standard open source row based file format.
   * See https://avro.apache.org/ for more details.
   * </pre>
   *
   * <code>AVRO = 1;</code>
   */
  public static final int AVRO_VALUE = 1;
  /**
   *
   *
   * <pre>
   * Arrow is a standard open source column-based message format.
   * See https://arrow.apache.org/ for more details.
   * </pre>
   *
   * <code>ARROW = 2;</code>
   */
  public static final int ARROW_VALUE = 2;

  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static DataFormat valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static DataFormat forNumber(int value) {
    switch (value) {
      case 0:
        return DATA_FORMAT_UNSPECIFIED;
      case 1:
        return AVRO;
      case 2:
        return ARROW;
      default:
        return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<DataFormat> internalGetValueMap() {
    return internalValueMap;
  }

  private static final com.google.protobuf.Internal.EnumLiteMap<DataFormat> internalValueMap =
      new com.google.protobuf.Internal.EnumLiteMap<DataFormat>() {
        public DataFormat findValueByNumber(int number) {
          return DataFormat.forNumber(number);
        }
      };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }

  public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
    return getDescriptor();
  }

  public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
    return com.google.cloud.bigquery.storage.v1.StreamProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final DataFormat[] VALUES = values();

  public static DataFormat valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private DataFormat(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:google.cloud.bigquery.storage.v1.DataFormat)
}
