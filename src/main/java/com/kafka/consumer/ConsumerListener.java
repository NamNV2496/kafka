package com.kafka.consumer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.io.Serializable;

//@ConditionalOnProperty(value = "kafka.enabled", matchIfMissing = true)
@Component
public class ConsumerListener implements Serializable {

    @KafkaListener(
            topicPartitions = {
                    @TopicPartition(
                            topic = "demo",
                            partitionOffsets = {
                                    @PartitionOffset(partition = "0", initialOffset = "1")
                            }),
                    @TopicPartition(
                            topic = "topic1",
                            partitionOffsets = {
                                    @PartitionOffset(partition = "1", initialOffset = "0")
                            })
            })
    public void listen(String message) {
        System.out.println("Received Message in group - group-id data: " + message);
    }

//    @KafkaListener(topics = "demo, topic1, topic2",groupId = "group-id")
//    public void consume(String message) {
//        System.out.println("Consumed message: " + message);
//    }

}

