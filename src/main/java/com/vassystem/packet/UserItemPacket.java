package com.vassystem.packet;

import java.util.List;
import com.vassystem.dto.UserItem;

public class UserItemPacket extends HeaderPacket {
	
	public String sid;
	public List<UserItem> userItemList;	
}