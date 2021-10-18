package com.vassystem.packet;

import java.util.List;

import com.vassystem.dto.Cash;

public class CashPacket extends HeaderPacket {
	
	public String sid;
	public List<Cash> cashList;	
}