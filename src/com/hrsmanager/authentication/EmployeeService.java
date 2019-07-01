package com.hrsmanager.authentication;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrsmanager.dao.EmployeeDAO;
import com.hrsmanager.dao.RoleDAO;
import com.hrsmanager.model.EmployeeInfo;
import com.hrsmanager.model.Roles;

@Service
public class EmployeeService implements UserDetailsService {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		EmployeeInfo emp = employeeDAO.findEmployeeInfoByEmail(email);
		
		if (emp == null) {
			throw new UsernameNotFoundException("Email "+email+" was not found");
		}
		
		Roles role = roleDAO.findRoles(emp.getRole_id());
		String role_name = role.getRole_name();
	
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role_name);
		
		UserDetails userDetails = (UserDetails) new User (emp.getEmail(), emp.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
	
	public EmployeeInfo findByID(Integer employee_id) {
		EmployeeInfo emp = employeeDAO.findEmployeeInfoByID(employee_id);
		if (emp == null) {
			throw new UsernameNotFoundException("Employee "+employee_id+" was not found");
		}
		return emp;
	}
	
	public EmployeeInfo findByEmail(String email, String password) {
		EmployeeInfo emp = employeeDAO.findEmployeeInfoByEP(email, password);
		if (emp == null) {
			throw new UsernameNotFoundException("Employee "+email+" was not found");
		}
		return emp;
	}
}
