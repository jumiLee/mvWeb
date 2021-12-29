package com.vassystem.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.vassystem.dto.UserReceiveBox;

import common.dao.AbstractDAO;
import common.util.ParamVO;

@Repository("UserReceiveBoxDAO")
public class UserReceiveBoxDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<UserReceiveBox> selectReceiveBox(ParamVO paramVO) throws Exception{ 
		return selectList("userReceiveBox.selectReceiveBoxList", paramVO); 
	}
	
	public Object mgmtReceiveBox(ParamVO paramVO) throws Exception{ 
		return selectOne("userReceiveBox.mgmtReceiveBox", paramVO); 
	}
}