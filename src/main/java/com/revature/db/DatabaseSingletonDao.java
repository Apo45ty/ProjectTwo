package com.revature.db;

import java.util.List;

import com.revature.model.Test;
import com.revature.model.TestModel;
import com.revature.model.TestSystem;
import com.revature.model.TestType;

public interface DatabaseSingletonDao {
	boolean create(Test t);

	boolean createSys(TestSystem sys);

	Test read(long id);

	TestType readTT(long id);

	TestSystem readS(long id);

	boolean update(Test t);

	boolean delete(Test t);

	List<Test> getAllTest(int page);

	List<TestSystem> getAllSystem(int page);

	List<TestModel> getAllModel(int page);

	List<TestType> getAllTestType(int page);
}
