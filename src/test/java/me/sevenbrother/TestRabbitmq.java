package me.sevenbrother;

import me.sevenbrother.server.rabbitmq.sender.SevenBrotherEvenPublisher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRabbitmq extends BaseTest {

    @Autowired
    private SevenBrotherEvenPublisher publisher;

    @Test
    public void testSend(){
        publisher.sendStringMessage("这是一条测试message1");
//        user.setId(2);
//        user.setFirstName("2");
//        user.setLastName("3");
//        publisher.send(user);
//        user.setId(3);
//        user.setFirstName("3");
//        user.setLastName("4");
//        publisher.send(user);
//        user.setId(4);
//        user.setFirstName("4");
//        user.setLastName("5");
//        publisher.send(user);
    }
}
