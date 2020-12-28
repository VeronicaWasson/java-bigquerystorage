package com.example.bigquerystorage;

import com.google.cloud.bigquery.*;
import com.google.cloud.bigquery.Schema;

import com.google.cloud.bigquery.storage.v1beta2.*;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.api.core.ApiFuture;


public class WriteCommittedStream  {

  public static void main(String... args) {
    // Sets your Google Cloud Platform project ID.
    // String projectId = "YOUR_PROJECT_ID";
    String projectId = args[0];

    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";

    writeCommittedStream(projectId, datasetName, tableName);
 }

 public static void writeCommittedStream(
     String projectId, String datasetName, String tableName)
 {

    try (BigQueryWriteClient client = BigQueryWriteClient.create()) {

      WriteStream stream = WriteStream.newBuilder()
        .setType(WriteStream.Type.COMMITTED)
	.build();

      TableName parent = TableName.of(projectId,datasetName,tableName);

      CreateWriteStreamRequest createWriteStreamRequest = CreateWriteStreamRequest.newBuilder()
        .setParent(parent.toString())
	.setWriteStream(stream)
	.build();
      WriteStream writeStream = client.createWriteStream(createWriteStreamRequest);

      try (JsonStreamWriter writer = JsonStreamWriter.newBuilder(
	  writeStream.getName(),
	  writeStream.getTableSchema(),
	  client).build()) {

        for (int i = 0; i < 10; i++) {
          JSONObject record = new JSONObject();
          record.put("col1", String.format("record %03d",i));
          JSONArray jsonArr = new JSONArray();
          jsonArr.put(record); 

          ApiFuture<AppendRowsResponse> future = writer.append(jsonArr,false);
          AppendRowsResponse response = future.get();
      
        }
      }
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void writeToDefaultStream(
    String projectId, String datasetName, String tableName) {

    TableName parent = TableName.of(projectId, datasetName, tableName);

    TableInfo tableInfo = TableInfo.newBuilder(
		    TableId.of(datasetName, tableName),
		    StandardTableDefinition.of(
			    Schema.of(
				    Field.newBuilder("col1", StandardSQLTypeName.STRING)
				        .setMode(Field.Mode.NULLABLE)
					.build())))
	    .build();
    
   // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
   // Table table = bigquery.getTable(datasetName, tableName);
    //Schema schema = table.getDefinition().getSchema();

    Schema schema2 = tableInfo.getDefinition().getSchema();

    try (JsonStreamWriter writer = JsonStreamWriter.newBuilder(parent.toString(),schema2)
        .createDefaultStream()
	.build())
    {
    
        for (int i = 0; i < 10; i++) {
          JSONObject record = new JSONObject();
          record.put("col1", String.format("00-default-record %03d",i));
          JSONArray jsonArr = new JSONArray();
          jsonArr.put(record); 

          ApiFuture<AppendRowsResponse> future = writer.append(jsonArr,false);
          AppendRowsResponse response = future.get();
	}
    }
    catch (Exception e) {
	    System.out.println(e);
    }

  }
  
}
