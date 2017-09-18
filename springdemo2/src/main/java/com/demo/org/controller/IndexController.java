package com.demo.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping()
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/str")
	public String getStr() {
		return "str";
	}
	
	@RequestMapping("/testval")
	public String testParam(@RequestParam("name")String name,String value,ModelMap result) {
		
		result.addAttribute("name",name);
		result.addAttribute("value",value);
		return "showValue";
	}
	
	@RequestMapping("/exception")
	public String exceptionTest() throws Exception{
		throw new Exception("exception test");
	}
	
	
}
