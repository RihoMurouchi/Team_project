package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable {

	private int userId;

	private String name;

	private String password;

	public UserBean() {

	}

	public UserBean(int UserId, String name, String password) {
		this.setUserId(userId);
		this.setName(name);
		this.setPassword(password);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
