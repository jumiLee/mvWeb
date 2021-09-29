package com.vassystem.dao;

import org.springframework.stereotype.Repository;

import com.vassystem.dto.Member;

import common.dao.AbstractDAO;
import common.util.ParamVO;


@Repository("MemberDAO")
public class MemberDAO extends AbstractDAO {

	public Member selectMember(ParamVO paramVO) throws Exception{ 
		return (Member) selectOne("member.selectMember", paramVO); 
	}
	
	public Member registerMember(ParamVO paramVO) throws Exception{ 
		return (Member) selectOne("member.registerMember", paramVO); 
	}
}