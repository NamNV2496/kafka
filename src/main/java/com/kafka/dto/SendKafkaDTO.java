package com.kafka.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendKafkaDTO {
    private String topic;
    private int partition;
    private String message;
}
