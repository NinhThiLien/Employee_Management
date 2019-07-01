package com.hrsmanager.dao;

import com.hrsmanager.model.EmployeeInfo;

public interface EmployeeDAO {
	public EmployeeInfo findEmployeeInfoByID(Integer employee_id);
	public EmployeeInfo findEmployeeInfoByEmail(String email);
	public EmployeeInfo findEmployeeInfoByEP(String email, String password);
}
