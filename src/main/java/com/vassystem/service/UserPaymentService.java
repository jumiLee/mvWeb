package com.vassystem.service;

import com.vassystem.dto.UserPayment;
import com.vassystem.packet.ResultPacket;
import com.vassystem.packet.ResultPaymentPacket;

public interface UserPaymentService {
	
	/* RequestPayment */
	ResultPaymentPacket requestPayment(int user_account, int cash_id, int device_type, int payment_type) throws Exception;

	/* update Payment Result */
	ResultPacket updatePayment(int user_account, int cash_id, int trade_no, String order_no, int trade_res_cd, String trade_res_msg, String trade_res_key) throws Exception;

	UserPayment getUserPayment(int user_account, int trade_no) throws Exception;
		
}