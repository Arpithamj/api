package test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.resources;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class second {
//path parameter https://www.example.com/books/{book_id}
	//query parameter https://www.example.com/book?book_id=1
	//header parameter
	Properties prop = new Properties();
	@BeforeTest
	public void getData() throws IOException {
		//Properties prop = new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\Online Test\\Desktop\\New folder\\APIAutomation\\src\\files\\data.properties");
		prop.load(fis);
		prop.getProperty("HOST");
	}
	
	@Test(dataProvider="NameData")
	
	public void APITest1(String fname,String lname)
	{
		RestAssured.baseURI=prop.getProperty("HOST");
		//step1
		Response res=given().
				param("page","2").
		//queryParam("Test","value")
		/*body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}").*/
		when().
		get(resources.resourceData()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
        extract().response();	
		//step2
		String responsestring=res.asString();
		System.out.println(responsestring);
		JsonPath js=new JsonPath(responsestring);
		String finame=js.get("data[0].first_name");
		System.out.println(finame );
		//String my_output= GenerateStringFromResource("C:\\Users\\Online Test\\Downloads\\selenium")
		//step3
		Response res1=given().
		body(Payload.getpayload(fname,lname)).
		when().put(resources.resourceDataPut()).
        then().assertThat().statusCode(200).extract().response();
	    String responseString1=res1.asString();
	    System.out.println(responseString1);
	    
	    //public String GenerateStringFromResource(String path) throws IOException
	    //{
	    //	return String(Files.readAllBytes(Paths.get(path)));
	    //}
	
	}
	@DataProvider(name="NameData")
	public Object[][] getvalues() {
	return new Object[][] {{"Arpitha","Mj"},{"test1","test2"},{"test3","test4"}};
	}
	}
