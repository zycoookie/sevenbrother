package me.sevenbrother.server.rabbitmq.message;

import me.sevenbrother.server.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMessageConverter extends AbstractJsonMessageConverter<User> {

}
