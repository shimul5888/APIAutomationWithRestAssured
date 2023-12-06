package base;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utility.TestUtils;

public class BaseAssertion {
    private static Logger log = LogManager.getLogger(TestUtils.class.getName());



    public static void verifyTrue(boolean flag){
        Assert.assertTrue(flag);
    }

    public static void verifyFalse(boolean flag){
        Assert.assertFalse(flag);
    }

    public static void verifyStatusCode(Response response,int status){
        Assert.assertEquals(TestUtils.getStatusCode(response), status);
        log.info("Status Code is returned as expected.");
    }

    public static void verifyStatusMessage(Response response, String status, String number){
        Assert.assertEquals(TestUtils.getStatusMessage(response), status);
    }

    public static void verifySpecificMessage(Response response, String key, String expectedMessage){
        Assert.assertEquals(TestUtils.getMessage(response, key), expectedMessage);
        log.info("Both texts are same");
    }

    public static void verifyResponseBody(Response response, String responseBody){
        Assert.assertEquals(TestUtils.getStatusMessage(response), responseBody);
    }
    public static void verifyResonseBodyByJsonPath(Response response, String jsonPath, String expectedKeyValue){
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        String actualKeyValue  = jsonPathEvaluator.get(jsonPath);

        // Let us print the city variable to see what we got
        log.info("Actual Key Value received from Response:  " + actualKeyValue);

        // Validate the response
        Assert.assertEquals(actualKeyValue, expectedKeyValue, "Correct value received in the Response");

        log.info("Response Assertion Successful");

    }
    public static void verifyResponseHeader(Response response, String headerKey, String headerValue){

        log.info(response.header(headerKey).toString());

        Assert.assertEquals(response.header(headerKey).matches(headerValue), true);

        log.info("Header "+ headerKey + " = " + headerValue +" available");
    }

}
