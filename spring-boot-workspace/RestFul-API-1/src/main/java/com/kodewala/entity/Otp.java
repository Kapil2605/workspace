package com.kodewala.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Otp {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phoneNo;
    private String otp;
    private Long expiryTime; // timestamp
    
    private String email;
    
    
    public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//getter setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phoneNo;
	}
	public void setPhone(String phone) {
		this.phoneNo = phone;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Long getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(Long expiryTime) {
		this.expiryTime = expiryTime;
	}
    
    

}
