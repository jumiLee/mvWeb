package com.vassystem.packet;

import java.util.List;
import com.vassystem.dto.UserFriend;

public class UserFriendPacket extends HeaderPacket {
	
	public String sid;
	public List<UserFriend> userFriendList;	
}