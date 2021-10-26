package com.vassystem.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCharacter extends Character {
	public int user_account;
	public int user_char_sn;	
	public int user_char_lv;
	public int user_char_exp;
	public String carry_flag;
	//public String char_cust_info;
	public CharacterCustInfo char_cust_info;
	public List<UserCharEquipItem> char_equip_items; //현재 장착 아이템 정보 
	public Date create_dt;
	public Date last_mod_dt;
}