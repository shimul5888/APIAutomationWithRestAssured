package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class SubmitTollRequest {
    public  static Response submitToll(){
        String body= Base.generatePayLoadString("SubmitToll.json");
        String url = URL.getEndPoint("/tollcollection");
        String bearerToken= GetToken.getToken();

        Response re= Base.POSTRequest(url,body,bearerToken);
        return re;
    }
}
