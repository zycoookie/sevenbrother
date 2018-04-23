package me.sevenbrother.server.rabbitmq.factory;

import me.sevenbrother.server.rabbitmq.listener.StringMessageListener;
import me.sevenbrother.server.rabbitmq.message.StringMessageReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

	private static final String exchange = "sevenbrother.even.exchange";

	private static final String queue = "sevenbrother.interesting";

	@Bean
	Queue queue() {
		return new Queue(queue, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("sevenbrother.even");
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queue);
		container.setMessageListener(new StringMessageListener());
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(StringMessageReceiver receiver) {
		MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "onReceive");
//		messageListenerAdapter.setMessageConverter(messageConverter);
		return messageListenerAdapter;
	}

}