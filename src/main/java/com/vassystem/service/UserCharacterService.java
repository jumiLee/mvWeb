package com.vassystem.service;


import com.vassystem.dto.CharacterCustInfo;
import com.vassystem.dto.UserCharacter;
import com.vassystem.packet.CharacterPacket;

public interface UserCharacterService {
	
	/*select Character List */
	CharacterPacket selectCharacterList(int user_account) throws Exception;
	
	/*select Carry Character List */
	UserCharacter selectCarryCharacter(int user_account) throws Exception;
	
	/* update User Character */
	CharacterPacket modifyUserCharacter(int job_code, int user_account, int char_id, int user_char_sn, CharacterCustInfo char_cust_info) throws Exception;
}