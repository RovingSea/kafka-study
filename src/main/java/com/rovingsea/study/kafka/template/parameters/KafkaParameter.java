package com.rovingsea.study.kafka.template.parameters;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author Haixin Wu
 * @since 1.0
 */
public class KafkaParameter {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // 序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 缓冲区大小，相当于仓库
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        // 批次大小，相当于每次拉的大小
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        // linger.ms，最多等多久开始拉货
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        // 压缩，默认none，有 gzip，snappy，lz4，zstd 等方式
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
    }
}

