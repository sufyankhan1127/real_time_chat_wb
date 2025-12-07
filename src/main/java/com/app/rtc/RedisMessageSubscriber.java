package com.app.rtc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber {

    private static final Logger log = LoggerFactory.getLogger(RedisMessageSubscriber.class);
    private final SimpMessagingTemplate messagingTemplate;

    public RedisMessageSubscriber(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void onMessage(String message) {
        log.info("Redis Received: {}", message);
        messagingTemplate.convertAndSend("/topic/public", message);
    }
}
