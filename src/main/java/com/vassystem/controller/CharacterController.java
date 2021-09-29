package com.vassystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vassystem.packet.CharacterPacket;
import com.vassystem.service.CharacterService;


@RestController
public class CharacterController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private CharacterService characterService;
	
	/* character Select */
	@RequestMapping(value="/selectCharacterList.do", produces = "application/json")
	@ResponseBody
	public CharacterPacket selectCharacterList(@RequestParam int user_account) throws Exception {
		
		return characterService.selectCharacterList(user_account);
	}
}