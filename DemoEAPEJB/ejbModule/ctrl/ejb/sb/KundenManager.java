package ctrl.ejb.sb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface KundenManager {

	public void createUser();
	public void createAccount();
	public List<String> getMessages();
}
