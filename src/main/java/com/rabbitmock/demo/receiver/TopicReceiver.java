package com.rabbitmock.demo.receiver;

import com.rabbitmock.demo.config.TopicConfig;
import com.rabbitmock.demo.pojo.Goods;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE1)
    public void receiveTopic1(Goods goods) {
        System.out.println("receiveTopic1收到消息：" + goods.toString());
    }

    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE2)
    public void receiveTopic2(Goods goods) {
        System.out.println("receiveTopic2收到消息：" + goods.toString());
    }
}
