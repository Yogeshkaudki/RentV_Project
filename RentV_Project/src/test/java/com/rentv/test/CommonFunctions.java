package com.rentv.test;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.Properties;
import java.util.logging.LogManager;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.rentv.test.AppHooks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CommonFunctions {


	public static String baseURL;
	public static String loginURL;
	public static String final_token;
	public static Properties properties;

	//public static Logger log = LogManager.resetLogger(CommonFunctions.class);
	RequestSpecification reqSpec;
	//@Test
	public static void configProperties() throws IOException {

		properties = new Properties();
		properties.load(new FileInputStream(LinkConstants.PropertiesFilePath));

		baseURL = properties.getProperty("baseuri");
		System.out.println("Base URI : "+baseURL);

		//		String key = properties.getProperty("login");
		//		System.out.println(key);
		//
		//		loginURL = properties.getProperty("loginURL")+key;
		//		System.out.println("Login URI : "+loginURL);

	}

	public String response(JSONObject requestBody,String url) {

		String response= RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody.toJSONString())
				.when()
				.post(url)
				.then()
				.statusCode(200)
				.extract()
				.asPrettyString();
		return response;

	}

	public String auth_Response(JSONObject requestBody,String token,String url) {

		String response= RestAssured.given()
				.contentType(ContentType.JSON)
				.header("Authorization",token)
				.body(requestBody.toJSONString())
				.when()
				.post(url)
				.then()
				.statusCode(200)
				.extract()
				.asPrettyString();
		return response;

	}

	public String get_Response(String token,String url) {

		String response= RestAssured.given()
				.contentType(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get(url)
				.then()
				.statusCode(200)
				.extract()
				.asPrettyString();
		return response;

	}


	public RequestSpecification requestSpecification() {

		reqSpec = given()
				.baseUri(AppHooks.prop.getProperty("baseURI"))				 
				.queryParam("key", AppHooks.prop.getProperty("key"))
				.queryParam("token", AppHooks.prop.getProperty("token"))
				.contentType(ContentType.JSON);

		return reqSpec;
	}

	public RequestSpecification postRequestSpecification() {

		reqSpec = given()
				.baseUri(AppHooks.prop.getProperty("baseURI"))
				.queryParam("idList", AppHooks.prop.getProperty("idList"))
				.queryParam("key", AppHooks.prop.getProperty("key"))
				.queryParam("token", AppHooks.prop.getProperty("token"))
				.contentType(ContentType.JSON);

		return reqSpec;
	}
	public static void main(String[] args) throws IOException {

		CommonFunctions CF = new CommonFunctions();
		CF.configProperties();
	}

}
