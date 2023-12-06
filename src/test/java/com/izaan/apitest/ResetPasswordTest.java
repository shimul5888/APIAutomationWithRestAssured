package com.izaan.apitest;

import base.BaseAssertion;
import com.izaan.api.LoginRequest;
import com.izaan.api.ResetPassword;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ResetPasswordTest {
    @Test
    public void restPassword(){
        Response response = ResetPassword.resetPasswordRequest();

        BaseAssertion.verifyStatusCode(response, 200);

        BaseAssertion.verifySpecificMessage(response, "message", "Password set successfully!");
    }

    @Test
    public void resetPasswordNegativeTest(){
        Response response=ResetPassword.resetPasswordNegative();

        BaseAssertion.verifyStatusCode(response,200);

        BaseAssertion.verifySpecificMessage(response,"statusCode","400");

        BaseAssertion.verifySpecificMessage(response,"message","Password does not conform to policy: Password not long enough");


    }
}
