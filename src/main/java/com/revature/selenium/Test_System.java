package com.revature.selenium;

import java.io.File;
import java.util.Properties;
import java.util.Set;

import com.revature.db.DatabaseSingletonDao;
import com.revature.db.DatabaseSingletonDaoImpl;
import com.revature.model.TestSystem;

public class Test_System {
    public static void main(String[] args) {
		DatabaseSingletonDao dao = DatabaseSingletonDaoImpl.getInstance();
		
		//Get the required system information
		long maxMemory = Runtime.getRuntime().maxMemory();
        String OS = System.getProperty("os.name");
		String cpu = System.getenv("PROCESSOR_IDENTIFIER");
        File[] roots = File.listRoots();

		TestSystem sys = new TestSystem(0, cpu, OS, (maxMemory + " bytes"), (roots[0].getTotalSpace() + " bytes"));
		dao.createSys(sys);
    }
}