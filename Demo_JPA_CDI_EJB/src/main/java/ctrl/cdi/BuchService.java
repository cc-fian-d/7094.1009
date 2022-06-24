package ctrl.cdi;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import model.Autor;
import model.Buch;

/**
 * CDI -> BMT(UMT) -> Bean/User Managed Transaction
 *
 */
@ApplicationScoped
@Named("buchservice")
public class BuchService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction ut;

	@Inject
	private Autor autor;

	public List<Buch> holeAlleBuecher() {
		return em.createNamedQuery(Buch.QUERY_FINDALL, Buch.class).getResultList();
	}

	public String createAutor() {
		autor = autor.clone();
		try {
			ut.begin();
			em.persist(autor);//ACHTUNG hier wird es gleich knallen. Versprochen.!!!!!1!1!1
			//JPA -> Table WELDCLIENTPROXY
			ut.commit();
		} catch (Exception e) {

		}
		return "success";
	}
}
