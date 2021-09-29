package common.util;

import lombok.Getter;

@Getter
public enum ItemMgmtType {

	BUY(1,"buy"),
	USE(2,"use"),
	REWARD(3,"reward"),
	THROWAWAY(4,"throw away"),
	UPDATE(5,"item status update");
		
	private final int code;
	private final String value;

	 private ItemMgmtType(int code, String value) {
		 this.code = code;
		 this.value = value;
	 }
}