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

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 */
public class KafkaJmsConnectionFactory implements ConnectionFactory {
	private static final String DEFAULT_AUTO_COMMIT_INTERVAL = "10000";
	private static final String DEFAULT_ASSIGNMENT_STRATEGY = "range";
	private static final String DEFAULT_AUTO_COMMIT = "false";
	private static final String DEFAULT_TIMOUT = "1000";
	private static String DEFAULT_BROKER = "localhost:9092";
	private static String DEFAULT_VALUE_SERIALIZER = ObjectSerializer.class.getName();
	private static String DEFAULT_KEY_SERIALIZER = StringSerializer.class.getName();
	private static String DEFAULT_KEY_DESERIALIZER = StringDeserializer.class.getName();
	private KafkaConfigBuilder builder = new KafkaConfigBuilder();
	
	/**
	 * @return the builder
	 */
	public KafkaConfigBuilder getBuilder() {
		return builder;
	}

	private Properties config;

	@PostConstruct
	protected void initializeConfig() {
		builder.broker(DEFAULT_BROKER).valueSerializerClass(DEFAULT_VALUE_SERIALIZER)
			.keySerializerClass(DEFAULT_KEY_SERIALIZER).enableAuutoCommit(DEFAULT_AUTO_COMMIT)
			.autoCommitInterval(DEFAULT_AUTO_COMMIT_INTERVAL).keyDeserializerClass(DEFAULT_KEY_DESERIALIZER);
	}
	
	public void setGroupId(String value){
		builder.groupId(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createConnection()
	 */
	@Override
	public Connection createConnection() throws JMSException {
		config = builder.build();
		return new KafkaJmsConnection(config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createConnection(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Connection createConnection(String userName, String password)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createContext()
	 */
	@Override
	public JMSContext createContext() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createContext(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public JMSContext createContext(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createContext(java.lang.String,
	 * java.lang.String, int)
	 */
	@Override
	public JMSContext createContext(String userName, String password,
			int sessionMode) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createContext(int)
	 */
	@Override
	public JMSContext createContext(int sessionMode) {
		// TODO Auto-generated method stub
		return null;
	}

}
