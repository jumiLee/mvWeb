package com.vassystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFriend {
	public int user_account;
	public int frd_account;
	public int frd_status_cd;
	public String frd_nickname;
	public int frd_friend_cnt;
	public int frd_following_cnt;
}