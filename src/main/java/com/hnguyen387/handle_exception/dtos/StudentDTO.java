package com.hnguyen387.handle_exception.dtos;

import com.hnguyen387.handle_exception.exceptions.IsExist;
import com.hnguyen387.handle_exception.exceptions.OnUpdate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@IsExist.List({
	@IsExist(field = "email", message = "Email has been used."),
	@IsExist(field = "phoneNumber", message = "Phone number has been used.")
})
public class StudentDTO {
	@NotBlank(message = "Id must be required.", groups = OnUpdate.class)
	private String id;
	@NotBlank(message = "First name must be required.")
	private String firstName;
	@NotBlank(message = "Last name must be required.")
	private String lastName;
	private String middleName;
	private int age;
	@NotBlank(message = "Email must be required.")
	@Email(message = "Invalid email")
	private String email;
	@NotBlank(message = "Phone number must be required.")
	private String phoneNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
