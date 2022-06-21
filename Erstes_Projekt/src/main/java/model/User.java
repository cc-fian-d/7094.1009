package model;

import java.util.logging.Logger;

// Jakarta EE 8 -> EE 9 -> EE 10 -> EE 10.1 
//import jakarta.enterprise.context.RequestScoped;
//JSF ManagedBeans - Deprecated
//import jakarta.faces.bean.RequestScoped;


// Java EE 8
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

// JSF ManagedBeans - Deprecated
//import javax.faces.bean.RequestScoped;

@Named//("usuario")
@RequestScoped
public class User {

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public User() {
		
	}
//	@Override
//	public String toString() {
//		return "User [name=" + name + ", age=" + age + "]";
//	}
	
	
	
}
