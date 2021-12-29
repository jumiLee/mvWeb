package com.vassystem.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPayment {
	public int user_account;
	public int trade_no;
	public String prod_id;
	public int trade_amt;
	public Date trade_req_dt;
	public String trade_key;
	public int trade_res_cd;
	public String trade_res_mgs;
	public Date trade_res_dt;
	public String trade_res_key;
	public String order_info;
	public int device_type;
	public int payment_type;
	public int ch_type;
	public String ch_id;
	public int req_time_diff; //결제요청부터 현재까 시간 
	public int accept_itval;  //req_time_diff 허용 시간(초)
}