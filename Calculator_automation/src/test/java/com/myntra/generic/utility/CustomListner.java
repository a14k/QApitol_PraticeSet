package com.myntra.generic.utility;

import com.myntra.baseClass.baseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

class CustomListener extends baseClass implements ITestListener {

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
        utility.captureScreenShot(driver,result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        utility.captureScreenShot(driver,result.getMethod().getMethodName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

}