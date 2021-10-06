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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vassystem.dto.UserAttend;
import com.vassystem.packet.UserAttendPacket;
import com.vassystem.service.UserAttendService;

@RestController
public class UserAttendController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private UserAttendService attendService;
	
	/* attend list Select */
	@RequestMapping(value="/userAttend.do")
	public ModelAndView  selectMember(Model model, @RequestParam int user_account) throws Exception {
		
		UserAttendPacket userAttendPacket = attendService.selectUserAttendList(user_account);
		List<UserAttend> userAttendList = userAttendPacket.userAttendList;
	
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userAttendList", userAttendList);
		
		return new ModelAndView("user_attend", params);
	}
	
	/* Select item List  */
	@RequestMapping(value="/selectUserAttend.do", produces = "application/json")
	@ResponseBody
	public UserAttendPacket selectUserAttend(@RequestParam int user_account) throws Exception {
		
		return attendService.selectUserAttendList(user_account);
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		//return "index";
		return new ModelAndView("index");
	}
}