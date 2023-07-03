package com.app.books;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldGetAllBooks() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .when()
                .get("/api/books")
                .then()
                .statusCode(OK.getStatusCode())
                .body("size()", is(4));
    }
    @Test
    void shouldCountAllBooks() {
        given().header(ACCEPT, TEXT_PLAIN)
                .when()
                .get("/api/books/count")
                .then()
                .statusCode(OK.getStatusCode())
                .body(is("4"));
    }
    @Test
    void shouldGetBook() {
        given().header(ACCEPT, APPLICATION_JSON)
                .pathParams("id", 1)
                .when()
                .get("/api/books/{id}")
                .then()
                .statusCode(OK.getStatusCode())
                .body("title", is("Java made simple"))
                .body("author", is("Benard"))
                .body("genre", is("IT"))
                .body("yearOfPublication", hasValue(2021));
    }
}