package com.vassystem.service;


import java.util.List;
import com.vassystem.dto.UserCharacter;
import com.vassystem.packet.CharacterPacket;

public interface CharacterService {
	
	/*select Character List */
	CharacterPacket selectCharacterList(int user_account) throws Exception;
}