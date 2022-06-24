package ctrl.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MyMessageDrivenBean
 */
//@MessageDriven(activationConfig = {
//		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
//		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/myQueue") })
public class MyMessageDrivenBean implements MessageListener {

	/**
	 * Default constructor.
	 */
	public MyMessageDrivenBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		try {
			String nachricht = ((TextMessage) message).getText();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
