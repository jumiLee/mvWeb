package com.vassystem.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.vassystem.dto.UserCharEquipItem;
import common.dao.AbstractDAO;
import common.util.ParamVO;

@Repository("UserItemDAO")
public class UserItemDAO extends AbstractDAO {

	public Object buyItem(ParamVO paramVO) throws Exception{ 
		return selectOne("userItem.buyItem", paramVO); 
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCharEquipItem> getMyItemWithEquip(ParamVO paramVO) throws Exception{ 
		return selectList("userItem.selectMyItemWithEquip", paramVO); 
	}
	
	public Object equipItem(ParamVO paramVO) throws Exception{ 
		return selectOne("userItem.equipItem", paramVO); 
	}
	
	public Object equipItemAll(ParamVO paramVO) throws Exception{ 
		return selectOne("userItem.equipItemAll", paramVO); 
	}
}