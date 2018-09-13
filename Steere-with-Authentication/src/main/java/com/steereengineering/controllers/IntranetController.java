package com.steereengineering.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.steereengineering.model.Employee;
import com.steereengineering.services.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller


public class IntranetController {

	private EmployeeService employeeService;	

	public IntranetController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value={"/intranet", "/"}, method = RequestMethod.GET)
	public String intranet(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println("currentPrincipalName = " + currentPrincipalName);
		if (currentPrincipalName =="anonymousUser") {
			model.addAttribute("isloggedin","false");
		} else {
			model.addAttribute("isloggedin","true");
		}
		Employee user = employeeService.findUserByEmail(currentPrincipalName);
		if (user != null && user.getRoles().stream().anyMatch(r -> r.getRole().equals("Admin")) && user.getActive() == 1) {
			model.addAttribute("isadmin", "true");	
		} else {
			model.addAttribute("isadmin", "false");	
		}
		System.out.println("Current Principal Name  = " + currentPrincipalName);
		return "/intranet";
	}
	@RequestMapping(value={"/public/employeelist/phonelist"}, method = RequestMethod.GET)
	public String getPhoneList(Model model) {
		System.out.println("Inside of getPhoneList Method" );
		model.addAttribute("isadmin", "false");	
		log.debug("Getting Public Index page");
		model.addAttribute("employee", employeeService.getPhoneList());
		return "/public/employeelist/phonelist";
	}
}
