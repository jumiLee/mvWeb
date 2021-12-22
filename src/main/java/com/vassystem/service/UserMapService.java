package com.vassystem.service;

import com.vassystem.packet.UserMapPacket;

public interface UserMapService {
	
	UserMapPacket save(int user_account, int char_id, int user_char_sn, int map_type, String map_data);
	
	UserMapPacket findById(int user_account, int char_id, int user_char_sn, int map_type);
}