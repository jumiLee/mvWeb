package com.vassystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAttend extends Attend{
	public int rwd_type;
	public int rwd_id;
	public int rwd_sub_id;
	public int rwd_rcv_flag;
	public String rwd_nm;
}