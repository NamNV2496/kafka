package com.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class Producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, int partition, String message) {
//        ListenableFuture<SendResult<String, String >> future = kafkaTemplate.send(topic,  message);
        ListenableFuture<SendResult<String, String >> future = kafkaTemplate.send(topic, partition, "key",  message);
        try {
            log.info("check request with timeout 10s");
            future.get(10, TimeUnit.SECONDS);
            log.info("Send request is done: " + future.isDone());
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // add callback
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("call send successful!");
            }

            @SneakyThrows
            @Override
            public void onFailure(Throwable ex) {
                throw new Exception("fail");
            }
        });
    }

}
