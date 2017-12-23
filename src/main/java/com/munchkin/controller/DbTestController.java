package com.munchkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.munchkin.service.DbTestService;

@RestController
public class DbTestController {
	@Autowired
	DbTestService dbService;

	@RequestMapping("/")
	public @ResponseBody String root_test() throws Exception{  
		return "Hello World";
	}
 
	@RequestMapping("/now")
	public @ResponseBody String now() throws Exception{
		return dbService.getDual();
	}

}