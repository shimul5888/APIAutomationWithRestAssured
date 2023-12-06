package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.CreateUserRequest;
import com.izaan.api.LoginRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.ReportManager;

public class LoginRequestTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;
    @Test

    public void loginRequestTest() {

        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Login");

        Response response = LoginRequest.loginRequest();

        BaseAssertion.verifyStatusCode(response, 200);

        BaseAssertion.verifySpecificMessage(response, "message", "Log in successfully!");

        extent.flush();
    }
    @Test
    public void loginRequestNegativeTest() {

        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Login");

        Response response = LoginRequest.loginRequestNegative();

        BaseAssertion.verifyStatusCode(response, 200);

        BaseAssertion.verifySpecificMessage(response, "message", "Incorrect username or password.");

        extent.flush();
    }
}
