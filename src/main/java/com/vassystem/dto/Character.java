package com.vassystem.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
	public int char_id;	
	public String char_nm;	
	public int char_type;	
	public int char_max_lv;
	public int char_lv;
	public String char_desc;
	public int del_flag;
	public Date del_dt;
	public String char_shape_info;
}