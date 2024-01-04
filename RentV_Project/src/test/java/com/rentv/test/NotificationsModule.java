package com.rentv.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NotificationsModule extends Authentications {

	String contentType = "application/json";

	@Test(priority =3, groups = {"Notifications"})
	public void getNotifications() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("perPageRecords", "20");
		requestBody.put("pageNo", "1");

		String getNotificationsurl = baseURL+LinkConstants.NOTIFICATIONS+"getNotifications";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("getNotifications URL : "+getNotificationsurl);

		String response = auth_Response(requestBody,confirm_Token,getNotificationsurl);
		System.out.println("getNotifications Response : "+response);
	}

	@Parameters("UserCodeForNotificationDelete")
	@Test(priority = 6, groups = {"Notifications"})
	public void deleteNotifications(String userCode) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("code", userCode);
		
		String deleteNotificationsurl = baseURL+LinkConstants.NOTIFICATIONS+"delete";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("deleteNotifications URL : "+deleteNotificationsurl);

		String response = auth_Response(requestBody,confirm_Token,deleteNotificationsurl);
		System.out.println("deleteNotifications Response : "+response);
	}

	@Test(priority = 4, groups = {"Notifications"})
	public void readNotifications() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("category", "notificationModel.category");
		
		String readNotificationsurl = baseURL+LinkConstants.NOTIFICATIONS+"read";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("readNotifications URL : "+readNotificationsurl);

		String response = auth_Response(requestBody,confirm_Token,readNotificationsurl);
		System.out.println("readNotifications Response : "+response);
	}
	
	@Test(priority = 5, groups = {"Notifications"})
	public void countOfUnreadNotifications() {

		String countOfUnreadNotificationsurl = baseURL+LinkConstants.NOTIFICATIONS+"countOfUnreadNotifications";

		System.out.println("countOfUnreadNotifications URL : "+countOfUnreadNotificationsurl);

		String response = get_Response(confirm_Token,countOfUnreadNotificationsurl);
		System.out.println("countOfUnreadNotifications Response : "+response);
	}
	
}
