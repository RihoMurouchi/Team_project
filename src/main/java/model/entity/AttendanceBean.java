package model.entity;

import java.sql.Date;
import java.sql.Time;

public class AttendanceBean {
	private int id;
	private int userId;
	private Date date;
	private Time startTime;
	private Time endTime;
	private Time overTime;

	// コンストラクタ
	public AttendanceBean() {
		// デフォルトコンストラクタ
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
}
