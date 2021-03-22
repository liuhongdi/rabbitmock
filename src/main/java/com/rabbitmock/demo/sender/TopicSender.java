package com.rabbitmock.demo.sender;

import com.rabbitmock.demo.config.TopicConfig;
import com.rabbitmock.demo.pojo.Goods;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {
    //private static final Logger log = LoggerFactory.getLogger(TopicSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendTopicQueue() {
        Goods goods1 = new Goods(1L,"测试商品1",98.6);
        Goods goods2 = new Goods(2L,"测试商品2",100.0);
        System.out.println("TopicSender已发送消息");
        // 第一个参数：TopicExchange名字
        // 第二个参数：Route-Key
        // 第三个参数：要发送的内容
        this.amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE, "topic.messge", goods1 );
        this.amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE, "topic.messge2", goods2);
    }
}
