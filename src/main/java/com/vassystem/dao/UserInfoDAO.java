package com.vassystem.dao;

import org.springframework.stereotype.Repository;

import common.dao.AbstractDAO;
import common.util.ParamVO;
import com.vassystem.dto.UserNotice;
import com.vassystem.packet.MemberInitialInfoPacket;
import com.vassystem.dto.UserDetail;

@Repository("UserInfoDAO")
public class UserInfoDAO extends AbstractDAO {

	public UserDetail selectUserDetail(int user_account) { 
		return (UserDetail) selectOne("userMain.selectUserDetail", user_account); 
	}
	
	public UserNotice selectUserNotice(int user_account) throws Exception{ 
		return (UserNotice) selectOne("userMain.selectUserNotice", user_account); 
	}
	
	public int selectUserAttend(int user_account) throws Exception{ 
		return (Integer) selectOne("userMain.selectUserAttend", user_account); 
	}
	
	public MemberInitialInfoPacket selectUserInitialInfo(int user_account) throws Exception{ 
		return (MemberInitialInfoPacket) selectOne("userMain.selectUserInitialInfo", user_account); 
	}
	
	public int updatSid(ParamVO paramVO) { 
		return (Integer) update("userMain.updateSid", paramVO); 
	}
	
	public int selectUserBySid(ParamVO paramVO) { 
		return (Integer) selectOne("userMain.selectUserBySid", paramVO); 
	}
}