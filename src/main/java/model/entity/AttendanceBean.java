package model.entity;

import java.io.Serializable;
import java.sql.Time;

public class AttendanceBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;
	private String date;
	private Time startTime;
	private Time endTime;
	private Time overTime;
	private UserBean user;

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	// コンストラクタ
	public AttendanceBean() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// コンストラクタ
	public AttendanceBean(int id, int userId, String date, Time startTime, Time endTime, Time overTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.overTime = overTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Time getOverTime() {
		return overTime;
	}

	public void setOverTime(Time overTime) {
		this.overTime = overTime;
	}

	@Override
	public String toString() {
		return "AttendanceBean [id=" + id + ", userId=" + userId + ", date=" + date + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", overTime=" + overTime + ", user=" + user + "]";
	}

}
