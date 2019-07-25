package com.hrsmanager.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrsmanager.authentication.EmployeeService;
import com.hrsmanager.model.EmployeeInfo;

@Controller
public class AuthenticationController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String show_login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = {"/login_check"}, method = RequestMethod.POST)
	public String check_login(Model model, HttpServletRequest request, HttpServletResponse reponse,
			@RequestParam(value ="email") String email, @RequestParam(value ="password") String password) throws SQLException {
		String errorString = null;
		boolean hasError = false;
		EmployeeInfo emp = null;
		
		if(email== null || password == null) {
			hasError = true;
			errorString = "Email and Password can not null or empty";
			request.setAttribute("error", errorString);
		} else {
			emp = employeeService.findByEmailPass(email,password);
			if (emp == null) {
				hasError = true;
				errorString = "Email or password invalid";
			}
		}
		
		if(hasError) {
			request.setAttribute("emp", null);
			request.setAttribute("errorString", errorString);
			return "login";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);
			String id = emp.getEmployee_id().toString();
			return "redirect:/employee/" + id;
		}
	}
	
	/*--------------Logout-------------*/
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model,HttpServletRequest request, HttpServletResponse reponse) {
		HttpSession session = request.getSession();
		session.setAttribute("emp", null);
		return "redirect:/login";
	}
	
}
