package com.hrsmanager.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.hrsmanager.authentication.EmployeeService;
import com.hrsmanager.dao.EmployeeDAO;
import com.hrsmanager.dao.RoleDAO;
import com.hrsmanager.model.EmployeeInfo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String Show_login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = {"/login_check"}, method = RequestMethod.POST)
	public String Check_login(Model model, HttpServletRequest request,
			@RequestParam(value ="email") String email, @RequestParam(value ="password") String password) {
		EmployeeInfo emp = (EmployeeInfo) employeeService.findByEmail(email,password);
		model.addAttribute("emp",emp);
		HttpSession session = request.getSession();
		if (emp != null) {
			session.setAttribute("emp", emp);
			return "redirect:/profile";
		}
		else return "login";
	}
	
	@RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("employees");
	}
	
	@RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
	public String profile(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		EmployeeInfo emp = (EmployeeInfo)session.getAttribute("emp");
		String position_name = roleDAO.findRoles(emp.getPosition_id()).getRole_name();
		model.addAttribute("position", position_name);
		model.addAttribute("emp", emp);
		return "profile";
	}
	
	@RequestMapping(value = {"/editprofile"}, method = RequestMethod.GET)
	public ModelAndView edit() {
		return new ModelAndView("editprofile");
	}
	
	@RequestMapping(value = {"/newemployee"}, method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("newemployee");
	}
	
	@RequestMapping(value = {"/password"}, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView password() {
		return new ModelAndView("password");
	}
}
