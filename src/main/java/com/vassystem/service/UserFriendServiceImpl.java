package com.vassystem.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vassystem.dao.UserFriendDAO;
import com.vassystem.dto.UserFriend;
import com.vassystem.packet.UserFriendPacket;
import common.util.ParamVO;

@Service 
public class UserFriendServiceImpl implements UserFriendService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserFriendDAO") 
	private UserFriendDAO userFriendDAO; 

	//manage friend
	@Override
	public UserFriendPacket mgmtFriend(int job_code, int user_account, int frd_account) throws Exception {
		
		UserFriendPacket userFriendPacket = new UserFriendPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(job_code); 
		vo.setInParam02(user_account); 
		vo.setInParam03(frd_account);
		
		userFriendDAO.mgmtFriend(vo);
		
		resultCd = vo.getOutParam01();
		resultMsg = vo.getOutStrParam01();
		
		if(resultCd == 0) {
			userFriendPacket = getFriendList(user_account);
		}
		userFriendPacket.setHeader(user_account, resultCd, resultMsg);
		
		return userFriendPacket;
	}
	
	// Get friend list
	@Override
	public UserFriendPacket getFriendList(int job_code, int user_account) throws Exception {
		
		UserFriendPacket userFriendPacket = new UserFriendPacket();
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(job_code); 
		vo.setInParam02(user_account); 
		
		userFriendPacket.userFriendList = userFriendDAO.getFriendList(vo);
		
		return userFriendPacket;
	}
	
	// Get friend list
	@Override
	public UserFriendPacket getFriendList(int user_account) throws Exception {
		
		UserFriendPacket userFriendPacket = new UserFriendPacket();
			
		//친구목록 
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(1); 
		vo.setInParam02(user_account); 
		List<UserFriend> alreadyFriendList = userFriendDAO.getFriendList(vo); 
		
		//친구요청온 목록 
		ParamVO vo2 = new ParamVO(); 
		vo2.setInParam01(3); 
		vo2.setInParam02(user_account); 
		List<UserFriend> requestedFriendList = userFriendDAO.getFriendList(vo2); 

		List<UserFriend> allFriendList = Stream.of(alreadyFriendList,requestedFriendList)
												.flatMap(x -> x.stream())
												.collect(Collectors.toList());
		
		userFriendPacket.userFriendList = allFriendList;
			
		return userFriendPacket;
	}
}