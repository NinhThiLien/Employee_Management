package com.hrsmanager.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.hrsmanager.authentication.EmployeeService;
import com.hrsmanager.model.DepartmentInfo;
import com.hrsmanager.dao.DepartmentDAO;
import com.hrsmanager.dao.PositionDAO;
import com.hrsmanager.dao.RoleDAO;
import com.hrsmanager.dao.StatusDAO;
import com.hrsmanager.model.EmployeeInfo;
import com.hrsmanager.model.PositionInfo;
import com.hrsmanager.model.Roles;
import com.hrsmanager.model.Status;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	private PositionDAO positionDAO;

	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private StatusDAO statusDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
	public String listEmployee(Model model,HttpServletRequest request) {
		List<EmployeeInfo> list = employeeService.listEmployee();
		String type = (String) request.getAttribute("type");
		model.addAttribute("type", type);
		model.addAttribute("list", list);
		return "employees";
	}
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String listEmp(Model model,HttpServletRequest request) {
		List<EmployeeInfo> list = employeeService.listEmployee();
		request.setAttribute("list", list);
		return "employees_list";
	}
	
	/*@RequestMapping(value = {"/card"}, method = RequestMethod.GET)
	public String cardEmp(Model model,HttpServletRequest request) {
		List<EmployeeInfo> list = employeeService.listEmployee();
		request.setAttribute("list", list);
		return "employees_card";
	}*/
	
	@RequestMapping(value = {"/employee/{id}"}, method = RequestMethod.GET)
	public String profile(@PathVariable int id, Model model) {
		EmployeeInfo emp = employeeService.findByID(id);
		String position_name = positionDAO.findPositionByID(emp.getPosition_id()).getPosition_name();
		DepartmentInfo department = (DepartmentInfo) departmentDAO.findDepartmentByID(emp.getDepartment_id());
		model.addAttribute("position", position_name);
		model.addAttribute("department", department);
		model.addAttribute("emp", emp);
		return "profile";
	}
	
	@RequestMapping(value = {"/employee/{id}/edit"}, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id, Model model) {
		EmployeeInfo emp = employeeService.findByID(id);
		List<Status> listStatuses = statusDAO.listStatus();
		List<Roles> listRoles = roleDAO.listRoles();
		List<DepartmentInfo> listDepartments = departmentDAO.listDeapartments();
		List<PositionInfo> listPositions = positionDAO.listPositions();
		
		model.addAttribute("emp", emp);
		model.addAttribute("listStatuses", listStatuses);
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("listDepartments", listDepartments);
		model.addAttribute("listPositions", listPositions);
		return new ModelAndView("editprofile");
	}
	
	@RequestMapping(value = {"/employee/{id}/update"}, method = RequestMethod.POST)
	public String update(@PathVariable int id,
			@RequestParam(value ="name") String name,
			@RequestParam(value ="gender") String gender, 
			@RequestParam(value ="bod") String bod, 
			@RequestParam(value ="address") String address, 
			@RequestParam(value ="phone") String phone, 
			@RequestParam(value ="email") String email, 
			@RequestParam(value ="std") String std,
			@RequestParam(value ="status") String status,
			@RequestParam(value ="role") String role,
			@RequestParam(value ="department") String department,
			@RequestParam(value ="position") String position
			) {
		
		Date birthday = Date.valueOf(bod);
		Date started_day = Date.valueOf(std);
		Integer status_id = Integer.valueOf(status);
		Integer role_id = Integer.valueOf(role);
		Integer department_id = Integer.valueOf(department);
		Integer position_id = Integer.valueOf(position);
		Timestamp updated_at = new Timestamp(System.currentTimeMillis());
		
		EmployeeInfo emp = employeeService.updateEmployee(name, gender, 
				birthday, address, phone, email, started_day, status_id, role_id,
				updated_at, department_id, position_id, id);
		
		if (emp != null) {
			return "redirect:/employee/" + id;
		}
		else return "redirect:/employee/" + id + "/edit";
	}
	
	@RequestMapping(value = {"/employee/{id}"}, method = RequestMethod.DELETE)
	public ModelAndView delete() {
		return new ModelAndView("profile");
	}
	
	/*-----------------create Employee----------------------------------------*/
	@RequestMapping(value = {"/employee/new"}, method = RequestMethod.GET)
	public ModelAndView show(Model model) {
		List<Status> listStatuses = statusDAO.listStatus();
		List<Roles> listRoles = roleDAO.listRoles();
		List<DepartmentInfo> listDepartments = departmentDAO.listDeapartments();
		List<PositionInfo> listPositions = positionDAO.listPositions();
		model.addAttribute("listStatuses", listStatuses);
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("listDepartments", listDepartments);
		model.addAttribute("listPositions", listPositions);
		return new ModelAndView("newemployee");
	}
	
	@RequestMapping(value = {"/create"}, method = RequestMethod.POST)
	public String create(Model model,HttpServletRequest request, HttpServletResponse reponse) {
		
		Integer employee_id = Integer.valueOf((String)request.getParameter("employee_id"));
		String employee_name = request.getParameter("employee_name");
		String gender = request.getParameter("gender");
		Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = BCrypt.hashpw(String.valueOf(employee_id), BCrypt.gensalt(12));
		Date started_day = java.sql.Date.valueOf(request.getParameter("started_day"));
		Integer role_id = Integer.valueOf((String)request.getParameter("role_id"));
		Integer status_id = Integer.valueOf((String)request.getParameter("status_id"));
		Integer department_id = Integer.valueOf((String)request.getParameter("department_id"));
		Integer position_id = Integer.valueOf((String)request.getParameter("position_id"));
		
		EmployeeInfo emp = new EmployeeInfo(employee_id, employee_name, gender, birthday, phone, email, password, address);
		
		int k = employeeService.newEmployeeInfo(emp, department_id, position_id, role_id, status_id, started_day);
		if (k>0) return "redirect:/employees";
		else {
			return "newemployee";
		}
	}
	
	/*-------------- Change password--------------------*/
	@RequestMapping(value = {"/employee/{id}/change_password"}, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView password() {
		return new ModelAndView("password");
	}
}
