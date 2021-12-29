package com.vassystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attend {
	public int attend_type;	
	public int day_no;	
	public int rwd_type; 
	public String rwd_nm;
	public int rwd_id;
	public int rwd_sub_id;
}