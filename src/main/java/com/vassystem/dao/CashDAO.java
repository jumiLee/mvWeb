package com.vassystem.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.vassystem.dto.Cash;
import common.dao.AbstractDAO;
import common.util.ParamVO;

@Repository("CashDAO")
public class CashDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Cash> selectCashList(ParamVO paramVO) throws Exception{ 
		return selectList("cash.selectCashList", paramVO); 
	}
}