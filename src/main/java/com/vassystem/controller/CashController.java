package com.vassystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vassystem.packet.CashPacket;
import com.vassystem.service.CashService;

@RestController
public class CashController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private CashService cashService;
	
	/* Select item List  */
	@RequestMapping(value="/selectCashList.do", produces = "application/json")
	@ResponseBody
	public CashPacket selectCashList(@RequestParam int user_account, @RequestParam int device_type, @RequestParam int payment_type) throws Exception {
		
		return cashService.selectCashList(user_account, device_type, payment_type);
	}
}