package com.vassystem.service;

import com.vassystem.packet.CashPacket;

public interface CashService {
	
	/*select cash List */
	CashPacket selectCashList(int user_account, int device_type, int payment_type) throws Exception;
	
	/* Buy Cash Item */
	int mgmtCash(int job_code, int user_account, int frd_account, int cash_id, int payment_type) throws Exception;
}