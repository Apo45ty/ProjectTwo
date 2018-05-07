package com.revature.db;

import com.revature.model.Test;

public interface DatabaseSingletonDao {
	boolean create(Test t);

	Test read(long id);

	boolean update(Test t);

	boolean delete(Test t);

	Test[] getAllTest();
}
