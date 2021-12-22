package com.vassystem.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="user_map")
public class UserMap {
	
	@EmbeddedId
	private CharacterCompIds characterCompIds;
	
	@Column(name="map_data")
	private String mapData;
	
	@Column(name="last_mod_dt")
	private LocalDateTime lastModDate = LocalDateTime.now();
	//private ZonedDateTime lastModDate = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

	public UserMap(CharacterCompIds characterCompIds, String mapData) {
		super();
		this.characterCompIds = characterCompIds;
		this.mapData = mapData;
	}
}