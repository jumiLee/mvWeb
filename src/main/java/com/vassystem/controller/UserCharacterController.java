package com.vassystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vassystem.packet.CharacterPacket;
import com.vassystem.service.UserCharacterService;


@RestController
public class UserCharacterController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private UserCharacterService characterService;
	
	/* character Select */
	@RequestMapping(value="/selectCharacterList.do", produces = "application/json")
	@ResponseBody
	public CharacterPacket selectCharacterList(@RequestParam int user_account) throws Exception {
		
		return characterService.selectCharacterList(user_account);
	}
	
	/* update character info */
	@RequestMapping(value="/modifyUserCharacter.do", produces = "application/json")
	@ResponseBody
	public CharacterPacket modifyUserCharacter(@RequestParam int user_account, 
									 		@RequestParam int char_id,
									 		@RequestParam int user_char_sn,
									 		@RequestParam String char_cust_info) throws Exception {
		
		return characterService.modifyUserCharacter(1, user_account, char_id, user_char_sn, char_cust_info);
	}
}