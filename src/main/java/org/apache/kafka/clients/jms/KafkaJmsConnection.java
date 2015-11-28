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

import javax.jms.Connection;
import javax.jms.ConnectionConsumer;
import javax.jms.ConnectionMetaData;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.ServerSessionPool;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.kafka.clients.producer.ProducerConfig;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaJmsConnection implements Connection{
	private Properties config;
	private Session session;
	/**
	 * @param config
	 */
	public KafkaJmsConnection(Properties config) {
		this.config = config;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createSession(boolean, int)
	 */
	@Override
	public Session createSession(boolean transacted, int acknowledgeMode)
			throws JMSException {
		return createSession();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createSession(int)
	 */
	@Override
	public Session createSession(int sessionMode) throws JMSException {
		return createSession();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createSession()
	 */
	@Override
	public Session createSession() throws JMSException {
		session = new KafkaJmsSession(config);
		return session;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getClientID()
	 */
	@Override
	public String getClientID() throws JMSException {
		return (String) config.get(ProducerConfig.CLIENT_ID_CONFIG);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#setClientID(java.lang.String)
	 */
	@Override
	public void setClientID(String clientID) throws JMSException {
		config.put(ProducerConfig.CLIENT_ID_CONFIG, clientID);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getMetaData()
	 */
	@Override
	public ConnectionMetaData getMetaData() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getExceptionListener()
	 */
	@Override
	public ExceptionListener getExceptionListener() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#setExceptionListener(javax.jms.ExceptionListener)
	 */
	@Override
	public void setExceptionListener(ExceptionListener listener)
			throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#start()
	 */
	@Override
	public void start() throws JMSException {
		// TODO create session pool
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#stop()
	 */
	@Override
	public void stop() throws JMSException {
		close();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#close()
	 */
	@Override
	public void close() throws JMSException {
		session.close();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createConnectionConsumer(javax.jms.Destination, java.lang.String, javax.jms.ServerSessionPool, int)
	 */
	@Override
	public ConnectionConsumer createConnectionConsumer(Destination destination,
			String messageSelector, ServerSessionPool sessionPool,
			int maxMessages) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createSharedConnectionConsumer(javax.jms.Topic, java.lang.String, java.lang.String, javax.jms.ServerSessionPool, int)
	 */
	@Override
	public ConnectionConsumer createSharedConnectionConsumer(Topic topic,
			String subscriptionName, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createDurableConnectionConsumer(javax.jms.Topic, java.lang.String, java.lang.String, javax.jms.ServerSessionPool, int)
	 */
	@Override
	public ConnectionConsumer createDurableConnectionConsumer(Topic topic,
			String subscriptionName, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createSharedDurableConnectionConsumer(javax.jms.Topic, java.lang.String, java.lang.String, javax.jms.ServerSessionPool, int)
	 */
	@Override
	public ConnectionConsumer createSharedDurableConnectionConsumer(
			Topic topic, String subscriptionName, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

}
