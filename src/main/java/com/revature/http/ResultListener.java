/**
 * 
 */
package com.revature.http;

import java.sql.Timestamp;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.revature.db.UpdatedDBSingletonDAO;
import com.revature.db.UpdatedDBSingletonDAOImpl;
import com.revature.model.UpdatedTest;

/**
 * @author Ed M
 * @date May 12, 2018
 * @time time 5:23:54 PM
 */
public class ResultListener implements ITestListener {
	private static UpdatedDBSingletonDAO DAOImpl = UpdatedDBSingletonDAOImpl.getInstance();

	/**
	 * 
	 */
	public ResultListener() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		Timestamp endofTest = new Timestamp(System.currentTimeMillis());
		Timestamp startofTest = new Timestamp(result.getStartMillis());
		System.out.println("Start Time of Test " + startofTest.toString());
		System.out.println("End Time of Test " + endofTest.toString());
		System.out.println(result.getTestContext().toString());
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "PASSED", false, startofTest, endofTest);
		DAOImpl.create(sendit);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		Timestamp endofTest = new Timestamp(System.currentTimeMillis());
		Timestamp startofTest = new Timestamp(result.getStartMillis());
		System.out.println("Start Time of Test " + startofTest.toString());
		System.out.println("End Time of Test " + endofTest.toString());
		System.out.println(result.getTestContext().toString());
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "FAILED", false, startofTest, endofTest);
		DAOImpl.create(sendit);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		Timestamp endofTest = new Timestamp(System.currentTimeMillis());
		Timestamp startofTest = new Timestamp(result.getStartMillis());
		System.out.println("Start Time of Test " + startofTest.toString());
		System.out.println("End Time of Test " + endofTest.toString());
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "SKIPPED", false, startofTest, endofTest);
		DAOImpl.create(sendit);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.
	 * ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
