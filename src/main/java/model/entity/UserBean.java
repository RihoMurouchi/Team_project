package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable {

	//	ユーザーID
	private int userId;
	//　氏名
	private String name;
	//　パスワード
	private String password;

	//	デフォルトコンストラクタ

	public UserBean(int userId, String name, String password) {
		this.setUserId(userId);
		this.setName(name);
		this.setPassword(password);
	}

	public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//	@return userId
	public int getUserId() {
		return userId;

	}

	//	@param セットするuserId
	public void setUserId(int userId) {
		this.userId = userId;
	}

	//	@return name
	public String getName() {
		return name;
	}

	//	@param セットするname
	public void setName(String name) {
		this.name = name;
	}

	//	@return password
	public String getPassword() {
		return password;
	}

	//	@param セットするpassword
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", name=" + name + ", password=" + password + "]";
	}

}
