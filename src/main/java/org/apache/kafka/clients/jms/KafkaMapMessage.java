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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaMapMessage extends KafkaMessage implements MapMessage {
	private Map payload;
	
	public KafkaMapMessage() {
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
	 * @see javax.jms.MapMessage#getBoolean(java.lang.String)
	 */
	@Override
	public boolean getBoolean(String name) throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getByte(java.lang.String)
	 */
	@Override
	public byte getByte(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getShort(java.lang.String)
	 */
	@Override
	public short getShort(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getChar(java.lang.String)
	 */
	@Override
	public char getChar(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getInt(java.lang.String)
	 */
	@Override
	public int getInt(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getLong(java.lang.String)
	 */
	@Override
	public long getLong(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getFloat(java.lang.String)
	 */
	@Override
	public float getFloat(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getDouble(java.lang.String)
	 */
	@Override
	public double getDouble(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getString(java.lang.String)
	 */
	@Override
	public String getString(String name) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getBytes(java.lang.String)
	 */
	@Override
	public byte[] getBytes(String name) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getObject(java.lang.String)
	 */
	@Override
	public Object getObject(String name) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#getMapNames()
	 */
	@Override
	public Enumeration getMapNames() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setBoolean(java.lang.String, boolean)
	 */
	@Override
	public void setBoolean(String name, boolean value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setByte(java.lang.String, byte)
	 */
	@Override
	public void setByte(String name, byte value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setShort(java.lang.String, short)
	 */
	@Override
	public void setShort(String name, short value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setChar(java.lang.String, char)
	 */
	@Override
	public void setChar(String name, char value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setInt(java.lang.String, int)
	 */
	@Override
	public void setInt(String name, int value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setLong(java.lang.String, long)
	 */
	@Override
	public void setLong(String name, long value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setFloat(java.lang.String, float)
	 */
	@Override
	public void setFloat(String name, float value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setDouble(java.lang.String, double)
	 */
	@Override
	public void setDouble(String name, double value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setString(java.lang.String, java.lang.String)
	 */
	@Override
	public void setString(String name, String value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setBytes(java.lang.String, byte[])
	 */
	@Override
	public void setBytes(String name, byte[] value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setBytes(java.lang.String, byte[], int, int)
	 */
	@Override
	public void setBytes(String name, byte[] value, int offset, int length)
			throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#setObject(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setObject(String name, Object value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MapMessage#itemExists(java.lang.String)
	 */
	@Override
	public boolean itemExists(String name) throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

}
