package com.vassystem.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	public int item_id;
	public String item_nm;
	public int item_category;
	public int item_type;
	public int item_price;
	public int unit_cd;
	public String item_desc;
	public int item_value;
	public int item_cnt;
	public int rare_degree;
	public String item_period_flag;
	public int item_period;
	public String item_dup_flag;
	public String item_new_flag;
	public int item_order;
	public int item_img_no;
	public String item_equip_flag;
	public int item_grade;
	public String use_flag;
	public Date create_dt;
	public Date del_dt;
}