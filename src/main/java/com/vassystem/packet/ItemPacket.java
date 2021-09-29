package com.vassystem.packet;

import java.util.List;
import com.vassystem.dto.Item;

public class ItemPacket extends HeaderPacket {
	
	public String sid;
	public List<Item> itemList;	
}