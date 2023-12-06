package com.izaan.apitest;

import base.BaseAssertion;
import com.izaan.api.GetUserList;
import com.izaan.api.SubmitTollRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.ReportManager;

public class GetUserListTest {
    @Test
    public void getUserListTest() {

        Response re = GetUserList.getUserList();

        BaseAssertion.verifyStatusCode(re, 200);
        BaseAssertion.verifySpecificMessage(re, "message", "User List!");
    }
}
