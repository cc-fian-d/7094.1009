package ctrl.svts;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.User;

/**
 * Servlet implementation class WorkWithJPA
 */
@WebServlet("/WorkWithJPA")
public class WorkWithJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Wir arbeiten mit CDI - Also Benötigen wir einen EntityManager und
	 * UserTransaction
	 * 
	 * JPA mit BMT - Beans Managed Transaction
	 */
//	@Inject
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Before");
		
		User u = new User();
		u.setName("Christian");
		u.setAge(42);
		
		try {
			ut.begin();
			em.persist(u);
			ut.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.getWriter().println(u);
		response.getWriter().println("After");
	}

}
