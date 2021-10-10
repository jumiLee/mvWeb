package com.vassystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserItem extends Item {
	public int item_uniqueID;
	public int user_account;
	public int item_id;
	public int item_cnt;
	public String item_usage;
	public int remain_time;
	public String check_flag;
}