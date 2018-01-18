package com.sinianbla.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendMessage {
	
	private static String QUEUE = "hello";
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();
		String message = "sinianbla";
		channel.queueDeclare(QUEUE, false, false, false, null);
		channel.basicPublish("", QUEUE, null,message.getBytes("utf-8") );
		System.out.println("sending...");
		
		channel.close();
		conn.close();
	}
}
