package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @GetMapping("send")
    public void sendMessage() {
        kafkaTemplate.send("demo", "kafka");
    }
}
