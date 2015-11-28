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

import javax.jms.CompletionListener;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaMessageProducer implements MessageProducer {
	private static final int DEFAULT_PRIORITY = 4;
	private static final int DEFAULT_DELIERY_MODE = DeliveryMode.PERSISTENT;
	private static final int DEFAULT_TTL = 60000;
	private Producer<String, Message> producer;
	private Destination destination;
	private boolean disbledMessageId;
	private boolean disableMessageTimestamp;
	private int deliveryMode = DEFAULT_DELIERY_MODE;
	private int priority = DEFAULT_PRIORITY;
	private long timeToLive = DEFAULT_TTL;
	private long deliveryDelay;

	/**
	 * 
	 * @param config
	 * @param destination
	 */
	public KafkaMessageProducer(Properties config, Destination destination) {
		this.destination = destination;
		this.producer = new KafkaProducer<String, Message>(config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#setDisableMessageID(boolean)
	 */
	@Override
	public void setDisableMessageID(boolean value) throws JMSException {
		this.disbledMessageId = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#getDisableMessageID()
	 */
	@Override
	public boolean getDisableMessageID() throws JMSException {
		return this.disbledMessageId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#setDisableMessageTimestamp(boolean)
	 */
	@Override
	public void setDisableMessageTimestamp(boolean value) throws JMSException {
		this.disableMessageTimestamp = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#getDisableMessageTimestamp()
	 */
	@Override
	public boolean getDisableMessageTimestamp() throws JMSException {
		return this.disableMessageTimestamp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#setDeliveryMode(int)
	 */
	@Override
	public void setDeliveryMode(int deliveryMode) throws JMSException {
		this.deliveryMode = deliveryMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#getDeliveryMode()
	 */
	@Override
	public int getDeliveryMode() throws JMSException {
		return deliveryMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#setPriority(int)
	 */
	@Override
	public void setPriority(int defaultPriority) throws JMSException {
		this.priority = defaultPriority;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#getPriority()
	 */
	@Override
	public int getPriority() throws JMSException {
		// TODO Auto-generated method stub
		return priority;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#setTimeToLive(long)
	 */
	@Override
	public void setTimeToLive(long timeToLive) throws JMSException {
		this.timeToLive = timeToLive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#getTimeToLive()
	 */
	@Override
	public long getTimeToLive() throws JMSException {
		// producer.metrics().get(ProducerConfig.METADATA_MAX_AGE_CONFIG);
		return this.timeToLive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#setDeliveryDelay(long)
	 */
	@Override
	public void setDeliveryDelay(long deliveryDelay) throws JMSException {
		this.deliveryDelay = deliveryDelay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#getDeliveryDelay()
	 */
	@Override
	public long getDeliveryDelay() throws JMSException {
		return this.deliveryDelay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#getDestination()
	 */
	@Override
	public Destination getDestination() throws JMSException {
		return destination;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#close()
	 */
	@Override
	public void close() {
		producer.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#send(javax.jms.Message)
	 */
	@Override
	public void send(Message message) throws JMSException {
		send(destination, message, deliveryMode, priority, timeToLive);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#send(javax.jms.Message, int, int, long)
	 */
	@Override
	public void send(Message message, int deliveryMode, int priority,
			long timeToLive) throws JMSException {
		send(destination, message, deliveryMode, priority, timeToLive);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#send(javax.jms.Destination,
	 * javax.jms.Message)
	 */
	@Override
	public void send(Destination destination, Message message)
			throws JMSException {
		send(destination, message, deliveryMode, priority, timeToLive);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#send(javax.jms.Destination,
	 * javax.jms.Message, int, int, long)
	 */
	@Override
	public void send(Destination destination, Message message,
			int deliveryMode, int priority, long timeToLive)
			throws JMSException {
		String name = ((KafkaDestination) destination).getName();
		ProducerRecord<String, Message> data = new ProducerRecord<String, Message>(
				name, message.getStringProperty("traceId"), message);
		producer.send(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#send(javax.jms.Message,
	 * javax.jms.CompletionListener)
	 */
	@Override
	public void send(Message message, CompletionListener completionListener)
			throws JMSException {
		send(destination, message, deliveryMode, priority, timeToLive,
				completionListener);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#send(javax.jms.Message, int, int, long,
	 * javax.jms.CompletionListener)
	 */
	@Override
	public void send(Message message, int deliveryMode, int priority,
			long timeToLive, CompletionListener completionListener)
			throws JMSException {
		send(destination, message, deliveryMode, priority, timeToLive,
				completionListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#send(javax.jms.Destination,
	 * javax.jms.Message, javax.jms.CompletionListener)
	 */
	@Override
	public void send(Destination destination, Message message,
			CompletionListener completionListener) throws JMSException {
		send(destination, message, deliveryMode, priority, timeToLive,
				completionListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageProducer#send(javax.jms.Destination,
	 * javax.jms.Message, int, int, long, javax.jms.CompletionListener)
	 */
	@Override
	public void send(Destination destination, Message message,
			int deliveryMode, int priority, long timeToLive,
			CompletionListener completionListener) throws JMSException {
		String name = ((KafkaDestination) destination).getName();
		ProducerRecord<String, Message> data = new ProducerRecord<String, Message>(
				name, message.getStringProperty("traceId"), message);
		producer.send(data, new Callback() {
			@Override
			public void onCompletion(RecordMetadata rmd, Exception e) {
				if (null == e) {
					completionListener.onCompletion(message);
				} else {
					completionListener.onException(message, e);
				}
			}
		});
	}

}
