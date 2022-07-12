package com.spring.miniproject.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.spring.miniproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home.tiles";
	}

	@GetMapping("/test")
	public String test(Model m) {
//			int testCnt = userService.count();
//
//			m.addAttribute("testCnt",testCnt);

		return "home.tiles";
	}

}
