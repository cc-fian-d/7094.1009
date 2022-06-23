package ctrl.svts.learn;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import model.learn.Audioequipment;
import model.learn.AudioequipmentPK;
import model.learn.Schulungsraum;

/**
 * Servlet implementation class WriteWithJPALearn
 */
@WebServlet("/WriteWithJPALearn")
public class WriteWithJPALearn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Before");

		/**
		 * Erstellen des Objektes für die zusammengesetzten Primary Key von
		 * Audioequipment
		 */
		AudioequipmentPK ae_PK = new AudioequipmentPK();
		ae_PK.setHersteller("Amazon");
		ae_PK.setTypbezeichnung("Lausch-Wanze");

		/**
		 * Erstellen des Objektes Audiop Equipment
		 */
		Audioequipment ae = new Audioequipment();
		ae.setId(ae_PK);
		ae.setPreis(500.00f);
		
		Schulungsraum room = new Schulungsraum();
		room.setName("7094.1009");
		room.setKapazität(12);
		room.setAudioequipment(ae);
		
		
		try {
			ut.begin();
//			em.persist(ae);
			em.persist(room);
			ut.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

		resp.getWriter().println("After");
	}

}
