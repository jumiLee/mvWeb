package com.vassystem.service;

import com.vassystem.packet.UserItemBuyPacket;

public interface UserItemService {
	
	/* Buy Item */
	UserItemBuyPacket buyItem(int user_account, int item_id) throws Exception;
}