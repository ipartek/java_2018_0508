package com.ipartek.formacion.gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)

	//Spring usa un ViewResolver y se encarga de manda la vista correstondiente
	public String home() {
		return "index";
	}
}
