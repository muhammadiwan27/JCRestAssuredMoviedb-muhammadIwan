package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class TestMovieRating {

    @Test
    public void testPostMovieRating() {
    RestAssured.baseURI ="https://api.themoviedb.org/3/movie/";
    String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMTdmYzhjZmUzZTdiZGQ2Yzc3MzljNDZhMTg1OTA3ZCIsInN1YiI6IjY0ODFlNzI1ZTM3NWMwMDBhY2M0MGJhMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.nZ7_BX9lDsr3RHd6FcvCGvLdjx-Uq2Q5eNRU7ckwbRA";
    int movieId = 502356;
    double ratingValue = 8.5;
    String requestBody = "{\"value\": " + ratingValue + "}";
    Response response = given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + apiKey)
            .body(requestBody)
            .post("/" + movieId + "/rating");

    int statusCode = response.getStatusCode();
        System.out.println("Status Code: "+statusCode);

    String responseMessage = response.getBody().asString();
        System.out.println("Response Message: "+responseMessage);
}
}
