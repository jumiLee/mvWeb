package com.vassystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vassystem.dao.CharacterDAO;
import com.vassystem.dto.CharacterCustInfo;
import com.vassystem.dto.UserCharacter;
import com.vassystem.packet.CharacterPacket;
import com.vassystem.packet.CharacterShapePacket;

import common.util.ParamVO;

@Service 
public class UserCharacterServiceImpl implements UserCharacterService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="CharacterDAO") 
	private CharacterDAO characterDAO; 
	
	@Autowired
	UserItemService userItemService;

	@Override
	public CharacterPacket selectCharacterList(int user_account) throws Exception {
		
		CharacterPacket characterPacket = new CharacterPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		List<UserCharacter> userCharacterList = characterDAO.selectCharacterList(user_account);
		
		if(CollectionUtils.isEmpty(userCharacterList)) {
			resultCd = -1;
			resultMsg ="There is no character";
		}
		
		characterPacket.userCharacterList = userCharacterList;
		characterPacket.carryUserCharacter = userCharacterList.stream()
														.filter(s -> s.carry_flag.equals("Y"))
														.findAny()
														.orElse(null);
		characterPacket.setHeader(user_account, resultCd, resultMsg);
		
		return characterPacket;
	}
	
	/*select Character Shape Info */
	@Override
	public CharacterShapePacket selectCharacterShapeInfo(int user_account, int char_id, int char_sn) throws Exception {
		
		CharacterShapePacket characterShapePacket = new CharacterShapePacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(1); 							//job_code
		vo.setInParam02(user_account); 					//user_account
		vo.setInParam03(char_id);	//attend_type
		vo.setInParam04(char_sn);								//day_no
		
		UserCharacter userCharacter = characterDAO.selectCharacterShapeInfo(vo);
		
		if(userCharacter.char_shape_info == null) {
			characterShapePacket.resultCd = -1;
			characterShapePacket.resultMsg = "No character shape information!";
		}else {
			characterShapePacket.char_shape_info = userCharacter.char_shape_info;
		}
	
		characterShapePacket.setHeader(user_account, resultCd, resultMsg);
		
		return characterShapePacket;
	}
	
	/*select Carry Character List */
	@Override
	public UserCharacter selectCarryCharacter(int user_account) throws Exception{
	
		List<UserCharacter> userCharacterList = selectCharacterList(user_account).userCharacterList;
		UserCharacter userCharacter = new UserCharacter();
		
		//character basic info 
		userCharacter =  userCharacterList.stream()
				.filter(s -> s.carry_flag.equals("Y"))
				.findAny()
				.orElse(null);
		
		
		//character Equip Items info
		userCharacter.char_equip_items = 
				userItemService.getMyItemWithEquip(2, user_account, userCharacter.char_id, userCharacter.user_char_sn, 0, 0).userCharEquipItemList;
		
		return userCharacter;
		
	}
	
	//update User Character 
	@Override
	public CharacterPacket modifyUserCharacter(int job_code, int user_account, int char_id, int user_char_sn, CharacterCustInfo char_cust_info, String char_shape_info) throws Exception {
			
		CharacterPacket characterPacket = new CharacterPacket();
		int resultCd = 0;
		String resultMsg = "";
			
		ParamVO vo = new ParamVO(); 			
		vo.setInParam01(job_code); 
		vo.setInParam02(user_account); 
		vo.setInParam03(char_id);
		vo.setInParam04(user_char_sn);
		vo.setInObjParam01(char_cust_info);
		vo.setInStrParam01(char_shape_info);
			
		characterDAO.modifyUserCharacter(vo);
			
		resultCd = vo.getOutParam01();
		resultMsg = vo.getOutStrParam01();
			
		if(resultCd == 0 && job_code == 1) { //shape 정보 변경일 경우엔, 캐릭터 정보 전송 안함.
			characterPacket.carryUserCharacter = selectCarryCharacter(user_account);
		}
		characterPacket.setHeader(user_account, resultCd, resultMsg);
			
		return characterPacket;
	}
	
}