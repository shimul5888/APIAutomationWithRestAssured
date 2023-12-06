package com.izaan.api;

import base.Base;
import base.BaseAssertion;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class GetTollListByCollectionPoint {
    public static Response getTollListByConnectionPoint(){
        String token="Bearer "+ GetToken.getToken();
        String url= URL.getEndPoint("/toll-collection-list");


        String key="collectionPointId";
        String value="NY088734";

        Response re= Base.GETRequest(url,token,key,value);
        return re;
    }

}
