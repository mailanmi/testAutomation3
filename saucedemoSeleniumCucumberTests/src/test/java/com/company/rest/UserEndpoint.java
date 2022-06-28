package com.company.rest;

import com.company.rest.dto.User;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

public class UserEndpoint {
    final String baseUrl = "https://petstore.swagger.io/v2";
    final String usersPath = "/user";
    User dummyUser;

    public UserEndpoint() {
        RestAssured.baseURI = baseUrl;
    }

    @Before
    public void setup() {
        RestAssured.baseURI = baseUrl;
    }

    public void addTestUser() {
        dummyUser = new User();
        dummyUser.setId(1);
        dummyUser.setUsername("jkowalski");
        dummyUser.setFirstName("Jan");
        dummyUser.setLastName("Kowalski");
        dummyUser.setEmail("jkowalski@kowalski.pl");
        dummyUser.setPassword("111111");
        dummyUser.setPhone("123456789");
        dummyUser.setPassword("secret");
        dummyUser.setUserStatus(1);
        this.addUser(dummyUser);
    }

    public void getTestUser() {
        // sprawdz czy user jest poprawnie dodany
        User testUser = this.getUserByUsername("jkowalski");
        assertEquals(dummyUser, testUser);
        //System.out.println(testUser.toString());
    }

    public void addUser(User user) {
        RequestSpecification httpRequest = RestAssured.given().
                contentType("application/json").accept("application/json").
                body(user);

        Response response = httpRequest.post(usersPath);

        assertEquals(response.statusCode(), 200);
    }

    public User getUserByUsername(String username) {
        Response getResponse = RestAssured.given().get(usersPath + "/" + username);
        User returnedUser = getResponse.as(User.class);

        assertEquals(getResponse.statusCode(), 200);
        getResponse.getBody().prettyPrint();
        return returnedUser;
    }
}
