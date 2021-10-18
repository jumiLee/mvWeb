package com.vassystem.service;

import com.vassystem.packet.CashPacket;

public interface CashService {
	
	/*select cash List */
	CashPacket selectCashList(int user_account, int device_type, int payment_type) throws Exception;
}