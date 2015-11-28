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

/**
 * @author Al Dispennette
 * @since 0.8.2.2
 *
 */
public interface JmsHeaderKeys {
	public static String JMSDestination = "JMSDestination";
	public static String JMSDeliveryMode="JMSDeliveryMode";
	public static String JMSExpiration="JMSExpiration";
	public static String JMSPriority="JMSPriority";
	public static String JMSMessageID="JMSMessageID";
	public static String JMSTimestamp="JMSTimestamp";
	public static String JMSCorrelationID="JMSCorrelationID";
	public static String JMSReplyTo="JMSReplyTo";
	public static String JMSType="JMSType";
	public static String JMSRedelivered="JMSRedelivered";
	public static String JMSDeliveryTime = "JMSDeliveryTime";
}
