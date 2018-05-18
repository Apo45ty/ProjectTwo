package com.revature.test;

//main
import java.sql.Timestamp;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

import com.revature.db.UpdatedDBSingletonDAO;
import com.revature.db.UpdatedDBSingletonDAOImpl;
import com.revature.model.UpdatedTest;

@Listeners(SafeForceResultListener.class)

public class SafeForceResultListener extends TestListenerAdapter {
	private static UpdatedDBSingletonDAO DAOImpl = UpdatedDBSingletonDAOImpl.getInstance();

	@Override
	public void onTestFailure(ITestResult result) {
		Timestamp endofTest = new Timestamp(System.currentTimeMillis());
		Timestamp startofTest = new Timestamp(result.getStartMillis());
		System.out.println("Start Time of Test " + startofTest.toString());
		System.out.println("End Time of Test " + endofTest.toString());
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "FAILED", false, startofTest, endofTest);
		DAOImpl.create(sendit);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Timestamp endofTest = new Timestamp(System.currentTimeMillis());
		Timestamp startofTest = new Timestamp(result.getStartMillis());
		System.out.println("Start Time of Test " + startofTest.toString());
		System.out.println("End Time of Test " + endofTest.toString());
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "PASSED", false, startofTest, endofTest);
		DAOImpl.create(sendit);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Timestamp endofTest = new Timestamp(System.currentTimeMillis());
		Timestamp startofTest = new Timestamp(result.getStartMillis());
		System.out.println("Start Time of Test " + startofTest.toString());
		System.out.println("End Time of Test " + endofTest.toString());
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "SKIPPED", false, startofTest, endofTest);
		DAOImpl.create(sendit);
	}
}
