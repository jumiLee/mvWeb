package com.vassystem.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.vassystem.dto.UserCharacter;
import common.dao.AbstractDAO;

@Repository("CharacterDAO")
public class CharacterDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<UserCharacter> selectCharacterList(int user_account) throws Exception{ 
		return selectList("character.selectUserCharacterList", user_account); 
	}
}