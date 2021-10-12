package com.vassystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vassystem.dao.CharacterDAO;
import com.vassystem.dto.CharacterCustInfo;
import com.vassystem.dto.UserCharacter;
import com.vassystem.packet.CharacterPacket;

import common.util.ParamVO;

@Service 
public class UserCharacterServiceImpl implements UserCharacterService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="CharacterDAO") 
	private CharacterDAO characterDAO; 

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
	
	/*select Carry Character List */
	@Override
	public UserCharacter selectCarryCharacter(int user_account) throws Exception{
	
		List<UserCharacter> userCharacterList = selectCharacterList(user_account).userCharacterList;
		
		return userCharacterList.stream()
				.filter(s -> s.carry_flag.equals("Y"))
				.findAny()
				.orElse(null);
	}
	
	//update User Character 
	@Override
	public CharacterPacket modifyUserCharacter(int job_code, int user_account, int char_id, int user_char_sn, CharacterCustInfo char_cust_info) throws Exception {
			
		CharacterPacket characterPacket = new CharacterPacket();
		int resultCd = 0;
		String resultMsg = "";
			
		ParamVO vo = new ParamVO(); 			
		vo.setInParam01(job_code); 
		vo.setInParam02(user_account); 
		vo.setInParam03(char_id);
		vo.setInParam04(user_char_sn);
		vo.setInObjParam01(char_cust_info);
			
		characterDAO.modifyUserCharacter(vo);
			
		resultCd = vo.getOutParam01();
		resultMsg = vo.getOutStrParam01();
			
		if(resultCd == 0) {
			characterPacket.carryUserCharacter = selectCarryCharacter(user_account);
		}
		characterPacket.setHeader(user_account, resultCd, resultMsg);
			
		return characterPacket;
	}
	
}