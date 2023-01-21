package com.kafkatool.external;

import java.util.Map;

public interface ICustomMessageDecorator2 {
    String getDisplayName();
    String decorate(String zookeeperHost,
                    String brokerHost,
                    String topic,
                    long partitionId,
                    long offset,
                    byte[] bytes,
                    Map<String, byte[]> headers,
                    Map<String, String> reserved);
}
