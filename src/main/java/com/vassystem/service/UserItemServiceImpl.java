package com.vassystem.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vassystem.dao.UserItemDAO;
import com.vassystem.packet.UserCharEquipItemPacket;
import com.vassystem.packet.UserItemBuyPacket;

import common.util.ItemMgmtType;
import common.util.ParamVO;

@Service 
public class UserItemServiceImpl implements UserItemService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserItemDAO") 
	private UserItemDAO userItemDAO; 

	//Buy Item
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
	
	//Get My Inventory
	@Override
	public UserCharEquipItemPacket getMyItemWithEquip(int job_type, int user_account, int char_id, int user_char_sn, int item_category, int item_type) throws Exception {
		
		UserCharEquipItemPacket userCharEquipItemPacket = new UserCharEquipItemPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(job_type); 
		vo.setInParam02(user_account); 
		vo.setInParam03(char_id);
		vo.setInParam04(user_char_sn);
		vo.setInParam05(item_category);
		vo.setInParam06(item_type);
		
		userCharEquipItemPacket.userCharEquipItemList= userItemDAO.getMyItemWithEquip(vo);
		userCharEquipItemPacket.setHeader(user_account, resultCd, resultMsg);
		
		return userCharEquipItemPacket;
	}
	
	// Equip Item
	@Override
	public UserCharEquipItemPacket equipItem(int job_type, int user_account, int char_id, int user_char_sn, int item_id, int item_uniqueID, int item_category, int item_type) throws Exception {
		
		UserCharEquipItemPacket userCharEquipItemPacket = new UserCharEquipItemPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		//Equip Item Process
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(job_type); 
		vo.setInParam02(user_account); 
		vo.setInParam03(char_id);
		vo.setInParam04(user_char_sn);
		vo.setInParam05(item_id);
		vo.setInParam06(item_uniqueID);
		
		userItemDAO.equipItem(vo);
		
		resultCd = vo.getOutParam01();
		resultMsg = vo.getOutStrParam01();
		
		if(resultCd == 0) {
			//Get refreshed Equip Item Data 
			userCharEquipItemPacket = this.getMyItemWithEquip(1,user_account,char_id, user_char_sn,item_category, item_type );
		}
		userCharEquipItemPacket.setHeader(user_account, resultCd, resultMsg);
		
		return userCharEquipItemPacket;
	}
}