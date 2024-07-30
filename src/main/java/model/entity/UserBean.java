package model.entity;

import java.io.Serializable;

/**
 * @author USER
 *
 */
public class UserBean implements Serializable {

	// ユーザーID
	private int userId;
	// 氏名
	private String name;
	// パスワード
	private String password;


	/**
	 * デフォルトコンストラクタ
	 * @param userId
	 * @param name
	 * @param password
	 */
	public UserBean(int userId, String name, String password) {
		this.setUserId(userId);
		this.setName(name);
		this.setPassword(password);
	}

	/**
	 * コンストラクタ
	 */
	public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @return int
	 */
	public int getUserId() {
		return userId;

	}

	/**
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	//	@param セットするname
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @Override
	 */
	public String toString() {
		return "UserBean [userId=" + userId + ", name=" + name + ", password=" + password + "]";
	}

}
