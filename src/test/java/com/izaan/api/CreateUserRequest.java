package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

import java.io.IOException;

public class CreateUserRequest {
    public static Response createUserAPI()  {
        String url= URL.getEndPoint("/cognito-create-user");
        String body= Base.generatePayLoadString("CreateUser.json");
        String bearerToken = "Bearer " + GetToken.getToken();

        Response re=Base.POSTRequest(url,body,bearerToken);
        return re;
    }
    public static Response createUserAPINegativeTesting(){


        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-create-user");

        String requestBody = Base.generatePayLoadString("CreateUserNegativeTest.json");

        Response responseBody = Base.POSTRequest(url, requestBody, bearerToken);

        return responseBody;

    }
}
