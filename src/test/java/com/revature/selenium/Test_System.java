package com.revature.selenium;

import com.revature.db.DatabaseSingletonDao;
import com.revature.db.DatabaseSingletonDaoImpl;
import com.revature.model.Test;

public class Test_System {
    public static void main(String[] args) {
        DatabaseSingletonDao dao = DatabaseSingletonDaoImpl.getInstance();
    }
}