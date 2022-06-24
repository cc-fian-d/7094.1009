package ctrl.ejb;

import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Kunde;

/**
 * EJB bedeutet per default CMT -> Container Managed Transaction
 *
 */
@Singleton
@TransactionManagement
public class KundenService {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Kunde kunde;

	public void createKunde() {
		em.persist(kunde.clone());
	}
}
