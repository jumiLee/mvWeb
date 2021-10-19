package com.vassystem.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vassystem.dao.UserPaymentDAO;
import com.vassystem.dto.UserPayment;
import com.vassystem.packet.ResultPacket;
import com.vassystem.packet.ResultPaymentPacket;

import common.util.ParamVO;

@Service 
public class UserPaymentServiceImpl implements UserPaymentService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserPaymentDAO") 
	private UserPaymentDAO userPaymentDAO; 
	
	@Autowired 
	private CashService cashService;

	/* RequestPayment
	 * cash_id : 구매하는 상품 id
	 * payment_type : 결제사 타입
	 * device_type : 단말기 타
	 */
	@Override
	public ResultPaymentPacket requestPayment(int user_account, int cash_id, int device_type, int payment_type) throws Exception {
		
		ResultPaymentPacket resultPaymentPacket = new ResultPaymentPacket();
		int resultCd = 0;
		String resultMsg = "";
		int trade_no =0;
		String server_key = "";
		String encryptKey = "";
		String app_id = "";
		
	// 1. 결제요청 
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(user_account); 
		vo.setInParam02(cash_id); 
		vo.setInParam03(device_type);
		vo.setInParam04(payment_type);
		
		userPaymentDAO.requestPayment(vo);
		
		resultCd 	= vo.getOutParam01();
		resultMsg 	= vo.getOutStrParam01();
		trade_no 	= vo.getOutParam02();
		server_key 	= vo.getOutStrParam02();
		app_id 		= vo.getOutStrParam03();
			
	// 2. trade_key 생성 및 업데이트 
		if(resultCd == 0) {
			encryptKey = encryptServerKey(server_key,trade_no);
			
			ParamVO vo2 = new ParamVO(); 
			vo2.setInParam01(2); 
			vo2.setInParam02(user_account); 
			vo2.setInParam03(trade_no);
			vo2.setInStrParam01(null);
			vo2.setInStrParam02(encryptKey);
			vo2.setInParam04(0);
			vo2.setInStrParam03(null);
			vo2.setInStrParam04(null);
			
			userPaymentDAO.updatePayment(vo2);
		}
		
		resultPaymentPacket.setHeader(user_account, resultCd, resultMsg);
		resultPaymentPacket.encryptKey = encryptKey;
		resultPaymentPacket.tradeNo   = trade_no;	
		resultPaymentPacket.appId 	  = app_id;
			
		return resultPaymentPacket;
	}
	
	@Override
	public ResultPacket updatePayment(int user_account, int cash_id, int trade_no, String order_no, int trade_res_cd, String trade_res_msg, String trade_res_key) throws Exception {
		ResultPacket resultPacket = new ResultPacket();
		int resultCd = 0;
		String resultMsg = "";
		
		UserPayment userPayment = getUserPayment(user_account, trade_no);
		
		//요청 값과 결과 업데이트 값을 비교하여 검증 
		if(!trade_res_key.equals(userPayment.trade_key)) {
			resultCd = -21;
			resultMsg = "Security Key Invalid";
		}
		//송수신 시간 체크 
		if(userPayment.req_time_diff > userPayment.accept_itval) {
			resultCd = -22;
			resultMsg = "Timeout";
		}
		
		//결제검증 문제 없으면, 결제결과 업데이트 
		if(resultCd == 0) {
			ParamVO vo = new ParamVO(); 
			vo.setInParam01(1); 
			vo.setInParam02(user_account); 
			vo.setInParam03(trade_no);
			vo.setInStrParam01(order_no);
			vo.setInStrParam02(null);
			vo.setInParam04(trade_res_cd);
			vo.setInStrParam03(trade_res_msg);
			vo.setInStrParam04(trade_res_key);
			
			userPaymentDAO.updatePayment(vo);
			
			resultCd 	= vo.getOutParam01();
			resultMsg 	= vo.getOutStrParam01();
		}
		
		//캐시 충전
		if(resultCd == 0) {
			resultCd = cashService.mgmtCash(1, user_account, 0, cash_id, userPayment.payment_type);
		}
		
		resultPacket.setHeader(user_account, resultCd, resultMsg);
		
		return resultPacket;
	}

	@Override
	public UserPayment getUserPayment(int user_account, int trade_no) throws Exception {
		
		ParamVO vo = new ParamVO(); 
		vo.setInParam01(user_account); 
		vo.setInParam02(trade_no); 
		
		return userPaymentDAO.selectUserPayment(vo);
	}
	
	private String encryptServerKey(String serverKey, int trade_no) {
		//암호화 정해지면 구현 
		String strData = Integer.toString(trade_no).concat(serverKey);
		
		return strData;
		
	}
}