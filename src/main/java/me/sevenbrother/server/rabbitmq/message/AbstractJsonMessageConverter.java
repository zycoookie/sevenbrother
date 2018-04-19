package me.sevenbrother.server.rabbitmq.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;


public abstract class AbstractJsonMessageConverter<T> implements MessageConverter {

    @Override
    public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
        return null;
    }

    @Override
    public T fromMessage(Message message) throws MessageConversionException {
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        String body = new String(message.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Class<T> tClass = (Class<T>) type.getActualTypeArguments()[0];
            return objectMapper.readValue(body, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
