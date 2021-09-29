package com.vassystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vassystem.packet.ItemPacket;
import com.vassystem.service.ItemService;


@RestController
public class UserItemController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private ItemService itemService;
	
	/* Buy Item */
	@RequestMapping(value="/buyItem.do", produces = "application/json")
	@ResponseBody
	public ItemPacket selectItemListByCategory(@RequestParam int user_account, @RequestParam int item_id) throws Exception {
		
		return itemService.selectItemListByCategory(user_account, item_id);
	}
}