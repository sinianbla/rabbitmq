package com.sinianbla.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;

public class ReceiveMessage {
	private static String QUEUE = "hello";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();
		Consumer consumer = new DefaultConsumer(channel);
		while (true) {
			String message = channel.basicConsume(QUEUE, consumer);
			System.out.println("recived : " + message);
		}
	}
}
