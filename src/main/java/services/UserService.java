package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import models.request.UpdateUserRequest;

public class UserService {

    public static Response createUser(CreateUserRequest user) {
        return RestAssured.given()
                .baseUri("https://gorest.co.in/public/")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 4a3da067ec4065adf1dfae5c13e8a6fb574158d80e49af7db43b5816cffee4d3")
                .and()
                .basePath("/v2/users")
                .body(user.toString())
                .when()
                .post()
                .then()
                .extract().response();
    }

    public static Response updateUser(Integer userId, UpdateUserRequest userRequest) {
        System.out.println(userId);
        return RestAssured.given()
                .baseUri("https://gorest.co.in/public/")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 4a3da067ec4065adf1dfae5c13e8a6fb574158d80e49af7db43b5816cffee4d3")
                .and()
                .basePath("/v2/users/" + userId)
                .body(userRequest.toString())
                .when()
                .put()
                .then()
                .extract().response();
    }

}
