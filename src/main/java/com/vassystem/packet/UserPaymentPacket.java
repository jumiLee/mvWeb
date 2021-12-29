package com.vassystem.packet;

import com.vassystem.dto.UserPayment;

public class UserPaymentPacket extends HeaderPacket {
	
	public String sid;
	public UserPayment userPayment;	
}