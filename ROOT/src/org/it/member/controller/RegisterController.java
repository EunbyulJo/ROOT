package org.it.member.controller;

import org.it.member.model.MemberDto;
import org.it.member.model.MemberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

	@Autowired
	MemberRegisterService mrs;
	
	@RequestMapping(value="/member/reg.it", method=RequestMethod.GET)
	public String register() {
		return "member.register.tiles";
	}
	
	@RequestMapping(value="/member/reg.it", method=RequestMethod.POST)
	public ModelAndView register2(MemberDto dto) {
		ModelAndView mav = new ModelAndView("member.regResult.tiles");
		boolean b = false;
		try {
			b = mrs.service(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("result", b);
		return mav;
	}
}
