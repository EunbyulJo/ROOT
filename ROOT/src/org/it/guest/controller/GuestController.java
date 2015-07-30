package org.it.guest.controller;

import java.util.List;

import org.it.guest.model.GuestDto;
import org.it.guest.model.ReadService;
import org.it.guest.model.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {

	@Autowired
	ReadService read;
	@Autowired
	RegisterService reg;
	
	@RequestMapping(value="/guest/write.it", method=RequestMethod.GET)
	public String controll() {
		return "guest.list.tiles";
	}
	
	@RequestMapping(value="/guest/write.it", method=RequestMethod.POST)
	public String controll2(GuestDto dto) {
		int r = reg.service(dto);
		System.out.println("r = "+r);
		return "redirect:/guest/write.it";
	}
	
	@RequestMapping("/guest/latest.it")
	public ModelAndView controll3() {
		System.out.println("/guest/latest.it");
		ModelAndView mav = new ModelAndView("data");
		List<GuestDto> list = read.service();
		mav.addObject("list", list);
		System.out.println(list.get(0).getWritedate());
		return mav;
	}
	
	@RequestMapping("/guest/guestbook.it")
	public String controll4() {
		return "guestbook";
	}
}
