package com.rabbitmock.demo.module;

import com.rabbitmock.demo.config.TopicConfig;
import com.rabbitmock.demo.pojo.Goods;
import com.rabbitmock.demo.sender.TopicSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class RabbitmqMockerTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    private TopicSender topicSender;

    @Test
    @DisplayName("测试发送消息")
    public void testSend() {
        topicSender.sendTopicQueue();
    }

    @Test
    @DisplayName("测试接收消息")
    public void testReceive() {
        Goods goods3 = new Goods(3L,"测试商品3",198.6);
        this.amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE, "topic.messge", goods3 );
        Goods goods = (Goods)amqpTemplate.receiveAndConvert("topic.queue1");
        System.out.println("goods begin");
        System.out.println(goods);
        assertThat(goods.getGoodsId(), equalTo(3L));
    }

}