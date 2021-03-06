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
import javax.jms.ObjectMessage;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaObjectMessage extends KafkaMessage implements ObjectMessage{
	private Object payload;
	
	/**
	 * 
	 */
	public KafkaObjectMessage() {
		headers = new HashMap<>();
		headers.put(PROPERTIES, new HashMap<String,Serializable>());
	}
	
	/* (non-Javadoc)
	 * @see javax.jms.Message#clearBody()
	 */
	@Override
	public void clearBody() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getBody(java.lang.Class)
	 */
	@Override
	public <T> T getBody(Class<T> c) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.ObjectMessage#setObject(java.io.Serializable)
	 */
	@Override
	public void setObject(Serializable object) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.ObjectMessage#getObject()
	 */
	@Override
	public Serializable getObject() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

}
