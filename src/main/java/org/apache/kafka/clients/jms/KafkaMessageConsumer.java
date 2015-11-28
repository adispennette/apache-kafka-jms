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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaMessageConsumer implements MessageConsumer {
	private Consumer<String, Message> consumer;
	private KafkaDestination destination;
	
	/**
	 * consumer config should define a group Id
	 */
	public KafkaMessageConsumer(Properties config, Destination destination) {
		consumer = new KafkaConsumer<String, Message>(config);
		this.destination = destination;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#getMessageSelector()
	 */
	@Override
	public String getMessageSelector() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#getMessageListener()
	 */
	@Override
	public MessageListener getMessageListener() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#setMessageListener(javax.jms.MessageListener)
	 */
	@Override
	public void setMessageListener(MessageListener listener)
			throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receive()
	 */
	@Override
	public Message receive() throws JMSException {
		Map<String, ConsumerRecords<String, Message>> records = null;
		while(null == records) {
			records = consumer.poll(0);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receive(long)
	 */
	@Override
	public Message receive(long timeout) throws JMSException {
		// Map<"topic name", ConsumerRecords<"trace_id", KafkaMessage>>
		Map<String, ConsumerRecords<String, Message>> records = consumer.poll(timeout);
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receiveNoWait()
	 */
	@Override
	public Message receiveNoWait() throws JMSException {
		return receive(0);
	}
	
	private Map<Integer, Long> process(List<ConsumerRecord> records) throws Exception {
		Map<Integer, Long> processedOffsets = new HashMap<Integer, Long>();
		for (int i = 0; i < records.size(); i++) {
			ConsumerRecord record = records.get(i);
			// user specific logic to process record
			processedOffsets.put(record.partition(), record.offset());
		}
		return processedOffsets;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#close()
	 */
	@Override
	public void close() throws JMSException {
		consumer.close();
	}
	
	void subscribe() throws JMSException{
		consumer.subscribe(destination.getName());
	}
	
	void unsubscribe() throws JMSException{
		consumer.unsubscribe(destination.getName());
	}

}
