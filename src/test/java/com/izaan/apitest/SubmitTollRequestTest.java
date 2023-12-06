package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.CreateUserRequest;
import com.izaan.api.SubmitTollRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.ReportManager;

public class SubmitTollRequestTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;
    @Test
    public void submitTollTest(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Creation Test");
        Response re= SubmitTollRequest.submitToll();

        BaseAssertion.verifyStatusCode(re,200);
        BaseAssertion.verifySpecificMessage(re,"message","success");
        extent.flush();
    }
    public void submitToll(){

        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Creation Test");

        Response response = CreateUserRequest.createUserAPINegativeTesting();

        BaseAssertion.verifyStatusCode(response, 200);

        BaseAssertion.verifySpecificMessage(response, "statusCode", "400");

        BaseAssertion.verifySpecificMessage(response, "message", "User account already exists");

        extent.flush();
    }
}
