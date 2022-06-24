package ctrl.ejb.sb;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * Session Bean implementation class KundenManagerBean
 */
@Stateless
//@Stateful
//@Singleton
//@TransactionManagement(TransactionManagementType.BEAN)
//@TransactionManagement(TransactionManagementType.CONTAINER)
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
//@Local(KundenManagerLocal.class)
//@Remote(KundenManager.class)
public class KundenManagerBean implements KundenManager, KundenManagerLocal {

	/**
	 * Default constructor.
	 */
	public KundenManagerBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getMessages() {
		System.out.println("Hier arbeitet die EJB");
		return Stream.of("Hallo Welt", "Hier sind EJBs", "Wird übertragen").collect(Collectors.toList());
	}

}
