package ctrl.svts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import model.Buch;

/**
 * Servlet implementation class ReadWithJPA
 */
@WebServlet("/ReadWithJPA")
public class ReadWithJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction ut;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		Integer idx = 1;
		try {
			idx = Integer.parseInt(req.getParameter("idx"));
		} catch (Exception e) {

		}

		out.println("Lesen von Daten aus der DB mit JPA und JTA(User-Managed Transaction)");

		/**
		 * Lesen von Daten aus der DB mit dem Index als abfrage
		 */
		out.println("\n\nLesen von Daten aus der DB mit dem Index als abfrage");
		Buch b = em.find(Buch.class, idx);
		out.println(b);
//		TypedQuery<Buch> typedQuery = em.createQuery("SELECT b FROM Buch b WHERE id = 1", Buch.class);
//		List<Buch> buecher = typedQuery.getResultList();
		List<Buch> buecher = em.createQuery("SELECT b FROM Buch b WHERE b.id = 1", Buch.class).getResultList();
		out.println(buecher);
		
		
		
		out.println("\n\nLesen von Daten aus der DB : Ein Buch anhand des Titels finden/lesen");
		/**
		 * Lesen von Daten aus der DB : Ein Buch anhand des Titels finden/lesen
		 */
		buecher = em.createQuery("SELECT b FROM Buch b WHERE b.titel LIKE '%Java%'", Buch.class).getResultList();
		
		out.println(buecher);
		
		
		out.println("\n\nLesen von Daten aus der DB : Mit Named Queries");
		TypedQuery<Buch> namedTypedQuery = em.createNamedQuery(Buch.QUERY_FIND_BY_TITLE, Buch.class);
		namedTypedQuery.setParameter(Buch.PARAMETER_FIND_BY_TITLE, "%Tagen%");
		namedTypedQuery.getResultList().forEach(tmp-> out.println(tmp));
		
		out.println("\n\nLesen von Daten aus der DB : Mit  NativeQuery Queries");
		Query query = em.createNativeQuery("SELECT * FROM buch WHERE id > 1",Buch.class);
		query.getResultList().forEach(obj -> out.println(obj));
	}

}
