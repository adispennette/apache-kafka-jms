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
import java.util.HashMap;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaTextMessage extends KafkaMessage implements TextMessage{
	private String payload;
	
	public KafkaTextMessage() {
		headers = new HashMap<>();
		headers.put(PROPERTIES, new HashMap<String,Serializable>());
	}
	
	/* (non-Javadoc)
	 * @see javax.jms.Message#clearBody()
	 */
	@Override
	public void clearBody() throws JMSException {
		payload = null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getBody(java.lang.Class)
	 */
	@Override
	public <T> T getBody(Class<T> c) throws JMSException {
		return (T) payload;
	}

	/* (non-Javadoc)
	 * @see javax.jms.TextMessage#setText(java.lang.String)
	 */
	@Override
	public void setText(String string) throws JMSException {
		payload = string;
	}

	/* (non-Javadoc)
	 * @see javax.jms.TextMessage#getText()
	 */
	@Override
	public String getText() throws JMSException {
		return payload;
	}
	
}
