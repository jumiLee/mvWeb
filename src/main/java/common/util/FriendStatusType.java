package common.util;

import lombok.Getter;

@Getter
public enum FriendStatusType {

	FRIEND_COMPLETE(1,"친구상태"),
	FRIEND_REQUEST(2,"친구신청중"),
	FRIEND_REJECT(3,"친구거절"),
	FRIEND_NOTYET(4,"친구신청가능");
	
		
	private final int code;
	private final String value;

	 private FriendStatusType(int code, String value) {
		 this.code = code;
		 this.value = value;
	 }
}