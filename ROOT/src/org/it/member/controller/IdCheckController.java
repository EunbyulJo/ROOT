package org.it.member.controller;

import org.it.member.model.IdCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IdCheckController {

	@Autowired
	IdCheckService ics;
	
	@RequestMapping("/check.it")
	public ModelAndView check(String id) {
		ModelAndView mav = new ModelAndView("idcheck");
		mav.addObject("result", ics.service(id));
		return mav;
	}
}
