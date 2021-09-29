package common.util;

import lombok.Getter;

@Getter
public enum ChannelType {

	GENERAL(0,"general"),
	KAKAO(1,"kakao user"),
	GOOGLE(2,"google user");
		
	private final int code;
	private final String value;

	 private ChannelType(int code, String value) {
		 this.code = code;
		 this.value = value;
	 }
}