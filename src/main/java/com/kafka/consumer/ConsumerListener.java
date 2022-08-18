package com.kafka.consumer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

//@ConditionalOnProperty(value = "kafka.enabled", matchIfMissing = true)
@Component
public class ConsumerListener implements Serializable {

    @KafkaListener(topics = "demo", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Message in group - group-id: " + message);
    }

//    @KafkaListener(id = "foo", topics = "demo", groupId = "group_id",
//            containerFactory = "kafkaListenerContainerFactory",autoStartup = "true")
//    public void consume(String message) {
//        System.out.println("Consumed message: " + message);
//    }

}

