package com.vassystem.service;

import com.vassystem.packet.UserItemPacket;

public interface UserItemService {
	
	/*select Character List */
	UserItemPacket buyItem(int user_account, int item_code) throws Exception;
}