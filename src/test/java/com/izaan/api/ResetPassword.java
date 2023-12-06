package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class ResetPassword {
    public static Response resetPasswordRequest() {
        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-admin-set-user-password");
        String body = Base.generatePayLoadString("ResetPassword.json");
        Response response = Base.POSTRequest(url, body, bearerToken);

        return response;
    }
    public static Response resetPasswordNegative(){
        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-admin-set-user-password");
        String body = Base.generatePayLoadString("ResetPasswordNegative.json");
        Response response = Base.POSTRequest(url, body, bearerToken);
        return response;
    }
}
