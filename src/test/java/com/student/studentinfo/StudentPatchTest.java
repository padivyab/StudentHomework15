package com.student.studentinfo;

import com.student.model.StudentPojo;
import com.student.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){


            StudentPojo studentPojo =new StudentPojo();
            studentPojo.setFirstName("divya");
            studentPojo.setEmail("xyz12@gmail.com");
            studentPojo.setProgramme("api testing");

            Response response = given()
                    .header("Content-Type","application/json")
                    .pathParam("id","101")
                    .body(studentPojo)
                    .when()
                    .patch("/{id}");
            response.then().statusCode(200);
            response.prettyPrint();
        }

    }

