package com.hrsmanager.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


import com.hrsmanager.model.EmployeeInfo;

public interface EmployeeDAO {
	public EmployeeInfo findEmployeeInfoByID(Integer employee_id);
	public EmployeeInfo findEmployeeInfoByEmail(String email);
	public EmployeeInfo findEmployeeInfoByEP(String email, String password);
	public int updateEmployeeInfo(String employee_name, String gender, Date birthday, 
			String address, String phone, String email, Date started_day, 
			Integer status_id, Integer role_id, Timestamp updated_at,
			Integer department_id, Integer position_id, String avatar, Integer employee_id);
	public String findPassword(String email);
	public int createEmployeeInfo(EmployeeInfo emp);
	public int updatePassword(Integer employee_id, String password);
	public List<EmployeeInfo> listEmployee();
	public List<EmployeeInfo> listPage(int pageId, int total);
}
