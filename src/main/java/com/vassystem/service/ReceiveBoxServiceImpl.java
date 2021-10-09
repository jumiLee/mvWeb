package com.vassystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vassystem.dao.UserReceiveBoxDAO;
import com.vassystem.dto.UserReceiveBox;
import com.vassystem.packet.ResultPacket;
import com.vassystem.packet.UserReceiveBoxPacket;

import common.util.ParamVO;

@Service 
public class ReceiveBoxServiceImpl implements ReceiveBoxService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserReceiveBoxDAO") 
	private UserReceiveBoxDAO userReceiveBoxDAO; 

	@Override
	public UserReceiveBoxPacket selectReceiveBox(int job_code, int user_account) throws Exception {
		
		UserReceiveBoxPacket userReceiveBoxPacket = new UserReceiveBoxPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(job_code); 
		vo.setInParam02(user_account); 
		
		List<UserReceiveBox> userReceiveBoxList = userReceiveBoxDAO.selectReceiveBox(vo);
		
		userReceiveBoxPacket.userReceiveBoxList = userReceiveBoxList;
		userReceiveBoxPacket.setHeader(user_account, resultCd, resultMsg);
		
		return userReceiveBoxPacket;
	}
	
	/* Management ReceiveBox */
	@Override
	public ResultPacket mgmtReceiveBox(  int job_code
										,int user_account
										,int receive_sn
										,int sender_account
										,int rwd_type
										,int rwd_id
										,int rwd_sub_id
										,String receive_msg) throws Exception {
		
		ResultPacket resultPacket = new ResultPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(job_code); 
		vo.setInParam02(user_account); 
		vo.setInParam03(receive_sn);
		vo.setInParam04(sender_account);
		vo.setInParam05(rwd_type);
		vo.setInParam06(rwd_id);
		vo.setInParam07(rwd_sub_id);
		vo.setInStrParam01(receive_msg);
		
		userReceiveBoxDAO.mgmtReceiveBox(vo);
		
		resultCd = vo.getOutParam01();
		resultMsg = vo.getOutStrParam01();
		
		resultPacket.setHeader(user_account, resultCd, resultMsg);
		
		
		return resultPacket;
	}
}