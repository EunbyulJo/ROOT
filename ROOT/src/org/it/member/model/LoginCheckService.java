package org.it.member.model;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginCheckService {

	@Autowired
	MemberLogDao logDao;
	@Autowired
	MemberDao dao;
	
	// 로그인 로직
	public boolean service(String id, String pass, HttpSession session) {
		boolean result = false;
		MemberDto dto = dao.readOne(id);
		System.out.println("dto=null? "+(dto==null));
		if(dto!=null && dto.getPass().equals(pass)) {
			System.out.println("??");
			int pointRst = logDao.updatePoint(id);
			int logRst = logDao.updateLog(id);
			System.out.println("pointRst : "+pointRst+"/"+"logRst : "+logRst);
			session.setAttribute("log", dto);
			result = true;
		}
		return result;
	}
}
