package com.vassystem.service;

import com.vassystem.packet.UserCharEquipItemPacket;
import com.vassystem.packet.ResultPacket;

public interface UserItemService {
	
	/* Buy Item */
	ResultPacket buyItem(int user_account, int char_id, int user_char_sn, String equip_flag, String item_id_array) throws Exception;
	
	/* Get My Item */
	UserCharEquipItemPacket getMyItemWithEquip(int job_type, int user_account, int char_id, int user_char_sn, int item_category, int item_type) throws Exception;
	
	/* Equip Item */
	UserCharEquipItemPacket equipItem(int job_type, int user_account, int char_id, int user_char_sn, int item_id, int item_uniqueID, int item_category, int item_type) throws Exception;
}