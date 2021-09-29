package com.vassystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vassystem.dto.UserAttend;
import com.vassystem.service.UserAttendService;

@RestController
public class UserAttendController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private UserAttendService attendService;
	
	/* attend list Select */
	@RequestMapping(value="/userAttend.do")
	public ModelAndView  selectMember(Model model, @RequestParam int user_account) throws Exception {
		
		List<UserAttend> userAttendList = attendService.selectUserAttendList(user_account);
	
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userAttendList", userAttendList);
		
		return new ModelAndView("user_attend", params);
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		//return "index";
		return new ModelAndView("index");
	}
}