package com.izaan.apitest;

import base.BaseAssertion;
import com.izaan.api.GetTollListByCollectionPoint;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetTollListByCollectionPointTest {
    @Test
    public void getTollListByCollectionPointTest(){



        Response re= GetTollListByCollectionPoint.getTollListByConnectionPoint();

        BaseAssertion.verifySpecificMessage(re,"message","success");
        BaseAssertion.verifySpecificMessage(re,"statusCode","200");
    }
}
