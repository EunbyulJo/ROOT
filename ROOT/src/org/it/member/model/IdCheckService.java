package org.it.member.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdCheckService {

	@Autowired
	MemberDao memberDao;
	
	public MemberDto service(String id) {
		return memberDao.readOne(id);
	}
}
