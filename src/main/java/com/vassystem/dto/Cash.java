package com.vassystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cash {
	public int cash_id;
	public String item_nm;
	public int device_type;
	public int payment_type;
	public String prod_id;
	public int cash_type_cd;	//1:$, 2:won
	public int cash_amt;
	public int cash_dis_amt;
	public int coin_amt;
	public String coin_nm;
	public String coin_desc;
	public String del_flag;
	public String display_flag;
	public int prod_img;
}