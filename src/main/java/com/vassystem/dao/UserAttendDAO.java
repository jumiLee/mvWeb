package com.vassystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vassystem.dto.UserAttend;

import common.dao.AbstractDAO;
import common.util.ParamVO;


@Repository("UserAttendDAO")
public class UserAttendDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<UserAttend> selectUserAttendList(ParamVO paramVO) throws Exception{ 
		return selectList("userAttend.selectUserAttendList", paramVO); 
	}
}