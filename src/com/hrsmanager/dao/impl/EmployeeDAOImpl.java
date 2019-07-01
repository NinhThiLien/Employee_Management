package com.hrsmanager.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsmanager.dao.EmployeeDAO;
import com.hrsmanager.mapper.EmployeeMapper;
import com.hrsmanager.model.EmployeeInfo;

@Service
@Transactional
public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO{
	
	@Autowired
	public EmployeeDAOImpl (DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public EmployeeInfo findEmployeeInfoByID(Integer employee_id) {
		String sql = "Select * from Employees emp where emp.employee_id = ? ";
		Object[] params = new Object[] {employee_id};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			EmployeeInfo emp = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return emp;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public EmployeeInfo findEmployeeInfoByEmail(String email) {
		String sql = "Select * from Employees emp where emp.email = ?";
		Object[] params = new Object[] {email};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			EmployeeInfo emp = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return emp;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public EmployeeInfo findEmployeeInfoByEP(String email, String password) {
		String sql = "Select * from Employees emp where emp.email = ? and emp.password =?";
		Object[] params = new Object[] {email, password};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			EmployeeInfo emp = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return emp;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
