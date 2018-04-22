package me.sevenbrother.server.rabbitmq.message;

import org.springframework.stereotype.Component;

@Component
public class StringMessageReceiver {

    public void onReceive(Object message){
        System.out.println(message);
    }
}
