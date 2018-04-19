package me.sevenbrother.server.rabbitmq.sender;

import me.sevenbrother.server.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SevenBrotherEvenPublisher {

    @Autowired
    private RabbitTemplate template;

    public void send(User user){
        template.convertAndSend("sevenbrother.even",user);
    }
}
