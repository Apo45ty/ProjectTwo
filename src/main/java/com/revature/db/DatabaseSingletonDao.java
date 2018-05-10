package com.revature.db;

import com.revature.model.Test;
import com.revature.model.TestType;

import java.util.List;

import com.revature.model.TestSystem;

public interface DatabaseSingletonDao {
	boolean create(Test t);

	boolean createSys(TestSystem sys);

	Test read(long id);
	
	TestType readTT(long id);
	
	System readS(long id);

	boolean update(Test t);

	boolean delete(Test t);

	List<Test> getAllTest();
}
