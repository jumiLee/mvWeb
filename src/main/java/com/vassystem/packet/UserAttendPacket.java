package com.vassystem.packet;

import java.util.List;

import com.vassystem.dto.UserAttend;

public class UserAttendPacket extends HeaderPacket {
	
	public String sid;
	
	public List<UserAttend> userAttendList;	
}