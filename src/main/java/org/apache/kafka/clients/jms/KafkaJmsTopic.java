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
import javax.jms.Topic;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaJmsTopic implements Topic,KafkaDestination {
	private String topicName;
	
	/**
	 * @param topicName
	 */
	public KafkaJmsTopic(String topicName) {
		super();
		this.topicName = topicName;
	}

	public void setTopicName(String topicName){
		this.topicName=topicName;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Topic#getTopicName()
	 */
	@Override
	public String getTopicName() throws JMSException {
		return topicName;
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.clients.jms.KafkaDestination#getName()
	 */
	@Override
	public String getName() throws JMSException {
		return getTopicName();
	}

}
