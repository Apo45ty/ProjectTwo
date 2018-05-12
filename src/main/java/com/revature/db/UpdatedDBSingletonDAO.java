/**
 * 
 */
package com.revature.db;

import java.util.List;

import com.revature.model.UpdatedTest;

/**
 * @author Ed M
 * @date May 12, 2018
 * @time time 9:54:11 AM
 */
public interface UpdatedDBSingletonDAO {
	boolean create(UpdatedTest test);
	UpdatedTest read(long id);
	boolean update(UpdatedTest test);
	boolean delete(UpdatedTest test);
	
	List<UpdatedTest>getAllTest(int page);
	
}
