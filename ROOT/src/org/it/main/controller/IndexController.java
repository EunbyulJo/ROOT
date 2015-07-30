package org.it.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index.it")
	public String index() {
		return "layout.main.tiles";
	}
}
