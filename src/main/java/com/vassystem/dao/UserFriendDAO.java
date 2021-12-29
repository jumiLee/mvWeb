package com.vassystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vassystem.dto.UserFriend;

import common.dao.AbstractDAO;
import common.util.ParamVO;

@Repository("UserFriendDAO")
public class UserFriendDAO extends AbstractDAO {

	public Object mgmtFriend(ParamVO paramVO) throws Exception{ 
		return selectOne("userFriend.mgmtFriend", paramVO); 
	}
	
	@SuppressWarnings("unchecked")
	public List<UserFriend> getFriendList(ParamVO paramVO) throws Exception{ 
		return selectList("userFriend.selectFriendList", paramVO); 
	}
}