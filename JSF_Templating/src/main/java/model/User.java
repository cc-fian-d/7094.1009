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

	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
		this.setRole("user");
	}

	public User(User origin) {
		this.setRole(origin.getRole());
		this.setPremium(origin.isPremium());
		this.setName(origin.getName());
	}

	@Override
	public User clone() {
		User tmp = new User();
		tmp.setRole(this.getRole());
		tmp.setPremium(this.isPremium());
		tmp.setName(this.getName());
		return tmp;
	}

	@Override
	public String toString() {
		return "User [role=" + role + ", premium=" + premium + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + (premium ? 1231 : 1237);
//		result = prime * result + ((role == null) ? 0 : role.hashCode());
//		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (premium != other.premium)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
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
