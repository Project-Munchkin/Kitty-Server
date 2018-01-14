package com.munchkin.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DatabaseTestDao {

	String getDual() throws Exception;
}
