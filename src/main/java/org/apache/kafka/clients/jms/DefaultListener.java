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

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.kafka.clients.consumer.Consumer;

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public class DefaultListener implements MessageListener {
	private Consumer<String, Message> consumer;
	
	public DefaultListener(Consumer<String, Message> consumer) {
		this.consumer = consumer;
	}
	
	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub

	}

}
