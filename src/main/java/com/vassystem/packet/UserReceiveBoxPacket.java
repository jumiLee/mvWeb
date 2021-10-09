package com.vassystem.packet;

import java.util.List;
import com.vassystem.dto.UserReceiveBox;

public class UserReceiveBoxPacket extends HeaderPacket {
	
	public String sid;
	public List<UserReceiveBox> userReceiveBoxList;	
}