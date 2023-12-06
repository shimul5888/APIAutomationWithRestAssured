package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class LoginRequest {
    public static Response loginRequest()  {
        String url= URL.getEndPoint("/cognito-login");
        String body= Base.generatePayLoadString("Login.json");
        String bearerToken = "Bearer " + GetToken.getToken();

        Response re=Base.POSTRequest(url,body,bearerToken);
        return re;
    }
    public static Response loginRequestNegative()  {
        String url= URL.getEndPoint("/cognito-login");
        String body= Base.generatePayLoadString("LoginRequestNegativeTest.json");
        String bearerToken = "Bearer " + GetToken.getToken();

        Response re=Base.POSTRequest(url,body,bearerToken);
        return re;
    }
}
