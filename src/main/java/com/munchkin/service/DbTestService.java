package com.munchkin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.munchkin.dao.DbTestMapper;



@Service
public class DbTestService {
	@Autowired
	DbTestMapper dbMapper;

	/* select dual */
	public String getDual() throws Exception{
		return dbMapper.getDual();
	}

}
