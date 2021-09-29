package com.vassystem.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.vassystem.dto.UserItem;

import common.dao.AbstractDAO;
import common.util.ParamVO;

@Repository("UserItemDAO")
public class UserItemDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<UserItem> buyItem(ParamVO paramVO) throws Exception{ 
		return selectList("userItem.buyItem", paramVO); 
	}
}