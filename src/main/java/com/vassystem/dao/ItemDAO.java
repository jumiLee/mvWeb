package com.vassystem.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.vassystem.dto.Item;
import common.dao.AbstractDAO;
import common.util.ParamVO;

@Repository("ItemDAO")
public class ItemDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Item> selectItemList(ParamVO paramVO) throws Exception{ 
		return selectList("item.selectItemList", paramVO); 
	}
}