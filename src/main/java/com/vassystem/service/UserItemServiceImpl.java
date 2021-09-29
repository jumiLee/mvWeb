package com.vassystem.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vassystem.dao.UserItemDAO;
import com.vassystem.packet.UserItemBuyPacket;

import common.util.ItemMgmtType;
import common.util.ParamVO;

@Service 
public class UserItemServiceImpl implements UserItemService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserItemDAO") 
	private UserItemDAO userItemDAO; 

	@Override
	public UserItemBuyPacket buyItem(int user_account, int item_id) throws Exception {
		
		UserItemBuyPacket userItemBuyPacket = new UserItemBuyPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(ItemMgmtType.BUY.getCode()); 
		vo.setInParam02(user_account); 
		vo.setInParam03(item_id);
		vo.setInParam04(1);
		
		userItemDAO.buyItem(vo);
		
		resultCd = vo.getOutParam01();
		resultMsg = vo.getOutStrParam01();
		
		userItemBuyPacket.setHeader(user_account, resultCd, resultMsg);
		
		return userItemBuyPacket;
	}
}