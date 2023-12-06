package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.CreateUserRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.ReportManager;

import java.io.IOException;

public class CreateUserRequestTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;
    @Test

    public void validateUserCreation() {

        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Creation Test");

        Response response = CreateUserRequest.createUserAPI();

        BaseAssertion.verifyStatusCode(response, 200);

        BaseAssertion.verifySpecificMessage(response, "message", "User Created successfully!");

        extent.flush();
    }
    @Test
    public void validateUserCreationWithExistingUsername(){

        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Creation Test");

        Response response = CreateUserRequest.createUserAPINegativeTesting();

        BaseAssertion.verifyStatusCode(response, 200);

        BaseAssertion.verifySpecificMessage(response, "statusCode", "400");

        BaseAssertion.verifySpecificMessage(response, "message", "User account already exists");

        extent.flush();

    }

}

