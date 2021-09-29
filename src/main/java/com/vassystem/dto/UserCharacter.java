package com.vassystem.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCharacter extends Character {
	public int user_account;
	public int user_char_sn;	
	public int user_char_lv;
	public int user_char_exp;
	public String char_cust_info;
	public Date create_dt;
	public Date last_mod_dt;
}