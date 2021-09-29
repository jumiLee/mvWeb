package com.vassystem.packet;

import com.vassystem.dto.UserDetail;

//T001
public class MemberInfoPacket extends HeaderPacket {
	
	public String sid;
	public UserDetail userDetail;	//user detail info 	
}