package com.munchkin.service;


import com.munchkin.dao.DatabaseTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatabaseTestService {

    @Autowired
    private DatabaseTestDao databaseTestDao;

    /* select dual */
    public String getDual() throws Exception {
        return databaseTestDao.getDual();
    }
}
