package ctrl.svts;

import java.io.IOException;
import java.time.LocalDate;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import model.Autor;
import model.Buch;

/**
 * Servlet implementation class WriteWithJPA
 */
@WebServlet("/WriteWithJPA")
public class WriteWithJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Before");
		
		
		/**
		 * Autor erstellen
		 */
		Autor a = new Autor();
		a.setVorname("Hans");
		a.setNachname("Zimmer");
		
		/**
		 * Buch erstellen
		 */
		Buch b = new Buch();
		b.setIsbn("234-234-234-234-234");
		b.setTitel("Java in 42 Tagen");
		b.setErscheinungsDatum(LocalDate.now().minusYears(12));
		b.setKlappentext("Tolles Buch");
		b.setAutor(a);
		
		/**
		 * Verknüpfen Autor und Buch miteinandern verbinden
		 */
		a.getBuecher().add(b);
		
		
		/**
		 * 
		 */
		
		try {
			ut.begin();
			em.persist(b);
			ut.commit();
		} catch (Exception e) {

		}
		
		
		response.getWriter().println(b);
		
		response.getWriter().println("After");
	}

}
