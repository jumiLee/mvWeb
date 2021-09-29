package com.vassystem.service;

import java.util.List;
import com.vassystem.dto.UserAttend;

public interface UserAttendService {
	
	/*select Member */
	List<UserAttend> selectUserAttendList(int user_account) throws Exception;

	/* session check */
	int checkSession(int user_account, String sid);
}