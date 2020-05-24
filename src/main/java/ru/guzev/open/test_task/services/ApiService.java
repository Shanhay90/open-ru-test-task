package ru.guzev.open.test_task.services;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    private ApiService() {
    }

    @Step
    public static ValidatableResponse sendGetRequest(RequestSpecification requestSpecification, int statusCode) {

        return RestAssured.given()
                .log().all()
                .spec(requestSpecification)
                .get()
                .then()
                .log().all()
                .statusCode(statusCode);
    }

    @Step
    public static ValidatableResponse sendPostRequest(RequestSpecification requestSpecification, int statusCode) {
        return RestAssured.given()
                .log().all()
                .spec(requestSpecification)
                .post()
                .then()
                .log().all()
                .statusCode(statusCode);
    }
}
