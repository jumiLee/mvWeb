package com.vassystem.service;

import com.vassystem.packet.UserAttendPacket;

public interface UserAttendService {
	
	/*select Member */
	UserAttendPacket selectUserAttendList(int user_account) throws Exception;

	/* session check */
	int checkSession(int user_account, String sid);
}