package com.vassystem.service;

import com.vassystem.packet.ResultPacket;
import com.vassystem.packet.UserReceiveBoxPacket;

public interface ReceiveBoxService {
	
	/*select Character List */
	UserReceiveBoxPacket selectReceiveBox(int job_code, int user_account) throws Exception;
	
	/* Management ReceiveBox */
	ResultPacket mgmtReceiveBox( int job_code
								,int user_account
								,int receive_sn
								,int sender_account
								,int rwd_type
								,int rwd_id
								,int rwd_sub_id
								,String receive_msg) throws Exception;
}