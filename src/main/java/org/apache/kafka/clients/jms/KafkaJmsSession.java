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

import java.io.Serializable;
import java.util.Properties;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaJmsSession implements Session{
	private Properties config;
	private KafkaMessageProducer producer;
	private KafkaMessageConsumer consumer;
	
	private MessageListener listener;

	/**
	 * @param config
	 */
	public KafkaJmsSession(Properties config) {
		this.config = config;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBytesMessage()
	 */
	@Override
	public BytesMessage createBytesMessage() throws JMSException {
		return new KafkaBytesMessage();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createMapMessage()
	 */
	@Override
	public MapMessage createMapMessage() throws JMSException {
		return new KafkaMapMessage();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createMessage()
	 */
	@Override
	public Message createMessage() throws JMSException {
		return createObjectMessage();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createObjectMessage()
	 */
	@Override
	public ObjectMessage createObjectMessage() throws JMSException {
		return new KafkaObjectMessage();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createObjectMessage(java.io.Serializable)
	 */
	@Override
	public ObjectMessage createObjectMessage(Serializable object)
			throws JMSException {
		KafkaObjectMessage msg = new KafkaObjectMessage();
		msg.setObject(object);
		return msg;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createStreamMessage()
	 */
	@Override
	public StreamMessage createStreamMessage() throws JMSException {
		return new KafkaStreamMessage();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTextMessage()
	 */
	@Override
	public TextMessage createTextMessage() throws JMSException {
		return new KafkaTextMessage();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTextMessage(java.lang.String)
	 */
	@Override
	public TextMessage createTextMessage(String text) throws JMSException {
		KafkaTextMessage msg = new KafkaTextMessage();
		msg.setText(text);
		return msg;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getTransacted()
	 */
	@Override
	public boolean getTransacted() throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getAcknowledgeMode()
	 */
	@Override
	public int getAcknowledgeMode() throws JMSException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#commit()
	 */
	@Override
	public void commit() throws JMSException {
		consumer.commit();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#rollback()
	 */
	@Override
	public void rollback() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#close()
	 */
	@Override
	public void close() throws JMSException {
		try{
			producer.close();
			consumer.close();
		}catch(Exception e){}
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#recover()
	 */
	@Override
	public void recover() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getMessageListener()
	 */
	@Override
	public MessageListener getMessageListener() throws JMSException {
		return listener;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#setMessageListener(javax.jms.MessageListener)
	 */
	@Override
	public void setMessageListener(MessageListener listener)
			throws JMSException {
		this.listener = listener;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createProducer(javax.jms.Destination)
	 */
	@Override
	public MessageProducer createProducer(Destination destination)
			throws JMSException {
		producer = new KafkaMessageProducer(config,destination);
		return producer;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination)
	 */
	@Override
	public MessageConsumer createConsumer(Destination destination)
			throws JMSException {
		consumer = new KafkaMessageConsumer(config, destination);
		return consumer;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination, java.lang.String)
	 */
	@Override
	public MessageConsumer createConsumer(Destination destination,
			String messageSelector) throws JMSException {
		return createConsumer(destination);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination, java.lang.String, boolean)
	 */
	@Override
	public MessageConsumer createConsumer(Destination destination,
			String messageSelector, boolean noLocal) throws JMSException {
		return createConsumer(destination);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createSharedConsumer(javax.jms.Topic, java.lang.String)
	 */
	@Override
	public MessageConsumer createSharedConsumer(Topic topic,
			String sharedSubscriptionName) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createSharedConsumer(javax.jms.Topic, java.lang.String, java.lang.String)
	 */
	@Override
	public MessageConsumer createSharedConsumer(Topic topic,
			String sharedSubscriptionName, String messageSelector)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createQueue(java.lang.String)
	 */
	@Override
	public Queue createQueue(String queueName) throws JMSException {
		return new KafkaJmsQueue(queueName);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTopic(java.lang.String)
	 */
	@Override
	public Topic createTopic(String topicName) throws JMSException {
		return new KafkaJmsTopic(topicName);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createDurableSubscriber(javax.jms.Topic, java.lang.String)
	 */
	@Override
	public TopicSubscriber createDurableSubscriber(Topic topic, String name)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createDurableSubscriber(javax.jms.Topic, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public TopicSubscriber createDurableSubscriber(Topic topic, String name,
			String messageSelector, boolean noLocal) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createDurableConsumer(javax.jms.Topic, java.lang.String)
	 */
	@Override
	public MessageConsumer createDurableConsumer(Topic topic, String name)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createDurableConsumer(javax.jms.Topic, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public MessageConsumer createDurableConsumer(Topic topic, String name,
			String messageSelector, boolean noLocal) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createSharedDurableConsumer(javax.jms.Topic, java.lang.String)
	 */
	@Override
	public MessageConsumer createSharedDurableConsumer(Topic topic, String name)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createSharedDurableConsumer(javax.jms.Topic, java.lang.String, java.lang.String)
	 */
	@Override
	public MessageConsumer createSharedDurableConsumer(Topic topic,
			String name, String messageSelector) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBrowser(javax.jms.Queue)
	 */
	@Override
	public QueueBrowser createBrowser(Queue queue) throws JMSException {
		throw new UnsupportedOperationException("Browsing is not supported for Kafka");
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBrowser(javax.jms.Queue, java.lang.String)
	 */
	@Override
	public QueueBrowser createBrowser(Queue queue, String messageSelector)
			throws JMSException {
		throw new UnsupportedOperationException("Browsing is not supported for Kafka");
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTemporaryQueue()
	 */
	@Override
	public TemporaryQueue createTemporaryQueue() throws JMSException {
		throw new UnsupportedOperationException("Temporary queues are not supported for Kafka");
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTemporaryTopic()
	 */
	@Override
	public TemporaryTopic createTemporaryTopic() throws JMSException {
		throw new UnsupportedOperationException("Temporary topics are not supported for Kafka");
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#unsubscribe(java.lang.String)
	 */
	@Override
	public void unsubscribe(String name) throws JMSException {
		consumer.unsubscribe();
	}

}
