package com.steereengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.steereengineering.commands.PhoneListCommand;
import com.steereengineering.services.PhoneListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PhoneListController {
	private static final String PHONELIST_PHONELISTFORM_URL = "phonelist/phonelistform";
	public final PhoneListService phoneListService;

	public PhoneListController(PhoneListService phoneListService) {
		this.phoneListService = phoneListService;
	}

	@GetMapping
	@RequestMapping("/phonelist/{id}/show")
	public String showById(@PathVariable String id, Model model){

		model.addAttribute("phonelist", phoneListService.findById(new Long(id)));
		return "phonelist/show";
	}
	@PostMapping("phonelist")
    public String saveOrUpdate(@Validated @ModelAttribute("phonelist") PhoneListCommand command, BindingResult bindingResult){
		
		log.debug("Binding Results has errors = " + bindingResult.hasErrors());
		if(bindingResult.hasErrors()){
			bindingResult.getAllErrors().forEach(objectError-> {
			log.debug(objectError.toString());
		});
		return 	PHONELIST_PHONELISTFORM_URL;
		}	
		
        PhoneListCommand savedCommand = phoneListService.savePhoneListCommand(command);
        savedCommand.getId();
     /*   return "redirect:/phonelist/" + savedCommand.getId() + "/show";*/
        return "redirect:/index";

    }

	@GetMapping
	@RequestMapping("phonelist/new")
	public String newPhoneList(Model model){
		model.addAttribute("phonelist", new PhoneListCommand());
		return PHONELIST_PHONELISTFORM_URL;
	}

	@GetMapping
	@RequestMapping("phonelist/{id}/update")
	public String updatePhoneList(@PathVariable String id, Model model){
		model.addAttribute("phonelist", phoneListService.findCommandById(Long.valueOf(id)));
		return PHONELIST_PHONELISTFORM_URL;
	}
	@GetMapping
	@RequestMapping("phonelist/{id}/delete")
	public String deleteById(@PathVariable String id){

		log.debug("Deleting id: " + id);

		phoneListService.deleteById(Long.valueOf(id));
		return "redirect:/";
	}
}

