package ru.netology.rest;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    public void shouldReturnPostmanEcho() {
        // Given - When - Then
        // Предусловия
        ValidatableResponse some_data = given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"))
                ;
    }
}
