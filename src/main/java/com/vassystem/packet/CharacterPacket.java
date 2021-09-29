package com.vassystem.packet;

import java.util.List;

import com.vassystem.dto.UserCharacter;

public class CharacterPacket extends HeaderPacket {
	
	public String sid;
	public List<UserCharacter> userCharacterList;	
}