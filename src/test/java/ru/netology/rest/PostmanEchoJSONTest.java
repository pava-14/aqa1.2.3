package ru.netology.rest;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostmanEchoJSONTest {
/*
JSONObject updateData = new JSONObject();
        updateData.put("name", "Aarna");

 */
    @Test
    public void shouldReturnPostmanEcho() {
        // Given - When - Then
        // Предусловия
        ValidatableResponse some_data = given()
                .baseUri("https://postman-echo.com")
                .body("{\n" +
                        "  \"id\":\"10\", \n" +
                        "  \"name\":\"John\", \n" +
                        "  \"job\":\"QA Engineer\",\n" +
                        "  \"location\":\"Office\"\n" +
                        "}\n") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
//                .body("json", equalTo(null))
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
                .body("url", equalTo("https://postman-echo.com/post"))
                ;
    }
}
