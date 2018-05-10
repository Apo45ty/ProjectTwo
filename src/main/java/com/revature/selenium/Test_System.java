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
        System.out.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());

		/* This will return Long.MAX_VALUE if there is no preset limit */
		long maxMemory = Runtime.getRuntime().maxMemory();
		/* Maximum amount of memory the JVM will attempt to use */
		System.out.println("Maximum memory (bytes): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));
        System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
        String OS = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String v = System.getProperty("os.version");
        File[] roots = File.listRoots();

		/* For each filesystem root, print some info */
		for (File root : roots) {
			System.out.println("File system root: " + root.getAbsolutePath());
			System.out.println("Total space (bytes): " + root.getTotalSpace());
			System.out.println("Free space (bytes): " + root.getFreeSpace());
			System.out.println("Usable space (bytes): " + root.getUsableSpace());
		} 

		System.out.println();
		System.out.println();
		System.out.println();
		Properties properties = System.getProperties();
        Set<Object> keys = properties.keySet();
        for(Object key : keys){
            System.out.println(key + ": " + properties.get(key));
		}
		
		TestSystem sys = new TestSystem(0, arch, OS, (maxMemory + " bytes"), (roots[0].getTotalSpace() + " bytes"));
    }
}