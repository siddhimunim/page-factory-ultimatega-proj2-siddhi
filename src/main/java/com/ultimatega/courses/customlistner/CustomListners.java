package com.ultimatega.courses.customlistner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ultimatega.courses.utility.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import static com.ultimatega.courses.utility.Utility.takeScreenShot;

public class CustomListners implements ITestListener {
    public ExtentSparkReporter reporter;
    public ExtentReports reports;
    public static ExtentTest test;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = reports.createTest(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, "TEST CASE PASSED IS " + iTestResult.getName());
        String screenshotPath = takeScreenShot(iTestResult.getName());
        test.addScreenCaptureFromPath(screenshotPath);
        // This step take screenshot and store in to test-output/html folder
        String screenshotName = Utility.takeScreenShot(iTestResult.getName());
        // This line required for ReportNG reports
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("Click to see screenshot");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+"><img src="+screenshotName+" height=200 width=200></img></a>");
    }

  public void onTestFailure(ITestResult iTestResult) {
        test.log(Status.FAIL, "TEST FAILED IS " + iTestResult.getName());
        test.log(Status.FAIL, "TEST FAILED IS " + iTestResult.getThrowable());
        String screenshotPath = takeScreenShot(iTestResult.getName());
        test.addScreenCaptureFromPath(screenshotPath);
      // This step take screenshot and store in to test-output/html folder
      String screenshotName = Utility.takeScreenShot(iTestResult.getName());
      // This line required for ReportNG reports
      System.setProperty("org.uncommons.reportng.escape-output", "false");
      Reporter.log("Click to see screenshot");
      Reporter.log("<a target = \"_blank\" href="+screenshotName+">Screenshot</a>");
      Reporter.log("<br>");
      Reporter.log("<br>");
      Reporter.log("<a target = \"_blank\" href="+screenshotName+"><img src="+screenshotName+" height=200 width=200></img></a>");

    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(Status.SKIP, "TEST SKIPPED IS " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/extent.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("ultimiteqa");
        reporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(reporter);

        reports.setSystemInfo("User Name", System.getProperty("user.name"));
        reports.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        reports.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        reports.setSystemInfo("Selenium", "3.141.59");
        reports.setSystemInfo("Maven", "3.5.9");
        reports.setSystemInfo("Java Version", "1.8.0_151");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        reports.flush();
    }
}

