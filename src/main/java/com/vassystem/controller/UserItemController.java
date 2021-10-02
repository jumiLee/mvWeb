package com.vassystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vassystem.packet.UserItemBuyPacket;
import com.vassystem.service.UserItemService;


@RestController
public class UserItemController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private UserItemService userItemService;
	
	/* Buy Item */
	@RequestMapping(value="/buyAndEquipItem.do", produces = "application/json")
	@ResponseBody
	public UserItemBuyPacket buAndEquipItem(@RequestParam int user_account, 
									 @RequestParam int char_id,
									 @RequestParam int user_char_sn,
									 @RequestParam String item_id_array) throws Exception {
		
		return userItemService.buyItem(user_account, char_id, user_char_sn, 1, item_id_array);
	}
}