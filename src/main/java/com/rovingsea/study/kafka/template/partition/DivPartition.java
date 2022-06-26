package com.rovingsea.study.kafka.template.partition;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * 例如需要将包含rovingsea的value字段专门发送到0号分区
 *
 * @author Haixin Wu
 * @since 1.0
 */
public class DivPartition implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        String msgValues = value.toString();
        int partition;
        if (msgValues.equals("rovingsea")) {
            partition = 0;
        } else {
            partition = -1; // 其他处理
        }
        return partition;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}

