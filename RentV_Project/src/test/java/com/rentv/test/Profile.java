package com.rentv.test;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Profile extends Authentications {

	String contentType = "application/json";

	//@Test(priority = 3)
	public void getOthersProfile()throws IOException  {

		JSONObject requestBody = new JSONObject();
		requestBody.put("userCode", "tripModel.tenantCode");

		String getOthersProfileurl = baseURL+LinkConstants.AUTHENTICATION+"getOthersProfile";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("getOthersProfile URL : "+getOthersProfileurl);

		String response = auth_Response(requestBody,confirm_Token,getOthersProfileurl);
		System.out.println("getOthersProfile Response : "+response);
	}

	@Parameters("NameToUpdate, AgeToUpdate")
	@Test(priority = 4, groups = {"profile"})
	public void profileUpdate(String name, String age)throws IOException  {

		JSONObject requestBody = new JSONObject();
		JSONObject dlLinksrequestBody = new JSONObject();
		requestBody.put("profilePicUrl", "null");
		requestBody.put("name", name);
		requestBody.put("age", age);
		requestBody.put("dlLinks", "dlLinksrequestBody");
		dlLinksrequestBody.put("front", "null");
		dlLinksrequestBody.put("back", "null");

		String profileUpdateurl = baseURL+LinkConstants.AUTHENTICATION+"profileUpdate";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("profileUpdate URL : "+profileUpdateurl);

		String response = auth_Response(requestBody,confirm_Token,profileUpdateurl);
		System.out.println("profileUpdate Response : "+response);
	}

	//@Test(priority = 5, groups = {"profile"})
	public void getNameAndProfilePic()throws IOException  {

		JSONObject requestBody = new JSONObject();
		requestBody.put("userCodes", "[ac1366e8-9db5-4504-97f1-c92459]");

		String getNameAndProfilePicurl = baseURL+LinkConstants.AUTHENTICATION+"getNameAndProfilePic";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("getNameAndProfilePic URL : "+getNameAndProfilePicurl);

		String response = auth_Response(requestBody,confirm_Token,getNameAndProfilePicurl);
		System.out.println("getNameAndProfilePic Response : "+response);
	}

	//@Test(priority = 6, groups = {"profile"})
	public void checkEmailExist()throws IOException  {

		JSONObject requestBody = new JSONObject();
		requestBody.put("email", "email@gmail.com");

		String checkEmailExisturl = baseURL+LinkConstants.AUTHENTICATION+"checkEmailExist";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("checkEmailExist URL : "+checkEmailExisturl);

		String response = auth_Response(requestBody,confirm_Token,checkEmailExisturl);
		System.out.println("checkEmailExist Response : "+response);
	}

}
