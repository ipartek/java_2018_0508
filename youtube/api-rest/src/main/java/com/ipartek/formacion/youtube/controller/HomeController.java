package com.ipartek.formacion.youtube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String home() {
		// Spring usa un InternalResourceViewResolver
		// nombre de vista=> index.jsp
		// @see
		return "index";
	}
}
