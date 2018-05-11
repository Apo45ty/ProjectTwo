package com.revature.test;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.revature.db.DatabaseSingletonDaoImpl;
import com.revature.model.Test;
import com.revature.model.TestSystem;
import com.revature.model.TestType;

public class SafeForceResultListener extends TestListenerAdapter {

	 @Override
	    public void onTestFailure(ITestResult result) {
		 	TestSystem thisSiS = new TestSystem(-111,"CPU!!!","OS!!!","RAMMM!!!","DisK Drive Info ALL TEMP");
		 	TestType temp0 = new TestType(-4,result.getInstanceName(),-3,false);
		 	Test sendit = new Test(-5,result.getTestName(),"Failed",false,temp0,thisSiS);
		 	DatabaseSingletonDaoImpl.getInstance().create(sendit);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	     	TestSystem thisSiS = new TestSystem(-111,"CPU!!!","OS!!!","RAMMM!!!","DisK Drive Info ALL TEMP");
		 	TestType temp0 = new TestType(-4,result.getInstanceName(),-3,false);
		 	Test sendit = new Test(-5,result.getTestName(),"PassSSSed",false,temp0,thisSiS);
		 	DatabaseSingletonDaoImpl.getInstance().create(sendit);
	    }

	   @Override
	    public void onTestSkipped(ITestResult result) {
		 	TestSystem thisSiS = new TestSystem(-111,"CPU!!!","OS!!!","RAMMM!!!","DisK Drive Info ALL TEMP");
		 	TestType temp0 = new TestType(-4,result.getInstanceName(),-3,false);
		 	Test sendit = new Test(-5,result.getTestName(),"Skippped",false,temp0,thisSiS);
		 	DatabaseSingletonDaoImpl.getInstance().create(sendit);
	    }
}
