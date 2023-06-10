package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestNowPlaying {

    @Test
        public void testGetNowPlaying() {
        RestAssured.baseURI = "https://api.themoviedb.org/3/movie/now_playing";
        String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMTdmYzhjZmUzZTdiZGQ2Yzc3MzljNDZhMTg1OTA3ZCIsInN1YiI6IjY0ODFlNzI1ZTM3NWMwMDBhY2M0MGJhMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.nZ7_BX9lDsr3RHd6FcvCGvLdjx-Uq2Q5eNRU7ckwbRA";

        Response response = given()
                .queryParam("page", 1)
                .header("Authorization", "Bearer " + apiKey)
                .get();
            Response response1 = given().queryParam("page", 1).get();
            ResponseBody body = response.getBody();
            System.out.println("Response Body is: " + body.asString());
            JsonPath jsonPathEvaluator = response.jsonPath();
            String total_pages = jsonPathEvaluator.getString("total_pages");
            String total_results = jsonPathEvaluator.getString("total_results");
            System.out.println(total_pages);
            System.out.println(total_results);
    }
}
