package com.hrsmanager.model;

import java.sql.Date;
import java.sql.Timestamp;

public class EmployeeInfo {

	private Integer employee_id;
	private String employee_name;
	private String gender;
	private Date birthday;
	private String address;
	private String phone;
	private String email;
	private String password;
	private Date started_day;
	private Integer status_id;
	private Integer role_id;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Integer department_id;
	private Integer position_id;
	
	public EmployeeInfo(Integer id, String name,String gender, Date birthday, String phone, String email, String password) {
		this.employee_id = id;
		this.employee_name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
		this.password = String.valueOf(this.employee_id);
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getStarted_day() {
		return started_day;
	}

	public void setStarted_day(Date started_day) {
		this.started_day = started_day;
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}
}
