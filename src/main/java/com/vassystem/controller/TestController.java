package com.vassystem.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@GetMapping("/link")
	public String test(Model model) {
		return "link";
	}
	
	@GetMapping("/user_login_ap")
	public String userLoginAp(Model model, @RequestParam int m_no) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("m_no", m_no);
		
		return "user_login_ap";
	}

}
