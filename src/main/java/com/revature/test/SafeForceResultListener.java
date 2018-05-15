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
		try {
			if (result.getThrowable().getLocalizedMessage() != null) {
				System.out.println("Expection: " + result.getThrowable().toString() + " -> "
						+ result.getThrowable().getLocalizedMessage());
			}
		} catch (NullPointerException e) {
			// DoNothing
		}
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "FAILED",
				result.getThrowable().getLocalizedMessage(), false, startofTest, endofTest);
		try {
			DAOImpl.create(sendit);
		} catch (Exception e) {
			System.out.println("Sending the Test Results to DB has failed" + e.getLocalizedMessage());
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Timestamp endofTest = new Timestamp(System.currentTimeMillis());
		Timestamp startofTest = new Timestamp(result.getStartMillis());
		System.out.println("Start Time of Test " + startofTest.toString());
		System.out.println("End Time of Test " + endofTest.toString());
		String possibleErrorMessage = "No Comment Provided";
		try {
			if (result.getThrowable().getLocalizedMessage() != null) {
				possibleErrorMessage = "Expection: " + result.getThrowable().toString() + " -> "
						+ result.getThrowable().getLocalizedMessage();
				System.out.println(possibleErrorMessage);
			}
				
		} catch (NullPointerException e) {
			// DoNothing
		}
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "PASSED",
				possibleErrorMessage, false, startofTest, endofTest);
		try {
			DAOImpl.create(sendit);
		} catch (Exception e) {
			System.out.println("Sending the Test Results to DB has failed" + e.getLocalizedMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Timestamp endofTest = new Timestamp(System.currentTimeMillis());
		Timestamp startofTest = new Timestamp(result.getStartMillis());
		System.out.println("Start Time of Test " + startofTest.toString());
		System.out.println("End Time of Test " + endofTest.toString());
		try {
			if (result.getThrowable().getLocalizedMessage() != null) {
				System.out.println("Expection: " + result.getThrowable().toString() + " -> "
						+ result.getThrowable().getLocalizedMessage());
			}
		} catch (NullPointerException e) {
			// DoNothing
		}
		UpdatedTest sendit = new UpdatedTest(-12L, result.getName(), "SKIPPED",
				result.getThrowable().getLocalizedMessage(), false, startofTest, endofTest);
		try {
			DAOImpl.create(sendit);
		} catch (Exception e) {
			System.out.println("Sending the Test Results to DB has failed" + e.getLocalizedMessage());
		}
	}
}
