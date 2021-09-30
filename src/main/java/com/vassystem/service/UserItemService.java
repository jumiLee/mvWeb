package com.vassystem.service;

import com.vassystem.packet.UserItemBuyPacket;

public interface UserItemService {
	
	/* Buy Item */
	UserItemBuyPacket buyItem(int user_account, int char_id, int user_char_sn, int equip_flag, String item_id_array) throws Exception;
}