package com.hrsmanager.model;

import java.sql.Timestamp;

public class Roles {

	private Integer role_id;
	private String role_name;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Boolean active;
	
	public Roles(Integer role_id, String role_name) {
		this.role_id = role_id;
		this.role_name = role_name;
		new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
		this.active = true;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
	
}
