package com.vassystem.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReceiveBox {
	public int user_account;
	public int receive_sn;
	public int sender_account;
	public int rwd_type;
	public int rwd_id;
	public int rwd_sub_id;
	public Date issue_dt;
	public String receive_msg;
	public Date check_dt;
	public String check_flag;
	public String sender_nickname;
	public String rwd_nm;
}