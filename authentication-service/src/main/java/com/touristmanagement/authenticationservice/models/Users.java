package com.touristmanagement.authenticationservice.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name= "user_details_2916")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL_ID", nullable = false, unique = true)
	private String emailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "registration_date", updatable = false)
	private LocalDateTime registrationDateTime;
	
	@PrePersist
	public void prePersist() {
		this.registrationDateTime = LocalDateTime.now();
		if(this.status == null) {
			this.status = "Active";
		}
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getregistrationDateTime() {
		return registrationDateTime;
	}
	public void setregistrationDateTime(LocalDateTime registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}


	public Users orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
