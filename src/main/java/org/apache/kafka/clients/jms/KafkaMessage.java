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
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public abstract class KafkaMessage implements Message,Serializable{
	public static final String PROPERTIES = "properties";
	protected Map<String,Serializable> headers;
	
	@PostConstruct
	protected void verify(){
		if(headers == null){
			headers = new HashMap<String, Serializable>();
		}
		if(headers.get(PROPERTIES)==null){
			headers.put(PROPERTIES, new HashMap<String,Serializable>());
		}
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSMessageID()
	 */
	@Override
	public String getJMSMessageID() throws JMSException {
		return (String) headers.get(JmsHeaderKeys.JMSMessageID);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSMessageID(java.lang.String)
	 */
	@Override
	public void setJMSMessageID(String id) throws JMSException {
		headers.put(JmsHeaderKeys.JMSMessageID,id);
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSTimestamp()
	 */
	@Override
	public long getJMSTimestamp() throws JMSException {
		return (Long) headers.get(JmsHeaderKeys.JMSTimestamp);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSTimestamp(long)
	 */
	@Override
	public void setJMSTimestamp(long timestamp) throws JMSException {
		headers.put(JmsHeaderKeys.JMSTimestamp,timestamp);
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSCorrelationIDAsBytes()
	 */
	@Override
	public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
		return ((String)headers.get(JmsHeaderKeys.JMSCorrelationID)).getBytes();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSCorrelationIDAsBytes(byte[])
	 */
	@Override
	public void setJMSCorrelationIDAsBytes(byte[] correlationID)
			throws JMSException {
		headers.put(JmsHeaderKeys.JMSCorrelationID,new String(correlationID));
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSCorrelationID(java.lang.String)
	 */
	@Override
	public void setJMSCorrelationID(String correlationID) throws JMSException {
		headers.put(JmsHeaderKeys.JMSCorrelationID,correlationID);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSCorrelationID()
	 */
	@Override
	public String getJMSCorrelationID() throws JMSException {
		return (String) headers.get((String) JmsHeaderKeys.JMSCorrelationID);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSReplyTo()
	 */
	@Override
	public Destination getJMSReplyTo() throws JMSException {
		return (Destination) headers.get(JmsHeaderKeys.JMSReplyTo);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSReplyTo(javax.jms.Destination)
	 */
	@Override
	public void setJMSReplyTo(Destination replyTo) throws JMSException {
		if (replyTo instanceof KafkaDestination) {
			headers.put(JmsHeaderKeys.JMSReplyTo,(KafkaDestination)replyTo);
		}
		throw new JMSException("Unsuported Destination type.");
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSDestination()
	 */
	@Override
	public Destination getJMSDestination() throws JMSException {
		return (Destination) headers.get(JmsHeaderKeys.JMSDestination);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSDestination(javax.jms.Destination)
	 */
	@Override
	public void setJMSDestination(Destination destination) throws JMSException {
		if (destination instanceof KafkaDestination) {
			headers.put(JmsHeaderKeys.JMSDestination,(KafkaDestination)destination);
		}
		throw new JMSException("Unsuported Destination type.");
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSDeliveryMode()
	 */
	@Override
	public int getJMSDeliveryMode() throws JMSException {
		return (Integer) headers.get(JmsHeaderKeys.JMSDeliveryMode);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSDeliveryMode(int)
	 */
	@Override
	public void setJMSDeliveryMode(int deliveryMode) throws JMSException {
		headers.put(JmsHeaderKeys.JMSDeliveryMode,deliveryMode);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSRedelivered()
	 */
	@Override
	public boolean getJMSRedelivered() throws JMSException {
		return (Boolean) headers.get(JmsHeaderKeys.JMSRedelivered);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSRedelivered(boolean)
	 */
	@Override
	public void setJMSRedelivered(boolean redelivered) throws JMSException {
		headers.put(JmsHeaderKeys.JMSRedelivered,redelivered);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSType()
	 */
	@Override
	public String getJMSType() throws JMSException {
		return (String) headers.get(JmsHeaderKeys.JMSType);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSType(java.lang.String)
	 */
	@Override
	public void setJMSType(String type) throws JMSException {
		headers.put(JmsHeaderKeys.JMSType,type);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSExpiration()
	 */
	@Override
	public long getJMSExpiration() throws JMSException {
		return (Long) headers.get(JmsHeaderKeys.JMSExpiration);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSExpiration(long)
	 */
	@Override
	public void setJMSExpiration(long expiration) throws JMSException {
		headers.put(JmsHeaderKeys.JMSExpiration,expiration);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSDeliveryTime()
	 */
	@Override
	public long getJMSDeliveryTime() throws JMSException {
		return (Long)headers.get(JmsHeaderKeys.JMSDeliveryTime);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSDeliveryTime(long)
	 */
	@Override
	public void setJMSDeliveryTime(long deliveryTime) throws JMSException {
		headers.put(JmsHeaderKeys.JMSDeliveryTime,deliveryTime);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSPriority()
	 */
	@Override
	public int getJMSPriority() throws JMSException {
		return (Integer) headers.get(JmsHeaderKeys.JMSPriority);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSPriority(int)
	 */
	@Override
	public void setJMSPriority(int priority) throws JMSException {
		headers.put(JmsHeaderKeys.JMSPriority,priority);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#clearProperties()
	 */
	@Override
	public void clearProperties() throws JMSException {
		((Map)headers.get(PROPERTIES)).clear();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#propertyExists(java.lang.String)
	 */
	@Override
	public boolean propertyExists(String name) throws JMSException {
		return ((Map)headers.get(PROPERTIES)).containsKey(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getBooleanProperty(java.lang.String)
	 */
	@Override
	public boolean getBooleanProperty(String name) throws JMSException {
		return (Boolean)((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getByteProperty(java.lang.String)
	 */
	@Override
	public byte getByteProperty(String name) throws JMSException {
		return (Byte)((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getShortProperty(java.lang.String)
	 */
	@Override
	public short getShortProperty(String name) throws JMSException {
		return (Short)((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getIntProperty(java.lang.String)
	 */
	@Override
	public int getIntProperty(String name) throws JMSException {
		return (Integer)((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getLongProperty(java.lang.String)
	 */
	@Override
	public long getLongProperty(String name) throws JMSException {
		return (Long)((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getFloatProperty(java.lang.String)
	 */
	@Override
	public float getFloatProperty(String name) throws JMSException {
		return (Float)((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getDoubleProperty(java.lang.String)
	 */
	@Override
	public double getDoubleProperty(String name) throws JMSException {
		return (Double)((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getStringProperty(java.lang.String)
	 */
	@Override
	public String getStringProperty(String name) throws JMSException {
		return (String)((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getObjectProperty(java.lang.String)
	 */
	@Override
	public Object getObjectProperty(String name) throws JMSException {
		return ((Map)headers.get(PROPERTIES)).get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getPropertyNames()
	 */
	@Override
	public Enumeration getPropertyNames() throws JMSException {
		return Collections.enumeration(((Map)headers.get(PROPERTIES)).keySet());
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setBooleanProperty(java.lang.String, boolean)
	 */
	@Override
	public void setBooleanProperty(String name, boolean value)
			throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setByteProperty(java.lang.String, byte)
	 */
	@Override
	public void setByteProperty(String name, byte value) throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setShortProperty(java.lang.String, short)
	 */
	@Override
	public void setShortProperty(String name, short value) throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setIntProperty(java.lang.String, int)
	 */
	@Override
	public void setIntProperty(String name, int value) throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setLongProperty(java.lang.String, long)
	 */
	@Override
	public void setLongProperty(String name, long value) throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setFloatProperty(java.lang.String, float)
	 */
	@Override
	public void setFloatProperty(String name, float value) throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setDoubleProperty(java.lang.String, double)
	 */
	@Override
	public void setDoubleProperty(String name, double value)
			throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setStringProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public void setStringProperty(String name, String value)
			throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setObjectProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setObjectProperty(String name, Object value)
			throws JMSException {
		((Map)headers.get(PROPERTIES)).put(name,value);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#acknowledge()
	 */
	@Override
	public void acknowledge() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#isBodyAssignableTo(java.lang.Class)
	 */
	@Override
	public boolean isBodyAssignableTo(Class c) throws JMSException {
		return c.getName().equals(String.class.getName());
	}


}
