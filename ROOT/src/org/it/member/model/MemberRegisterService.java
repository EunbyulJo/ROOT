package org.it.member.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
@Component
// 필요한 정보를 controller 로부터 넘겨받아서
public class MemberRegisterService {

	@Autowired
	MemberDao memberDao;
	@Autowired
	MemberLogDao memberLogDao;
	@Autowired
	MemberLogDto	logDto;
	
	public boolean service(MemberDto dto) throws Exception {
		boolean b = false;
		int r1 = memberDao.insertOne(dto);
		logDto.setId(dto.getId());
		logDto.setPoint(0);
		int r2 = 0;
		if(Math.random()>0.5) {
				throw new Exception();
		}else {
			r2 = memberLogDao.insertOne(logDto);
		}
		if(r1==1 && r2==1) {b=true;}
//		 트랜잭션..
		return b;
	}
}
