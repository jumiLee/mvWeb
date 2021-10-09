package com.vassystem.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vassystem.packet.ResultPacket;
import com.vassystem.packet.UserReceiveBoxPacket;
import com.vassystem.service.ReceiveBoxService;

@RestController
public class ReceiveBoxController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private ReceiveBoxService receiveBoxService;
	
	/* Select item List  */
	@RequestMapping(value="/selectReceiveBox.do", produces = "application/json")
	@ResponseBody
	public UserReceiveBoxPacket selectReceiveBox(@RequestParam int job_code, @RequestParam int user_account) throws Exception {
		
		return receiveBoxService.selectReceiveBox(job_code, user_account);
	}
	
	/* Receive Message */
	@RequestMapping(value="/mgmtReceiveBox.do", produces = "application/json")
	@ResponseBody
	public ResultPacket receiveBox(	@RequestParam int job_code, 
									@RequestParam int user_account,
									@RequestParam int receive_sn) throws Exception {
		
		return receiveBoxService.mgmtReceiveBox(job_code, user_account, receive_sn, 0, 0, 0, 0, StringUtils.EMPTY);
	}
}