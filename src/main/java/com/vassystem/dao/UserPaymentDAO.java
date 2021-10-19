package com.vassystem.dao;

import org.springframework.stereotype.Repository;

import com.vassystem.dto.UserPayment;

import common.dao.AbstractDAO;
import common.util.ParamVO;

@Repository("UserPaymentDAO")
public class UserPaymentDAO extends AbstractDAO {

	public Object requestPayment(ParamVO paramVO) throws Exception{ 
		return selectOne("userPayment.requestPayment", paramVO); 
	}
	
	public Object updatePayment(ParamVO paramVO) throws Exception{ 
		return selectOne("userPayment.updatePayment", paramVO); 
	}
	
	public UserPayment selectUserPayment(ParamVO paramVO) throws Exception{ 
		return (UserPayment) selectOne("userPayment.selectUserPayment", paramVO); 
	}
}