package ctrl.service.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ctrl.ejb.sb.KundenManager;

//@ApplicationScoped
@Stateless
@Named("kundenservice")
public class KundenService {

	@EJB
	KundenManager km;

	public List<String> holeMessages() {
		return km.getMessages();
	}
}
