package com.crm.Vtiger.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ITestListenerImplementation extends BaseClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		test=report.createTest(testName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name=result.getName();
		test.log(Status.PASS,name+ " test script successfull");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		test.log(Status.FAIL, "test script failed");
		JavaUtility j=new JavaUtility();
		TakesScreenshot t= (TakesScreenshot) d;
		String dt = j.getDateAndTime("dd-MM-yyyy hh-mm-ss");
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+name+dt+".png");
		try {
			Files.copy(src, dest);
			test.addScreenCaptureFromPath(dest.getAbsolutePath(),name+" failed screenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test.log(Status.FAIL, name+" test script failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		test.log(Status.SKIP, name+" test script sikpped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		String name = context.getName();
		JavaUtility j=new JavaUtility();
		String DT = j.getDateAndTime("dd-MM-yyyy hh-mm-ss");
		ExtentSparkReporter reporter =new ExtentSparkReporter("./ExtentReports/"+name+DT+".html");
		reporter.config().setDocumentTitle("VTiger Organization reports");
		reporter.config().setReportName("Reports of Organization");
		reporter.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("url", "http://localhost:8888");
		report.setSystemInfo("OS", "window");
		report.setSystemInfo("broswer", "chrome");
		report.setSystemInfo("TestEngineer", "jeevan");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
