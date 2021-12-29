package com.vassystem.service;

import com.vassystem.packet.ResultPacket;
import com.vassystem.packet.UserAttendPacket;

public interface UserAttendService {
	
	/*attend List  */
	UserAttendPacket selectUserAttendList(int user_account) throws Exception;

	/* attend Register */
	ResultPacket registerUserAttend(int user_account) throws Exception;
	
	/* session check */
	int checkSession(int user_account, String sid);

}