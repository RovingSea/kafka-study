package com.rovingsea.study.kafka.springboot.template.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author Haixin Wu
 * @since 1.0
 */
@Configuration
public class KafkaConsumer {

    @KafkaListener(topics = "first")
    public void consumerTopic(String msg) {
        System.out.println("收到消息" + msg);
    }


}

