package ctrl.svts.message;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "Dies wird die Nachricht für die Queue";
		
		
		try {
			Context ctx = new InitialContext();
			
			ConnectionFactory cf = (ConnectionFactory) ctx.lookup("/ConnectionFactory");
			Queue queue = (Queue) ctx.lookup("jms/queue/myQueue");
			
			Connection con = cf.createConnection();
			
			Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			MessageProducer publisher = session.createProducer(queue);
			
			con.start();
			
			TextMessage textMessage = session.createTextMessage(message);
			
			publisher.send(textMessage);
			
			con.close();
			
		} catch (Exception e) {
			
		}
		
		
		
	}

}
