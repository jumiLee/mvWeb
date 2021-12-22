package com.vassystem.repository;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class CharacterCompIds implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int user_account;
	private int char_id;
	private int user_char_sn;
	private int map_type;

	public CharacterCompIds(int user_account, int char_id, int user_char_sn, int map_type) {
		super();
		this.user_account = user_account;
		this.char_id = char_id;
		this.user_char_sn = user_char_sn;
		this.map_type = map_type;
	}
}