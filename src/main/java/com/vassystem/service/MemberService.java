package com.vassystem.service;

import common.util.UserLevelType;

import com.vassystem.dto.Member;
import com.vassystem.packet.MemberInfoPacket;

public interface MemberService {
	
	/*select Member */
	Member selectMember(String email, String pwd) throws Exception;
	
	/* login check */
	MemberInfoPacket loginCheck(String email, String pwd) throws Exception;
	
	/* register */
	MemberInfoPacket register(UserLevelType userLevel, String email, String pwd, String nickname, int ch_type, String ch_id) throws Exception;
	
	/* session check */
	int checkSession(int user_account, String sid);
}