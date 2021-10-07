package com.vassystem.packet;

import com.vassystem.dto.UserCharacter;

//T001
public class MemberInitialInfoPacket extends HeaderPacket {
	
	public String sid;
	public UserCharacter carryUserCharacter;	//대표캐릭터 
	public String new_msg_flag;
	public String new_item_flag;
	public String new_achv_flag;
	public String new_frd_flag;
	public String attend_show_flag; //Y:출석체크화면 보여줌 N:인보여줌 
}