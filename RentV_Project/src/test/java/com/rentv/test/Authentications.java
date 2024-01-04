package com.rentv.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Authentications extends CommonFunctions {

	public static String baseURL;
	public static String login_Token;
	public static String confirm_Token;
	public static String resendOtp_Token;
	public static String signup_Token;

	@Test(priority = 0, groups = "Login")
	public static void configProperties() throws IOException {

		properties = new Properties();
		properties.load(new FileInputStream(LinkConstants.PropertiesFilePath));

		baseURL = properties.getProperty("baseuri");
		System.out.println("Base URI : "+baseURL);
	}


	@Parameters("MobileNumber")
	@Test(priority = 1, groups = "Login")
	public void login(String mobileNumber) throws IOException {

		//CommonFunctions.configProperties();

		JSONObject requestBody = new JSONObject();
		requestBody.put("countryCode", "91");
		requestBody.put("mobileNo", mobileNumber);
		requestBody.put("type", "phone");

		String contentType = "application/json";

		String loginotpurl = baseURL+LinkConstants.AUTHENTICATION+"loginWithOtp";
		//System.out.println("Base_URL :"+ConfigProperties.baseURL);
		//System.out.println("Login_URI : "+ConfigProperties.loginURL);
		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("Login OTP URL : "+loginotpurl);

		//		String response= RestAssured.given()
		//				.contentType(ContentType.JSON)
		//				.body(requestBody.toJSONString())
		//				.when()
		//				.post(loginotpurl)
		//				.then()
		//				.statusCode(200)
		//				.extract()
		//				.asPrettyString();
		String response = response(requestBody,loginotpurl);
		System.out.println("Login Response : "+response);

		Gson gson = new Gson();
		JsonObject jobj=gson.fromJson(response, JsonObject.class);
		JsonObject dataobj=jobj.getAsJsonObject("data");
		login_Token =dataobj.get("token").getAsString();

		System.out.println("Login Token : "+login_Token);

		//return token;
	}
	@Test(priority = 2, groups = "Login")
	public void confirmOtp() throws IOException {

		//CommonFunctions.configProperties();

		System.out.println("Login Token : "+login_Token);

		JSONObject requestBody = new JSONObject();
		requestBody.put("otp", "1234");
		requestBody.put("token", login_Token);
		requestBody.put("type", "phone");
		requestBody.put("fcm", "");

		String contentType = "application/json";

		String confirmotpurl = baseURL+LinkConstants.AUTHENTICATION+"confirmOtp";
		//System.out.println("Base_URL :"+ConfigProperties.baseURL);
		//System.out.println("Login_URI : "+ConfigProperties.loginURL);
		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("Confirm OTP URL : "+confirmotpurl);

		String response= RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody.toJSONString())
				.when()
				.post(confirmotpurl)
				.then()
				.statusCode(200)
				.extract()
				.asPrettyString();
		System.out.println("Login Confirm Response : "+response);

		Gson gson = new Gson();
		JsonObject jobj=gson.fromJson(response, JsonObject.class);
		JsonObject dataobj=jobj.getAsJsonObject("data");
		confirm_Token =dataobj.get("token").getAsString();

		System.out.println("Confirm Token : "+confirm_Token);

		//return token;
	}

	public void resendOtp() throws IOException {

		//CommonFunctions.configProperties();

		System.out.println("Login Token : "+login_Token);

		JSONObject requestBody = new JSONObject();

		requestBody.put("token", login_Token);
		requestBody.put("type", "phone");

		String contentType = "application/json";

		String resendotpurl = baseURL+LinkConstants.AUTHENTICATION+"resendOtp";
		//System.out.println("Base_URL :"+ConfigProperties.baseURL);
		//System.out.println("Login_URI : "+ConfigProperties.loginURL);
		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("Confirm OTP URL : "+resendotpurl);

		String response= RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody.toJSONString())
				.when()
				.post(resendotpurl)
				.then()
				.statusCode(200)
				.extract()
				.asPrettyString();
		System.out.println("Login Confirm Response : "+response);

		Gson gson = new Gson();
		JsonObject jobj=gson.fromJson(response, JsonObject.class);
		JsonObject dataobj=jobj.getAsJsonObject("data");
		resendOtp_Token =dataobj.get("token").getAsString();

		System.out.println("Confirm Token : "+resendOtp_Token);

		//return token;
	}

	public void signup() throws IOException {

		//CommonFunctions.configProperties();

		System.out.println("Login Token : "+login_Token);

		JSONObject requestBody = new JSONObject();

		requestBody.put("name", "sdf");
		requestBody.put("mobileISOCode", "91");
		requestBody.put("mobileNo", "1234567894");
		requestBody.put("email", "test4@gmail.com");
		requestBody.put("age", "21");

		String contentType = "application/json";

		String signupotpurl = baseURL+LinkConstants.AUTHENTICATION+"signup";
		//System.out.println("Base_URL :"+ConfigProperties.baseURL);
		//System.out.println("Login_URI : "+ConfigProperties.loginURL);
		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("Confirm OTP URL : "+signupotpurl);

		String response= RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody.toJSONString())
				.when()
				.post(signupotpurl)
				.then()
				.statusCode(200)
				.extract()
				.asPrettyString();
		System.out.println("Login Confirm Response : "+response);

		Gson gson = new Gson();
		JsonObject jobj=gson.fromJson(response, JsonObject.class);
		JsonObject dataobj=jobj.getAsJsonObject("data");
		signup_Token =dataobj.get("token").getAsString();

		System.out.println("Confirm Token : "+signup_Token);

		//return token;
	}

}
