package com.app.rtc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);
    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    public ChatController(StringRedisTemplate redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public record ChatMessage(String sender, String content, String timestamp) {}

    @MessageMapping("/sendMessage")
    public void broadcast(@Payload ChatMessage chatMessage) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(chatMessage);
            log.info("Publishing to Redis: {}", jsonMessage);
            redisTemplate.convertAndSend(RedisConfig.CHAT_TOPIC, jsonMessage);
        } catch (Exception e) {
            log.error("Error publishing message", e);
        }
    }
}
