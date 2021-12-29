package com.vassystem.packet;

import com.vassystem.dto.UserCharacter;
import com.vassystem.dto.UserDetail;

//T001
public class MemberInitialInfoPacket extends HeaderPacket {
	
	public String sid;
	public UserDetail userDetail;	//사용자 정보 
	public UserCharacter carryUserCharacter;	//대표캐릭터 
	
	//new icon flag 설
	public String new_msg_flag;
	public String new_item_flag;
	public String new_achv_flag;
	public String new_frd_flag;
	
	//Y:출석체크화면 보여줌 N:인보여줌 
	public String attend_show_flag; 
}