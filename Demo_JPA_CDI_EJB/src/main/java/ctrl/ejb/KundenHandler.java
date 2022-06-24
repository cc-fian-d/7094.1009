package ctrl.ejb;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("kundenhandler")
public class KundenHandler {

	@EJB
	private KundenService ks;
	
	public void createKunde(){
		ks.createKunde();
	}
}
