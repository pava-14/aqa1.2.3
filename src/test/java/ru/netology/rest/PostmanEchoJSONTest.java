package ru.netology.rest;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoJSONTest {

    @Test
    public void shouldReturnPostmanEcho() {
        JSONObject jsonObj = new JSONObject()
                .put("id", 10)
                .put("name", "John")
                .put("location", "Office");
        // Given - When - Then
        // Предусловия
        ValidatableResponse some_data = given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(jsonObj.toString()) // отправляемые данные
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
}
