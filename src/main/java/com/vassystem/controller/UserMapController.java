package com.vassystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vassystem.packet.UserMapPacket;
import com.vassystem.service.UserMapService;

@RestController
public class UserMapController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private UserMapService userMapservice;
	
	/* Save user map data  */
	@RequestMapping(value="/saveUserMap.do", produces = "application/json")
	public UserMapPacket saveUserMap(@RequestParam int user_account, @RequestParam int char_id, @RequestParam int user_char_sn, @RequestParam int map_type, @RequestParam String map_data) throws Exception {
		return userMapservice.save(user_account, char_id, user_char_sn, map_type, map_data);
	}
	
	/* Select user map data  */
	@RequestMapping(value="/selectUserMap.do", produces = "application/json")
	public UserMapPacket selectUserMap(int user_account, int char_id, int user_char_sn, int map_type) throws Exception {
		return userMapservice.findById(user_account, char_id, user_char_sn, map_type);
	}
}