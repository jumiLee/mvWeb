package common.util;

import lombok.Getter;

@Getter
public enum AttendType {

	DAILY(1,"daily attendance event");
	
		
	private final int code;
	private final String value;

	 private AttendType(int code, String value) {
		 this.code = code;
		 this.value = value;
	 }
}