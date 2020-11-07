package com.automationintesting.integration;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class firstIntegrationTest {
    String url = "http://localhost:3002/branding/";

    @Test
    public void sampleGetTest() {
        Response response = RestAssured.get(url);
        Assert.assertEquals(response.getStatusCode(), 200, "Response code mismatch");
    }

    @Test
    public void assertBodyData() {
        Response response = RestAssured.get(url);
        Assert.assertEquals(response.jsonPath().get("name"), "Shady Meadows B&B");
        HashMap actualMapObject = new HashMap<>(response.jsonPath().get("map"));
        Assert.assertEquals(actualMapObject.toString(), new HashMap<>(Map.of("latitude", 52.63512, "longitude",1.2733774)).toString());
    }

}
