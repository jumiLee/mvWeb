package com.vassystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vassystem.dao.ItemDAO;
import com.vassystem.dto.Item;
import com.vassystem.packet.ItemPacket;
import common.util.ParamVO;

@Service 
public class ItemServiceImpl implements ItemService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="ItemDAO") 
	private ItemDAO itemDAO; 

	@Override
	public ItemPacket selectItemListByCategory(int user_account, int item_category) throws Exception {
		
		ItemPacket itemPacket = new ItemPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(1); 
		vo.setInParam02(item_category); 
		
		List<Item> itemList = itemDAO.selectItemList(vo);
		
		if(itemList.size() == 0) {
			resultCd = -1;
			resultMsg ="There is no item";
		}
		
		itemPacket.itemList = itemList;
		itemPacket.setHeader(user_account, resultCd, resultMsg);
		
		return itemPacket;
	}
}