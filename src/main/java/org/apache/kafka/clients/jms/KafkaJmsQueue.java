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

import javax.jms.JMSException;
import javax.jms.Queue;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaJmsQueue implements Queue,KafkaDestination {
	private String queueName;

	public KafkaJmsQueue(String queueName){
		this.queueName = queueName;
	}
	
	/* (non-Javadoc)
	 * @see javax.jms.Queue#getQueueName()
	 */
	@Override
	public String getQueueName() throws JMSException {
		return queueName;
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.clients.jms.KafkaDestination#getName()
	 */
	@Override
	public String getName() throws JMSException {
		return getQueueName();
	}

}
