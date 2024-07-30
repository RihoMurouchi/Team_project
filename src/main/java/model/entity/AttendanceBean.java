
package model.entity;

import java.io.Serializable;

public class AttendanceBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;
	private String date;
	private String startTime;
	private String endTime;
	private String overTime;

	 
	/**
	 * コンストラクタ
	 */
	public AttendanceBean() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	
	/**
	 * コンストラクタ
	 * @param id
	 * @param userId
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @param overTime
	 */
	public AttendanceBean(int id, int userId, String date, String startTime, String endTime, String overTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.overTime = overTime;
	}

	/**
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
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
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return String
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return String
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return String
	 */
	public String getOverTime() {
		return overTime;
	}

	/**
	 * @param overTime
	 */
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	/**
	 * @Override
	 */
	/**
	 *
	 */
	public String toString() {
		return "AttendanceBean [id=" + id + ", userId=" + userId + ", date=" + date + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", overTime=" + overTime + "]";
	}

}
