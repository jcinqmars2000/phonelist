package com.steereengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.steereengineering.services.PhoneListService;

@Controller
public class PhoneListController {
	public final PhoneListService phoneListService;
	
	 public PhoneListController(PhoneListService phoneListService) {
	        this.phoneListService = phoneListService;
	    }
	 @RequestMapping("/phonelist/show/{id}")
	 public String showById(@PathVariable String id, Model model){

	        model.addAttribute("phonelist", phoneListService.findById(new Long(id)));
	        return "phonelist/show";
	    }
}
