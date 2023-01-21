package com.orange.offsetexplorer.plugin;

import com.kafkatool.external.ICustomMessageDecorator2;
import org.apache.avro.Conversions;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;

import java.util.Map;

public class GenericAvroReader implements ICustomMessageDecorator2 {
    @Override
    public String getDisplayName() {
        return "GenericAvroDecoder";
    }

    @Override
    public String decorate(String zookeeperHost,
                           String brokerHost,
                           String topic,
                           long partitionId,
                           long offset,
                           byte[] bytes,
                           Map<String, byte[]> headers,
                           Map<String, String> reserved) {
        try {
            configureGenericData();
            StringBuilder sb = new StringBuilder();

            DatumReader<GenericRecord> datumReader = new GenericDatumReader<>();
            try (DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(new SeekableByteArrayInput(bytes), datumReader)) {
                while (dataFileReader.hasNext()) {
                    String nextRecord = dataFileReader.next().toString();
                    nextRecord = nextRecord.replace("\\r", "\r");
                    nextRecord = nextRecord.replace("\\n", "\n");
                    sb.append(nextRecord).append(System.lineSeparator());
                }
            }

            return sb.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }

    private void configureGenericData() {
        GenericData.get().addLogicalTypeConversion(new Conversions.DecimalConversion());
        GenericData.get().addLogicalTypeConversion(new Conversions.UUIDConversion());
        GenericData.get().addLogicalTypeConversion(new TimeConversions.TimeMicrosConversion());
        GenericData.get().addLogicalTypeConversion(new TimeConversions.TimeMillisConversion());
        GenericData.get().addLogicalTypeConversion(new TimeConversions.TimestampMicrosConversion());
        GenericData.get().addLogicalTypeConversion(new TimeConversions.TimestampMillisConversion());
    }
}
