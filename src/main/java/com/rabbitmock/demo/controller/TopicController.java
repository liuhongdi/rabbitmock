package com.rabbitmock.demo.controller;


import com.rabbitmock.demo.sender.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicSender topicSender;

    @GetMapping("/send")
    public String topicTest() {
        topicSender.sendTopicQueue();
        return "消息已发送";
    }
}