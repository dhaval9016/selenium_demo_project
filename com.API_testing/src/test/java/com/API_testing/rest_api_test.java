package com.API_testing;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class rest_api_test {

	@Test(priority = 1)
	public void setup() {
		
		//without static method : import io.restassured.RestAssured.*;
		//Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
				
		//with static method : import static io.restassured.RestAssured.*;
		Response res = get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int rescode = res.getStatusCode();
		System.out.println("Api response code " + rescode);
	}
	
	
	@Test(priority = 2)
	public void getresponse(){
		
		//added static method in import restassured
		//without static method : import io.restassured.RestAssured.*;
		//Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		//with static method : import static io.restassured.RestAssured.*;
		//Response resp = get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		//Direct add response as string now
		
		String resData = get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();	
		System.out.println(resData);
		
		long time = get("").getTime();
		
		System.out.println("Response time " + time);
	}

}
