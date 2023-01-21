# GenericAvroDecoder

This is a plugin for [Offset Explorer](https://www.kafkatool.com),
inspired by the [Kafka Tool Avro](https://github.com/laymain/kafka-tool-avro)
plugin for the same [Offset Explorer](https://www.kafkatool.com)
and [IntelliJ Avro and Parquet Viewer Plugin](https://github.com/benwatson528/intellij-avro-parquet-plugin).

Unlike [Kafka Tool Avro](https://github.com/laymain/kafka-tool-avro), **GenericAvroDecoder** doesn't 
require a Schema Registry Endpoint. It just uses the schema stored inside the Avro data.

## Compilation

You will need [Maven](https://maven.apache.org/) for this:
1. Clone this repository.
2. Open a terminal and `cd` into the project's directory.
3. Run `mvn clean package`.

## Installation

The same as [here](https://www.kafkatool.com/documentation/plugins.html):

_Once you have compiled and packaged your jar, copy it to the 'plugins' folder in the Offset Explorer
installation folder. Restart Offset Explorer and navigate to the topic that you want to use 
the decorator with. In the 'Content Types' drop-downs you should see the name of your decorator.
Select it and click on 'Update'. 
After that, the messages/keys will be decorated using your custom decorator._
