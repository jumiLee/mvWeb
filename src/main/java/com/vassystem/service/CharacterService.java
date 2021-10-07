package com.vassystem.service;


import com.vassystem.dto.UserCharacter;
import com.vassystem.packet.CharacterPacket;

public interface CharacterService {
	
	/*select Character List */
	CharacterPacket selectCharacterList(int user_account) throws Exception;
	
	/*select Carry Character List */
	UserCharacter selectCarryCharacter(int user_account) throws Exception;
}