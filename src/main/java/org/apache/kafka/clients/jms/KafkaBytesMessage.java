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

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class KafkaBytesMessage extends KafkaMessage implements BytesMessage {
	private byte[] payload;
	
	public KafkaBytesMessage() {
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
	 * @see javax.jms.BytesMessage#getBodyLength()
	 */
	@Override
	public long getBodyLength() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readBoolean()
	 */
	@Override
	public boolean readBoolean() throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readByte()
	 */
	@Override
	public byte readByte() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readUnsignedByte()
	 */
	@Override
	public int readUnsignedByte() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readShort()
	 */
	@Override
	public short readShort() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readUnsignedShort()
	 */
	@Override
	public int readUnsignedShort() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readChar()
	 */
	@Override
	public char readChar() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readInt()
	 */
	@Override
	public int readInt() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readLong()
	 */
	@Override
	public long readLong() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readFloat()
	 */
	@Override
	public float readFloat() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readDouble()
	 */
	@Override
	public double readDouble() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readUTF()
	 */
	@Override
	public String readUTF() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readBytes(byte[])
	 */
	@Override
	public int readBytes(byte[] value) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#readBytes(byte[], int)
	 */
	@Override
	public int readBytes(byte[] value, int length) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeBoolean(boolean)
	 */
	@Override
	public void writeBoolean(boolean value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeByte(byte)
	 */
	@Override
	public void writeByte(byte value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeShort(short)
	 */
	@Override
	public void writeShort(short value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeChar(char)
	 */
	@Override
	public void writeChar(char value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeInt(int)
	 */
	@Override
	public void writeInt(int value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeLong(long)
	 */
	@Override
	public void writeLong(long value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeFloat(float)
	 */
	@Override
	public void writeFloat(float value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeDouble(double)
	 */
	@Override
	public void writeDouble(double value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeUTF(java.lang.String)
	 */
	@Override
	public void writeUTF(String value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeBytes(byte[])
	 */
	@Override
	public void writeBytes(byte[] value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeBytes(byte[], int, int)
	 */
	@Override
	public void writeBytes(byte[] value, int offset, int length)
			throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#writeObject(java.lang.Object)
	 */
	@Override
	public void writeObject(Object value) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.BytesMessage#reset()
	 */
	@Override
	public void reset() throws JMSException {
		// TODO Auto-generated method stub
		
	}

}
