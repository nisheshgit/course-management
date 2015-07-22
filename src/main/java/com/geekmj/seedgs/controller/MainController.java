package com.geekmj.seedgs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geekmj.seedgs.domain.User;
import com.geekmj.seedgs.service.UserService;


@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(Model model) {

		List<String> quotations = getQuotations();

		Random rand = new Random();
		int min = 0, max = 4;
		int randomNum = rand.nextInt((max - min) + 1) + min;

		model.addAttribute("quotation", quotations.get(randomNum));
//
//		List<User_details> users = userService.findAllUser();
//
//		model.addAttribute("users", users);

		return "index";
	}

	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public @ResponseBody String login(){
				
		System.out.println("Incoming Login request");
//		model.addAttribute("users", users);
		
		return "true";
	}
	
	
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public @ResponseBody String register(@ModelAttribute("User") User user){
				
		System.out.println("Incoming Register request" + user);
		userService.saveUser(user);
		return "register";
	}
	
	@RequestMapping(value = "/view" , method = RequestMethod.GET)
	public @ResponseBody List<User> view(){
		List<User> users = userService.findAllUser();
		return users;
	}
	
	
	
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	public String user(
//			@RequestParam(value = "userId", required = false) Long userId,
//			Model model) {
//
//		User_details user = new User_details();
//
//		if (userId != null) {
//
//			user = userService.findUserById(userId);
//		}
//
//		model.addAttribute("user", user);
//		return "user";
//	}
//
//	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
//	public String saveUser(@ModelAttribute User_details user, Model model) {
//		userService.saveUser(user);
//		return "redirect:/";
//	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(
			@RequestParam(value = "userId", required = true) Long userId,
			Model model) {

		if (userId != null) {

			userService.deleteUserById(userId);
		}

		return "redirect:/";
	}

	
	private List<String> getQuotations() {
		List<String> quotations = new ArrayList<String>();
		quotations
				.add("Simplicity is prerequisite for reliability. ~ Edsger Dijkstra");
		quotations
				.add("The sooner you start to code, the longer the program will take. ~ Roy Carlson, University of Wisconsin");
		quotations
				.add("â€œWhen debugging, novices insert corrective code; experts remove defective code.â€� ~ Richard Pattis");
		quotations
				.add("Measuring programming progress by lines of code is like measuring aircraft building progress by weight. ~ Bill Gates");
		quotations
				.add("â€œPeople think that computer science is the art of geniuses but the actual reality is the opposite, just many people doing things that build on each other, like a wall of mini stones.â€� ~ Donald Knuth (computer scientist)");

		return quotations;
	}
}