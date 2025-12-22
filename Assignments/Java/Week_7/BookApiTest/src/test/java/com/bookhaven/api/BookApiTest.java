package com.bookhaven.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    @Order(1)
    @DisplayName("GET /posts should return 200 and list of posts")
    void testGetAllPosts() {
        given()
                .log().uri()
                .when()
                .get("/posts")
                .then()
                .log().status()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("size()", equalTo(100))
                .body("[0].id", equalTo(1))
                .body("[0].userId", equalTo(1));
    }

    @Test
    @Order(2)
    @DisplayName("GET /posts/1 should return specific post")
    void testGetPostById() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", not(emptyString()))
                .body("body", not(emptyString()))
                .body("userId", equalTo(1));
    }

    @Test
    @Order(3)
    @DisplayName("GET /posts?userId=1")
    void testGetPostsByUserId() {
        given()
        .pathParam("userId", 1)
                .when()
                .get("/posts?userId={userId}")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(1));

    }

    @Test
    @Order(4)
    @DisplayName("POST /posts should create new post")
    void testCreatePost() {
        String requestBody = """
        {
            "title": "REST Assured Test Post",
            "body": "This post was created using REST Assured",
            "userId": 1
        }
        """;

        given()
                .contentType("application/json")
                .body(requestBody)
                .log().all()
                .when()
                .post("/posts")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo("REST Assured Test Post"))
                .body("userId", equalTo(1));
    }

    @Test
    @Order(5)
    @DisplayName("POST /posts with Map body")
    void testCreatePostWithMap() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "Map-based Post");
        requestBody.put("body", "Created using HashMap");
        requestBody.put("userId", 2);

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("Map-based Post"));
    }

    @Test
    @Order(6)
    @DisplayName("PUT /posts/1 should update post")
    void testUpdatePost() {
        String requestBody = """
        {
            "id": 1,
            "title": "Updated Title",
            "body": "Updated body content",
            "userId": 1
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Title"));
    }

    @Test
    @Order(7)
    @DisplayName("DELETE /posts/1 should remove post")
    void testDeletePost() {
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);
    }

    @Test
    @Order(8)
    @DisplayName("PATCH /posts/1 should update post")
    void testPatchPost() {
        String requestBody = """
        {
            "title": "Updated Title 5"
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Title 5"));
    }


    @Test
    @Order(9)
    @DisplayName("Extract and use response data")
    void testExtractResponseData() {
        // Extract entire response
        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .extract()
                .response();

        // Access response properties
        int statusCode = response.getStatusCode();
        String contentType = response.getContentType();
        long responseTime = response.getTime();

        System.out.println("Status: " + statusCode);
        System.out.println("Content-Type: " + contentType);
        System.out.println("Response Time: " + responseTime + "ms");

        // Extract specific values
        int postId = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        int userId = response.jsonPath().getInt("userId");

        System.out.println("Post ID: " + postId);
        System.out.println("Title: " + title);
        System.out.println("User ID: " + userId);

        // Use extracted data in assertions
        Assertions.assertEquals(1, postId);
        Assertions.assertNotNull(title);
    }

    @Test
    @Order(10)
    @DisplayName("Extract and use response data")
    void testPostFromExtractedResponseData() {
        // Extract entire response
        Response response = given()
                .when()
                .get("/posts")
                .then()
                .extract()
                .response();
        int postId = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        int userId = response.jsonPath().getInt("userId");

        System.out.println("Post ID: " + postId);
        System.out.println("Title: " + title);
        System.out.println("User ID: " + userId);

        // Use extracted data in assertions
        Assertions.assertEquals(1, postId);
        Assertions.assertNotNull(title);
    }
}