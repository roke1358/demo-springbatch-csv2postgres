package com.javanobrain.springbatch.demospringbatchcsv2db.domain;

import java.util.Date;

public class User {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String dept;
	private String email;
	private String streetName;
	private String city;
	private String state;
	private String zipCode;
	private String gender;
	private String phoneNumber;
	private Date Birthdate;
	
	public User(Integer id, String firstName, String lastName, String dept, String email, String streetName,
			String city, String state, String zipCode, String gender, String phoneNumber, Date birthdate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.email = email;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		Birthdate = birthdate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept + ", email="
				+ email + ", streetName=" + streetName + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", Birthdate=" + Birthdate + "]";
	}
	
	
}
