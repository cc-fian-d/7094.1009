package ctrl.ejb.sb;

import javax.ejb.Local;

@Local
public interface KundenManagerLocal extends KundenManager {

	public void deleteUser();
	public void deleteAccount();
	
}
