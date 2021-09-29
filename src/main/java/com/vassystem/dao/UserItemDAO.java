package com.vassystem.dao;

import org.springframework.stereotype.Repository;

import common.dao.AbstractDAO;
import common.util.ParamVO;

@Repository("UserItemDAO")
public class UserItemDAO extends AbstractDAO {

	public Object buyItem(ParamVO paramVO) throws Exception{ 
		return selectOne("userItem.buyItem", paramVO); 
	}
}