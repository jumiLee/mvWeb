package common.util;

import lombok.Getter;

@Getter
public enum NewType {

	MESSAGE(1,"Message"),
	INVENTORY(2,"inventory"),
	ACHIEVEMENT(3,"Achievement"),
	FRIEND(4,"New Friend");
		
	private final int code;
	private final String value;

	 private NewType(int code, String value) {
		 this.code = code;
		 this.value = value;
	 }
}