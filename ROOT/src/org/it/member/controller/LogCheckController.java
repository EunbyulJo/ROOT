package org.it.member.controller;

import javax.servlet.http.HttpSession;

import org.it.member.model.LoginCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogCheckController {
	
	@Autowired
	LoginCheckService lcs;
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/mem/log.it", method=RequestMethod.POST)
	public ModelAndView controll(String id, String pass) {
		boolean result = lcs.service(id, pass, session);
		if(result) {
			return new ModelAndView("redirect:/index.it");
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg", "아이디 또는 비밀번호 오류입니다.");
			mav.addObject("location", "/index.it");
			mav.setViewName("log/alert");
			return mav;
		}
	}
	
	@RequestMapping(value="/mem/logout.it", method=RequestMethod.GET)
	public ModelAndView logoutControll() {
		ModelAndView mav = new ModelAndView("redirect:/index.it");
		session.invalidate();
		return mav;
	}
}
