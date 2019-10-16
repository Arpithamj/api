package test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class first {
@Test
	public void APITest() {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in";
		 given().
		         param("page","2").
		         //param("test","3")
                 //header("test","2").
                 //cookie("kdfjglk")
		         
		         when().
		         get("api/users").
		         then().assertThat().
		         statusCode(200).and().contentType(ContentType.JSON).and().
		         body("data[0].first_name",equalTo("Michael")).and().
		         body("data[1].avatar",equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg"))
		         .and().body("page",equalTo(2)).and().header("Server", "cloudflare");
		         //given()
		//Request Header
		//Parameters
		//Request
		//Cookies
		//body
		
		//when()
		//get(resource)
		//post(resource)
		//put()
		
		//then()
		//assertions to verify whether we are getting right results
		 
		//extract()
		

	}

}
