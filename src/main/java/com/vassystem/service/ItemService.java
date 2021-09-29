package com.vassystem.service;

import com.vassystem.packet.ItemPacket;

public interface ItemService {
	
	/*select Character List */
	ItemPacket selectItemListByCategory(int user_account, int item_category) throws Exception;
}