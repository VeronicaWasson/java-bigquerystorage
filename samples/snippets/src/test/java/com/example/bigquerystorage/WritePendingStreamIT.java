
package com.example.bigquerystorage;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WritePendingStreamIT {

  private static final String BIGQUERY_PROJECT_NAME = System.getenv("BIGQUERY_PROJECT_NAME");
  private static final String BIGQUERY_DATASET_NAME = System.getenv("BIGQUERY_DATASET_NAME");
  private static final String BIGQUERY_TABLE_NAME = System.getenv("BIGQUERY_TABLE_NAME");

  @Test
  public void testWritePendingStream() throws Exception {
    WritePendingStream.writePendingStream(BIGQUERY_PROJECT_NAME, BIGQUERY_DATASET_NAME, BIGQUERY_TABLE_NAME);
  }
}

