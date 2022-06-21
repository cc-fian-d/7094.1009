package model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("user")
@SessionScoped
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7351729135012380019L;

	private String role;
	
	private boolean premium;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	
	public User() {
		this.setRole("user");
	}
	
	@Override
	public String toString() {
		return "User [role=" + role + ", premium=" + premium + "]";
	}

	public void sudo() {
		if (role == "user") {
			this.setRole("admin");
		} else {
			this.setRole("user");
		}
	}
	
	public void changePremium() {
		this.premium = !this.premium;
	}
	
}
