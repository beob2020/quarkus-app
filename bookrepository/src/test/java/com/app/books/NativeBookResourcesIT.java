package com.app.books;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledInNativeImage;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;

@EnabledInNativeImage
public class NativeBookResourcesIT extends BookResourceTest{

    @Test
    void shouldGetBookWithProdGenre() {
        given().header(ACCEPT, APPLICATION_JSON)
                .pathParams("id", 1)
                .when()
                .get("/api/books/{id}")
                .then()
                .statusCode(OK.getStatusCode())
                .body("title", is("Java made simple"))
                .body("author", is("Benard"))
                .body("genre", is("Programming"))
                .body("yearOfPublication", hasValue(2021));
    }

}

