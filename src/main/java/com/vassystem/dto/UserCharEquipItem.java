package com.vassystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCharEquipItem extends Item {
	public int item_uniqueID;
	public int user_account;
	public int char_id;
	public int user_char_sn;
	public String equip_yn;
}