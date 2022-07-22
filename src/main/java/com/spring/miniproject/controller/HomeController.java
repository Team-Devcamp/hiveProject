package com.spring.miniproject.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	HomeService homeService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );


		try {

			List<ProductDto> popularlist = homeService.getPopularProduct();
			model.addAttribute("popularlist", popularlist);

			List<ProductDto> latestlist = homeService.getLatestProduct();
			model.addAttribute("latestlist", latestlist);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "home.tiles";
	}

	@GetMapping("/search")
	public String getSearch(String keyword, Model m) {

		try {
			List<ProductDto> list = homeService.getSearch(keyword);
			int resultCnt = homeService.getResultCnt(keyword);
			
			m.addAttribute("list", list);
			m.addAttribute("resultCnt", resultCnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "search.tiles";
	}

}
