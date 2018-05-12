package com.revature.selenium;

import java.io.File;
import java.util.Properties;
import java.util.Set;

import com.revature.db.DatabaseSingletonDao;
import com.revature.db.DatabaseSingletonDaoImpl;
import com.revature.model.Test;
import com.revature.model.TestSystem;
import com.revature.model.TestType;

public class Test_System {
    public static void main(String[] args) {
		DatabaseSingletonDao dao = DatabaseSingletonDaoImpl.getInstance();
		
		TestSystem thisSiS = new TestSystem(111L,"CPU!!!","OS!!!","RAMMM!!!","DisK Drive Info ALL TEMP");
		 	TestType temp0 = new TestType(4L,"test",3L,false);
			 Test sendit = new Test(5L,"test","Failed",false,dao.readTT(1),dao.readS(1));
			 dao.create(sendit);

		// //Get the required system information
		// long maxMemory = Runtime.getRuntime().maxMemory();
        // String OS = System.getProperty("os.name");
		// String cpu = System.getenv("PROCESSOR_IDENTIFIER");
        // File[] roots = File.listRoots();

		// TestSystem sys = new TestSystem(0, cpu, OS, (maxMemory + " bytes"), (roots[0].getTotalSpace() + " bytes"));
		// dao.createSys(sys);
    }
}