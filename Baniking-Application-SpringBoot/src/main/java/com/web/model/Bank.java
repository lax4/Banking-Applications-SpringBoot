package com.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long num;
	private String name;
	private String password;
	private double amount;
	private String address;
	private long mobile;
	
	public void setNum(long num) {
		this.num=num;
	}
	public long getNum() {
			return num;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Bank(long num, String name, String password, double amount, String address, long mobile) {
		super();
		this.num = num;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.mobile = mobile;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bank [num=" + num + ", name=" + name + ", password=" + password + ", amount=" + amount + ", address="
				+ address + ", mobile=" + mobile + "]";
	}
	
	

}
