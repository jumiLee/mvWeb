package common.util;

import lombok.Getter;

@Getter
public enum YesOrNoType {

	Y(0,"yes"),
	N(-1,"No");
	
	
	private final int code;
	private final String value;

	 private YesOrNoType(int code, String value) {
		 this.code = code;
		 this.value = value;
	 }
}
