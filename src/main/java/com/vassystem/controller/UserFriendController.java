package com.vassystem.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vassystem.dto.UserFriend;
import com.vassystem.packet.UserFriendPacket;
import com.vassystem.service.UserFriendService;

import common.util.FriendMgmtType;

@RestController
public class UserFriendController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private UserFriendService userFriendService;
	
	// 친구신청 
	@RequestMapping(value="/requestFriend.do", produces = "application/json")
	@ResponseBody
	public UserFriendPacket requestFriend(@RequestParam int user_account, 
									 	  @RequestParam int frd_account) throws Exception {
		return userFriendService.mgmtFriend(FriendMgmtType.REQUEST_FRIEND.getCode(), user_account, frd_account);
	}
		
	// 친구리스트 > 친구요청수락
	@RequestMapping(value="/acceptFriend.do", produces = "application/json")
	@ResponseBody
	public UserFriendPacket acceptFriend(@RequestParam int user_account, 
									 	 @RequestParam int frd_account) throws Exception {
		
		return userFriendService.mgmtFriend(FriendMgmtType.ACCEPT_FRIEND.getCode(), user_account, frd_account);
	}
	
	// 친구리스트 > 친구요청거절 
	@RequestMapping(value="/rejectFriend.do", produces = "application/json")
	@ResponseBody
	public UserFriendPacket rejectFriend( @RequestParam int user_account, 
									 	  @RequestParam int frd_account) throws Exception {
		return userFriendService.mgmtFriend(FriendMgmtType.REJECT_FRIEND.getCode(), user_account, frd_account);
	}
	
	// 친구요청취소 
	@RequestMapping(value="/cancelRequestFriend.do", produces = "application/json")
	@ResponseBody
	public UserFriendPacket cancelRequestFriend( @RequestParam int user_account, 
									 	  		 @RequestParam int frd_account) throws Exception {
		return userFriendService.mgmtFriend(FriendMgmtType.CANCEL_FRIEND_REQUEST.getCode(), user_account, frd_account);
	}
	
	// 친구삭제 
	@RequestMapping(value="/deleteFriend.do", produces = "application/json")
	@ResponseBody
	public UserFriendPacket deleteFriend( @RequestParam int user_account, 
									 	  @RequestParam int frd_account) throws Exception {
		return userFriendService.mgmtFriend(FriendMgmtType.DELETE_FRIEND.getCode(), user_account, frd_account);
	}
	
	//나의 친구 리스트 조회 (신청온 친구 + 이미 친구)
	@RequestMapping(value="/geMyFriendList.do", produces = "application/json")
	@ResponseBody
	public UserFriendPacket geMyFriendList(	@RequestParam int user_account) throws Exception {
		return userFriendService.getFriendList(user_account);
	}	
}