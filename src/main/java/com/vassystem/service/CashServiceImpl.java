package com.vassystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vassystem.dao.CashDAO;
import com.vassystem.dto.Cash;
import com.vassystem.packet.CashPacket;
import common.util.ParamVO;

@Service 
public class CashServiceImpl implements CashService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="CashDAO") 
	private CashDAO cashDAO; 

	@Override
	public CashPacket selectCashList(int user_account, int device_type, int payment_type) throws Exception {
		
		CashPacket cashPacket = new CashPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(device_type); 
		vo.setInParam02(payment_type); 
		
		List<Cash> cashList = cashDAO.selectCashList(vo);
		
		if(cashList.size() == 0) {
			resultCd = -1;
			resultMsg ="There is no item";
		}
		
		cashPacket.cashList = cashList;
		cashPacket.setHeader(user_account, resultCd, resultMsg);
		
		return cashPacket;
	}
}