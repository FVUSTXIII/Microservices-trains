package com.userservice.java.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer activityId;
	private Integer userId;
	private LocalDateTime userLoginDate;
	
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalDateTime getUserLoginDate() {
		return userLoginDate;
	}
	public void setUserLoginDate(LocalDateTime localDateTime) {
		this.userLoginDate = localDateTime;
	}
	@Override
	public String toString() {
		return "UserActivity [activityId=" + activityId + ", userId=" + userId + ", userLoginDate=" + userLoginDate
				+ "]";
	}
	
	
}
