package common.util;

import lombok.Getter;

@Getter
public enum FriendMgmtType {

	REQUEST_FRIEND(1,"Request Friend"),
	ACCEPT_FRIEND(2,"Accept Friend"),
	REJECT_FRIEND(3,"Reject Friend"),
	CANCEL_FRIEND_REQUEST(4,"Cancel Friend Request"),
	DELETE_FRIEND(5,"Delete Friend");
		
	private final int code;
	private final String value;

	 private FriendMgmtType(int code, String value) {
		 this.code = code;
		 this.value = value;
	 }
}