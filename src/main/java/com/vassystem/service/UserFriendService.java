package com.vassystem.service;

import com.vassystem.packet.UserFriendPacket;

public interface UserFriendService {
	
	/* manage friend*/
	UserFriendPacket mgmtFriend(int job_code, int user_account, int frd_account) throws Exception;
	
	/* Get friend list according to job_type */
	UserFriendPacket getFriendList(int job_type, int user_account) throws Exception;
	
	/* Get friend list */
	UserFriendPacket getFriendList(int user_account) throws Exception;
	
}