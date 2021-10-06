package com.vassystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vassystem.dto.UserAttend;

import common.dao.AbstractDAO;

@Repository("UserAttendDAO")
public class UserAttendDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<UserAttend> selectUserAttendList(int user_account) throws Exception{ 
		return selectList("userAttend.selectUserAttendList", user_account); 
	}
}