package com.rentv.test;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class FriendsModule extends Authentications {

	String contentType = "application/json";

	@Test(priority = 3, groups = {"Connections"})
	public void getConnections()throws IOException  {

		JSONObject requestBody = new JSONObject();
		requestBody.put("perPageRecords", "100");
		requestBody.put("pageNo", "1");

		String getConnectionurl = baseURL+LinkConstants.CONNECTIONS+"getConnections";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("getConnections OTP URL : "+getConnectionurl);

		String response = auth_Response(requestBody,confirm_Token,getConnectionurl);
		System.out.println("GetConnections Response : "+response);

	}

	@Parameters("UserCodeForDeletion")
	@Test(priority = 4, groups = {"Connections"})
	public void deleteConnection(String userCode)throws IOException  {

		JSONObject requestBody = new JSONObject();
		requestBody.put("receiverUserCode", userCode);

		String deleteConnectionurl = baseURL+LinkConstants.CONNECTIONS+"deleteConnection";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("deleteConnection URL : "+deleteConnectionurl);

		String response = auth_Response(requestBody,confirm_Token,deleteConnectionurl);
		System.out.println("deleteConnection Response : "+response);
	}
	//@Test(priority = 5, groups = {"Connections"})
	public void mutualConnections() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("receiverUserCodes", "[7b5f71d7-6ba2-453e-8967-b3dc49,be3ee239-cb98-4fcc-a67c-13dbe9]");

		String mutualConnectionsurl = baseURL+LinkConstants.CONNECTIONS+"mutualConnections";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("mutualConnections URL : "+mutualConnectionsurl);

		String response = auth_Response(requestBody,confirm_Token,mutualConnectionsurl);
		System.out.println("mutualConnections Response : "+response);

	}

	@Parameters("UserCodeToSendRequest")
	@Test(priority = 5, groups = {"AddFriends"})
	public void addFriends(String userCode) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("receiverUserCode", userCode);

		String sendRequesturl = baseURL+LinkConstants.CONNECTIONS+"sendRequest";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("sendRequest URL : "+sendRequesturl);

		String response = auth_Response(requestBody,confirm_Token,sendRequesturl);
		System.out.println("sendRequest Response : "+response);

	}
	
	//@Test(priority = 6, groups = {"AddFriends"})
	public void inviteUser() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("mobileNo", "9951600955");

		String inviteUserurl = baseURL+LinkConstants.INVITEUSER+"inviteUser";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("inviteUser URL : "+inviteUserurl);

		String response = auth_Response(requestBody,confirm_Token,inviteUserurl);
		System.out.println("inviteUser Response : "+response);
	}

	@Test(priority = 6, groups = {"Requests"})
	public void receivedRequests() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("perPageRecords", "20");
		requestBody.put("pageNo", "40");

		String receivedRequestsurl = baseURL+LinkConstants.CONNECTIONS+"receivedRequests";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("receivedRequests URL : "+receivedRequestsurl);

		String response = auth_Response(requestBody,confirm_Token,receivedRequestsurl);
		System.out.println("receivedRequests Response : "+response);
	}


	@Parameters("ConfirmUserRequestCode")
	@Test(priority = 8, groups = {"Requests"})
	public void confirmRequest(String userCode) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("senderUserCode", userCode);

		String confirmRequesturl = baseURL+LinkConstants.CONNECTIONS+"confirmRequest";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("confirmRequest URL : "+confirmRequesturl);

		String response = auth_Response(requestBody,confirm_Token,confirmRequesturl);
		System.out.println("confirmRequest Response : "+response);

	}

	@Parameters("UserCodeForIgnore")
	@Test(priority = 9, groups = {"Requests"})
	public void ignoreRequest(String userCode) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("senderUserCode", userCode);

		String ignoreRequesturl = baseURL+LinkConstants.CONNECTIONS+"ignoreRequest";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("ignoreRequest URL : "+ignoreRequesturl);

		String response = auth_Response(requestBody,confirm_Token,ignoreRequesturl);
		System.out.println("ignoreRequest Response : "+response);
	}

		public void deleteRequest() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("perPageRecords", "20");
		requestBody.put("pageNo", "40");

		String deleteRequesturl = baseURL+LinkConstants.CONNECTIONS+"deleteRequest";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("deleteRequest URL : "+deleteRequesturl);

		String response = auth_Response(requestBody,confirm_Token,deleteRequesturl);
		System.out.println("deleteRequest Response : "+response);
	}

		@Test(priority = 7, groups = {"Requests"})
		public void countOfPendingRequest() {

		String countOfPendingRequesturl = baseURL+LinkConstants.CONNECTIONS+"countOfPendingRequest";

		System.out.println("countOfPendingRequest URL : "+countOfPendingRequesturl);

		String response = get_Response(confirm_Token,countOfPendingRequesturl);
		System.out.println("receivedRequests Response : "+response);
	}

		//@Test(priority = 9, groups = {"Connections"})
		public void searchByMobileNumber() {

			JSONObject requestBody = new JSONObject();
			requestBody.put("mobileNumbers", "9766152234");

			String searchByMobileNumberurl = baseURL+LinkConstants.CONNECTIONS+"searchByMobileNumber";

			String requestBodyString = requestBody.toString();
			System.out.println("Request Body String : "+requestBody);
			System.out.println("searchByMobileNumber URL : "+searchByMobileNumberurl);

			String response = auth_Response(requestBody,confirm_Token,searchByMobileNumberurl);
			System.out.println("searchByMobileNumber Response : "+response);

		}

}
