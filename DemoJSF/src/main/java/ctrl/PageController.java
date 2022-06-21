package ctrl;

import java.io.Serializable;

import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named("pageController")
//@RequestScoped
//@SessionScoped
@ApplicationScoped // CDI Es soll nur eine Instanz in der Applikation erstellt werden
//@Singleton // EJB Es soll nur eine Instanz in der Applikation erstellt werden 
public class PageController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2393309361704950721L;

	public String moveToSuccess() {
		return "erfolg";
	}
	
}
