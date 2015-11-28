/* Original work Copyright (c) 2015 Al Dispennette 
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 */
package org.apache.kafka.clients.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.kafka.clients.jms.KafkaJmsConnectionFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaJmsConnectionFactoryTest {
	private ConnectionFactory factory;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		factory = new KafkaJmsConnectionFactory();
		((KafkaJmsConnectionFactory)factory).initializeConfig();
		//((KafkaJmsConnectionFactory)factory).setValueSerializerClass(StringSerializer.class.getName());
	}

	@Test
	public void test() throws JMSException {
		Connection con = factory.createConnection();
		Session session = con.createSession();
		Destination topic = session.createTopic("test");
		MessageProducer producer = session.createProducer(topic);
		TextMessage msg = session.createTextMessage();
		msg.setText("this is a test.");
		
		producer.send(msg);
		
		con.close();
	}

}
