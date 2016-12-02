package tn.enis.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login implements Serializable{

	@Id
	private String userName;
	private String passwd;
	public Login(String userName, String passwd) {
		super();
		this.userName = userName;
		this.passwd = passwd;
	}
	public Login() {}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
