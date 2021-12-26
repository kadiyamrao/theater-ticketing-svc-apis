package com.theater.ticketing.svc.apis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
	
	@RequestMapping("/validate")
	@ResponseBody
	public String greeting()
	{
		return "Good Morning!";
	}
	
}
