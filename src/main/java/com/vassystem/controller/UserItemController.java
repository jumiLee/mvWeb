package com.vassystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vassystem.packet.UserCharEquipItemPacket;
import com.vassystem.packet.ResultPacket;
import com.vassystem.service.UserItemService;


@RestController
public class UserItemController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private UserItemService userItemService;
	
	/* Buy and Equip Item */
	@RequestMapping(value="/buyAndEquipItem.do", produces = "application/json")
	@ResponseBody
	public ResultPacket buyAndEquipItem(@RequestParam int user_account, 
									 @RequestParam int char_id,
									 @RequestParam int user_char_sn,
									 @RequestParam String item_id_array) throws Exception {
		
		return userItemService.buyItem(user_account, char_id, user_char_sn, "Y", item_id_array);
	}
	
	/* Buy Item */
	@RequestMapping(value="/buyItem.do", produces = "application/json")
	@ResponseBody
	public ResultPacket buyItem(@RequestParam int user_account, 
								@RequestParam String item_id_array) throws Exception {
		
		return userItemService.buyItem(user_account, 0, 0, "N", item_id_array);
	}
	
	/* Search My Item */
	@RequestMapping(value="/getMyItemWithEquip.do", produces = "application/json")
	@ResponseBody
	public UserCharEquipItemPacket getMyItemWithEquip(@RequestParam int user_account, 
									 @RequestParam int char_id,
									 @RequestParam int user_char_sn,
									 @RequestParam int item_category,
									 @RequestParam int item_type) throws Exception {
		
		return userItemService.getMyItemWithEquip(1, user_account, char_id, user_char_sn, item_category, item_type);
	}
	
	/* Equip Item */
	@RequestMapping(value="/equipItem.do", produces =" application/json")
	@ResponseBody
	public UserCharEquipItemPacket equipItem (	@RequestParam int job_code, 	// 1:equip 2:take off
												@RequestParam int user_account,
			 									@RequestParam int char_id,
			 									@RequestParam int user_char_sn,
			 									@RequestParam int item_id,
			 									@RequestParam int item_uniqueID,
			 									@RequestParam int item_category,
												@RequestParam int item_type) throws Exception { 
		
		return userItemService.equipItem(job_code, user_account, char_id, user_char_sn, item_id, item_uniqueID, item_category, item_type);
	}	
	
	/* Equip Item All (일괄 해제 및 장착 */
	@RequestMapping(value="/equipItemAll.do", produces =" application/json")
	@ResponseBody
	public UserCharEquipItemPacket equipItemAll(@RequestParam int user_account,
			 									@RequestParam int char_id,
			 									@RequestParam int user_char_sn,
			 									@RequestParam String item_uniqueID_ary,
			 									@RequestParam int item_category,
												@RequestParam int item_type) throws Exception { 
		
		return userItemService.equipItemAll(user_account, char_id, user_char_sn, item_uniqueID_ary, item_category, item_type);
	}	
}