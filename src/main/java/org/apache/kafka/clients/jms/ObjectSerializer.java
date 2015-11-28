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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class ObjectSerializer<T> implements Serializer<T>,Deserializer<T> {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Serializer#serialize(java.lang.String, java.lang.Object)
	 */
	public byte[] serialize(String paramString, T paramT) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try(ObjectOutputStream out = new ObjectOutputStream(baos)) {
			out.writeObject(paramT);
		} catch (IOException e) {
			logger.error("Failed to serialize object.",e);
			throw new SerializationException("Failed to serialize object.",e);
		}
		return baos.toByteArray();
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Serializer#close()
	 */
	public void close() {
		// NOOP
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Serializer#configure(java.util.Map, boolean)
	 */
	public void configure(Map<String, ?> paramMap, boolean paramBoolean) {
		// NOOP
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Deserializer#deserialize(java.lang.String, byte[])
	 */
	@Override
	public T deserialize(String arg0, byte[] arg1) {
		ByteArrayInputStream bais = new ByteArrayInputStream(arg1);
		try(ObjectInputStream in = new ObjectInputStream(bais)) {
			return (T) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			logger.error("Failed to serialize object.",e);
			throw new SerializationException("Failed to deserialize object.",e);
		}
	}

}
