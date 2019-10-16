package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class twitter2 {
	String ConsumerKey="2Xtd4ILUtinfACHehAvCNcbjW";
	String ConsumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	
	@Test
	public void UsernameTweets() {
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		Response response=given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
		when().get("/user_timeline.json").then().extract().response();
		String res=response.asString();
		System.out.println(res);
	}
	

}
