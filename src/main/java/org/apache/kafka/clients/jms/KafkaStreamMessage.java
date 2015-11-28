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
import java.util.stream.Stream;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaStreamMessage extends KafkaMessage implements StreamMessage {
	private Stream payload;
	
	/**
	 * 
	 */
	public KafkaStreamMessage() {
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
	 * @see javax.jms.StreamMessage#readBoolean()
	 */
	@Override
	public boolean readBoolean() throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readByte()
	 */
	@Override
	public byte readByte() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readShort()
	 */
	@Override
	public short readShort() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readChar()
	 */
	@Override
	public char readChar() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readInt()
	 */
	@Override
	public int readInt() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readLong()
	 */
	@Override
	public long readLong() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readFloat()
	 */
	@Override
	public float readFloat() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readDouble()
	 */
	@Override
	public double readDouble() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readString()
	 */
	@Override
	public String readString() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readBytes(byte[])
	 */
	@Override
	public int readBytes(byte[] value) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#readObject()
	 */
	@Override
	public Object readObject() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeBoolean(boolean)
	 */
	@Override
	public void writeBoolean(boolean value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeByte(byte)
	 */
	@Override
	public void writeByte(byte value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeShort(short)
	 */
	@Override
	public void writeShort(short value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeChar(char)
	 */
	@Override
	public void writeChar(char value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeInt(int)
	 */
	@Override
	public void writeInt(int value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeLong(long)
	 */
	@Override
	public void writeLong(long value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeFloat(float)
	 */
	@Override
	public void writeFloat(float value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeDouble(double)
	 */
	@Override
	public void writeDouble(double value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeString(java.lang.String)
	 */
	@Override
	public void writeString(String value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeBytes(byte[])
	 */
	@Override
	public void writeBytes(byte[] value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeBytes(byte[], int, int)
	 */
	@Override
	public void writeBytes(byte[] value, int offset, int length)
			throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#writeObject(java.lang.Object)
	 */
	@Override
	public void writeObject(Object value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.StreamMessage#reset()
	 */
	@Override
	public void reset() throws JMSException {
		// TODO Auto-generated method stub
		
	}
	
}
