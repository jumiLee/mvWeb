package com.vassystem.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	public int account;	
	public String email;	
	public String pwd; 
	public String nickname;
	public Date reg_dt;
	public Date login_dt;
	public String sid;
	public int ch_type;
	public String ch_id;
	public int user_level;
	public String user_img;
	public String user_mobile;
}