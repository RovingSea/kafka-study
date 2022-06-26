package com.rovingsea.study.kafka.template.asycn;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Haixin Wu
 * @since 1.0
 */
public class ProducerCallback {
    public static void main(String[] args) throws InterruptedException {
        // 1. 创建 kafka 生产者的配置对象
        Properties properties = new Properties();
        // 2. 给 kafka 配置对象添加配置信息：bootstrap.server
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "180.76.136.123:9092");
        // 3. key, value 序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        // 4. 创建 kafka 生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        // 5. 调用 send 方法，进行测试
        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("first", "rovingsea" + i), new Callback() {
                // 该方法在 Producer 收到 ack 时调用，为异步调用
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        System.out.println("主题：" + recordMetadata.topic() + "->" + "分区" + recordMetadata.partition());;
                    } else {
                        e.printStackTrace();
                    }
                }
            });
            // 延迟一会看到数据发往不同分区
            TimeUnit.SECONDS.sleep(1);
        }
        // 6. 关闭资源
        kafkaProducer.close();

    }
}

