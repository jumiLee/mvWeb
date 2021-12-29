package com.vassystem.repository;


//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapRepository extends CrudRepository<UserMap, CharacterCompIds> {
//public interface UserMapRepository extends JpaRepository<UserMap, CharacterCompIds> {
		
}