package com.vassystem.packet;

import java.util.List;

import com.vassystem.dto.UserCharEquipItem;

public class UserCharEquipItemPacket extends HeaderPacket {
	
	public String sid;
	public List<UserCharEquipItem> userCharEquipItemList;	
}