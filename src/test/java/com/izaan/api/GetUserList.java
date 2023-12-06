package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class GetUserList {
    public static Response getUserList(){
        String bearerToken="Bearer "+GetToken.getToken();

        String url= URL.getEndPoint("/cognito-user-list");

        Response response= Base.GETRequest(url,bearerToken);

        return response;


    }

}
