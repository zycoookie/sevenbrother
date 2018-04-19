package me.sevenbrother.server.rabbitmq.listener;

import me.sevenbrother.server.domain.User;
import org.springframework.stereotype.Component;

@Component
public class SevenBrotherMessageListener {

    private void receiveMessage(User msg){
        System.out.println(msg);
    }

}
