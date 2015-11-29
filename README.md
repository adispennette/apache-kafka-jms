# apache-kafka-jms
jms implementation of apache kafka

This is still a work in progress, however a basic functionality is working for a TextMessages as shown by this JUnit.

    public class KafkaJmsConnectionFactoryTest {
		private ConnectionFactory factory;
		private Connection con;
		private Session session;
		private Destination topic;

		/**
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
			factory = new KafkaJmsConnectionFactory();
			((KafkaJmsConnectionFactory)factory).initializeConfig();
			((KafkaJmsConnectionFactory)factory).getBuilder().groupId("KafkaJmsConnectionFactoryTest")
				.enableAuutoCommit("true").autoCommitInterval("1000");
			
			con = factory.createConnection();
			session = con.createSession();
			topic = session.createTopic("test");
		}
	
		@Test
		public void testSend() throws JMSException {
			MessageProducer producer = session.createProducer(topic);
			
			TextMessage text = session.createTextMessage();
			text.setText("this is a test.");
			
			producer.send(text);
			producer.close();
		}
		
		@Test
		public void testReceive() throws JMSException {
			MessageConsumer consumer = session.createConsumer(topic);
			Message msg = consumer.receive(10000);
			
			Assert.assertNotNull(msg);
			Assert.assertEquals("this is a test.", msg.getBody(String.class));
			
			session.unsubscribe(((KafkaDestination)topic).getName());
			consumer.close();
		}

    }

