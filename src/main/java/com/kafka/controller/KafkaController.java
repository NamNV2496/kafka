package com.kafka.controller;

import com.kafka.dto.SendKafkaDTO;
import com.kafka.producer.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class KafkaController {
    private final Producer producer;

    @GetMapping("send")
    public void send(@RequestBody SendKafkaDTO sendKafkaDTO) {
        producer.sendMessage(sendKafkaDTO.getTopic(),sendKafkaDTO.getPartition(), sendKafkaDTO.getMessage());
    }

}
