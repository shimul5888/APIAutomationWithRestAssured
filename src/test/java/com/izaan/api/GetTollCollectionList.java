package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class GetTollCollectionList {
    public static Response getTollCollectionList(){
        String bearerToken="Bearer "+ GetToken.getToken();

        String url= URL.getEndPoint("/toll-collection-list");

        Response response= Base.GETRequest(url,bearerToken);

        return response;
    }
}

