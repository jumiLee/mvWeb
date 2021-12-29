package com.vassystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vassystem.packet.ResultPacket;
import com.vassystem.packet.ResultPaymentPacket;
import com.vassystem.service.UserPaymentService;


@RestController
public class UserPaymentController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private UserPaymentService userPaymentService;
	
	/* Request Payment */
	@RequestMapping(value="/requestPayment.do", produces = "application/json")
	@ResponseBody
	public ResultPaymentPacket requestPayment(	@RequestParam int user_account, 
												@RequestParam int cash_id,
												@RequestParam int device_type,
												@RequestParam int payment_type) throws Exception {
		
		return userPaymentService.requestPayment(user_account, cash_id, device_type, payment_type);
	}
	
	/* Update Payment Result */
	@RequestMapping(value="/updatePayment.do", produces = "application/json")
	@ResponseBody
	public ResultPacket updatePayment(	@RequestParam int user_account, 
										@RequestParam int cash_id,
										@RequestParam int trade_no,
										@RequestParam String order_no,
										@RequestParam int trade_res_cd,
										@RequestParam String trade_res_msg,
										@RequestParam String trade_res_key) throws Exception {
		
		return userPaymentService.updatePayment(user_account, cash_id, trade_no, order_no, trade_res_cd, trade_res_msg, trade_res_key);
	}
}