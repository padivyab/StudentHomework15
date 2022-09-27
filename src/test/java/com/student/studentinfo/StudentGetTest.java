package com.student.studentinfo;

import com.student.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentInfo() {
      Response response=  given()
                .pathParam("id","102")
                .when()
                .get("/{id}");
      //response.then().statusCode(200);
      response.then().statusCode(404); //delete check krava mate
      response.prettyPrint(); // response ma data aavse

    }

    @Test
    public void searchStudentWithParameter() {

        HashMap<String,Object>qParam = new HashMap<>();  // 2nd way
        qParam.put("programme","Financial Analysis");
        qParam.put("limit",3);

        Response response = given()
                //.queryParam("programme","Financial Analysis")  // 1st way
                //.queryParam("limit",3)
                .queryParams(qParam)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();


    }

}
