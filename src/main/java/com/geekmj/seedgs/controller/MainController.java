package com.geekmj.seedgs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geekmj.seedgs.dao.UserDao;
import com.geekmj.seedgs.domain.User;
import com.geekmj.seedgs.service.UserService;


@Controller
public class MainController {
	
	@Autowired
	private UserService userService;

    @RequestMapping("/")
    public String helloWorld(Model model) {
    	
    	List <String> quotations = getQuotations();
    	
    	Random rand = new Random();
    	int min = 0, max = 4;
        int randomNum = rand.nextInt((max - min) + 1) + min;
    	
        model.addAttribute("quotation", quotations.get(randomNum));
        

    	User user = new User();
    	
    	user.setAge(10);
    	user.setName("T"+System.currentTimeMillis());
    	
    	user = userService.saveUser(user);
    	
    	model.addAttribute("user", user);
    	
        return "index";
    }
    
    private List<String> getQuotations () {
    	List <String> quotations = new ArrayList<String>();
    	quotations.add("Simplicity is prerequisite for reliability. ~ Edsger Dijkstra");
    	quotations.add("The sooner you start to code, the longer the program will take. ~ Roy Carlson, University of Wisconsin");
    	quotations.add("“When debugging, novices insert corrective code; experts remove defective code.” ~ Richard Pattis");
    	quotations.add("Measuring programming progress by lines of code is like measuring aircraft building progress by weight. ~ Bill Gates");
    	quotations.add("“People think that computer science is the art of geniuses but the actual reality is the opposite, just many people doing things that build on each other, like a wall of mini stones.” ~ Donald Knuth (computer scientist)");
    	    	
    	return quotations;
    }
}