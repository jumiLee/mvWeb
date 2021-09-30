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
	public UserItemBuyPacket buyItem(int user_account, int char_id, int user_char_sn, int equip_flag, String item_id_array) throws Exception {
		
		UserItemBuyPacket userItemBuyPacket = new UserItemBuyPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(ItemMgmtType.BUY.getCode()); 
		vo.setInParam02(user_account); 
		vo.setInParam03(char_id);
		vo.setInParam04(user_char_sn);
		vo.setInParam05(equip_flag);
		vo.setInStrParam01(item_id_array);
		
		userItemDAO.buyItem(vo);
		
		resultCd = vo.getOutParam01();
		resultMsg = vo.getOutStrParam01();
		
		userItemBuyPacket.setHeader(user_account, resultCd, resultMsg);
		
		return userItemBuyPacket;
	}
}