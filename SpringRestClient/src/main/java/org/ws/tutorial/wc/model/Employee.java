package org.ws.tutorial.wc.model;

import java.sql.Date;

public class Employee {
	
	private int id;
	
	private Date birthDate;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private Date hireDate;

	public Employee(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", birthDate=" + birthDate + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", hireDate=" + hireDate + "]";
	}
	
	
	
}
