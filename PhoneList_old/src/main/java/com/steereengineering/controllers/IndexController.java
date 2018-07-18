package com.steereengineering.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.steereengineering.services.PhoneListService;

/**
 * Created by jt on 6/1/17.
 */
@Slf4j
@Controller
public class IndexController {

    private final PhoneListService phoneListService;

    public IndexController(PhoneListService phoneListService) {
        this.phoneListService = phoneListService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");
        model.addAttribute("phonelist", phoneListService.getPhoneList());
        return "index";
    }
}