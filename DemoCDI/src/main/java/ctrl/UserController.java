package ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.User;

@Named("userController")
@ApplicationScoped
public class UserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8698484074178593175L;

	private List<User> userList = new ArrayList<User>();

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Inject
	private User user;// Achtung WeldProxyClient

	public String addUser() {
//		userList.add(new User(user));
		userList.add(user.clone());
		return "index";
	}

	public String removeUser() {
		userList.remove(user.clone());
		return "index";
	}

	public String moveToManagePage() {
		System.out.println("**************");
		System.out.println(user.getClass());// class model.User$Proxy$_$$_WeldClientProxy
		System.out.println("**************");

		if (user.getRole().equals("admin")) {
			return "ManageAdmin";
		} else {
			return "ManageUser";
		}

	}

}
