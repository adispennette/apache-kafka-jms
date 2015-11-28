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

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * @author Al Dispennette
 * @since 1.0.0
 *
 */
public class KafkaJmsConnectionFactory implements ConnectionFactory {
	private static String DEFAULT_BROKER = "localhost:9092";
	private static String DEFAULT_VALUE_SERIALIZER = ObjectSerializer.class.getName();
	private static String DEFAULT_KEY_SERIALIZER = StringSerializer.class.getName();
	private Properties config;

	@PostConstruct
	protected void initializeConfig() {
		config = new Properties();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, DEFAULT_BROKER);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,DEFAULT_VALUE_SERIALIZER);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,DEFAULT_KEY_SERIALIZER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createConnection()
	 */
	@Override
	public Connection createConnection() throws JMSException {
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

	/**
	 * @return the brokerList
	 */
	public String getBroker() {
		return (String) config.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG);
	}

	/**
	 * @param brokerList
	 *            the brokerList to set
	 */
	public void setBroker(String broker) {
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, broker);
	}

	/**
	 * @return the serializerClass
	 */
	public String getValueSerializerClass() {
		return (String) config
				.get(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG);
	}

	/**
	 * @param serializerClass
	 *            the serializerClass to set
	 */
	public void setValueSerializerClass(String valueSerializerClass) {
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				valueSerializerClass);
	}

	/**
	 * @return the keySerializerClass
	 */
	public String getKeySerializerClass() {
		return (String) config.get(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG);
	}

	/**
	 * @param keySerializerClass
	 *            the keySerializerClass to set
	 */
	public void setKeySerializerClass(String keySerializerClass) {
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				keySerializerClass);
	}

	public String getAckConfig() {
		return (String) config.get(ProducerConfig.ACKS_CONFIG);
	}

	public void setAckConfig(String acks) {
		config.put(ProducerConfig.ACKS_CONFIG, acks);
	}

	public void setBatchSize(String value) {
		config.put(ProducerConfig.BATCH_SIZE_CONFIG, value);
	}

	public void setBlockOnBufferFull(String value) {
		config.put(ProducerConfig.BLOCK_ON_BUFFER_FULL_CONFIG, value);
	}

	public void setBufferMemory(String value) {
		config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, value);
	}

	public void setClientId(String value) {
		config.put(ProducerConfig.CLIENT_ID_CONFIG, value);
	}

	public void setCompressionType(String value) {
		config.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, value);
	}

	public void setLingerMilli(String value) {
		config.put(ProducerConfig.LINGER_MS_CONFIG, value);
	}

	public void setMaxInflightRequests(String value) {
		config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, value);
	}

	public void setMaxRequestSize(String value) {
		config.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, value);
	}

	public void setMetaDataFetchTimeout(String value) {
		config.put(ProducerConfig.METADATA_FETCH_TIMEOUT_CONFIG, value);
	}

	public void setMeteaDataMaxAge(String value) {
		config.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, value);
	}

	public void setMetricReporterClasses(String value) {
		config.put(ProducerConfig.METRIC_REPORTER_CLASSES_CONFIG, value);
	}

	public void setRecieveBuffer(String value) {
		config.put(ProducerConfig.RECEIVE_BUFFER_CONFIG, value);
	}

	public void setReconnectBackoffMilli(String value) {
		config.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, value);
	}

	public void setRetrieCount(String value) {
		config.put(ProducerConfig.RETRIES_CONFIG, value);
	}

	public void setRetryBackoffMillis(String value) {
		config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, value);
	}

	public void setSendBuffer(String value) {
		config.put(ProducerConfig.SEND_BUFFER_CONFIG, value);
	}

	public void setTimout(String value) {
		config.put(ProducerConfig.TIMEOUT_CONFIG, value);
	}
}
