package com.rentv.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TripsModule extends Authentications {

	String contentType = "application/json";

	@Parameters("TripStatus")
	@Test(priority = 3, groups = {"TripStatusPage"})
	public void getTrips(String tripStatus) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("perPageRecords", "20");
		requestBody.put("pageNo", "1");
		requestBody.put("filter", tripStatus);

		String getTripsurl = baseURL+LinkConstants.TRIPS+"getTrips";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("getTrips URL : "+getTripsurl);

		String response = auth_Response(requestBody,confirm_Token,getTripsurl);
		System.out.println("getTrips Response : "+response);
	}

	@Parameters("VehicleCodeToCreate, StartDate, EndDate, Latitude, Longitude")
	@Test(priority = 4, groups = {"CreateTrip"})
	public void createTrip(String vehicleCode, String startDate,String endDate,String latitude,String longitude) {

		JSONObject requestBody = new JSONObject();
		JSONObject pickUpLocationRequestBody = new JSONObject();
		JSONObject dropLocationRequestBody = new JSONObject();
		JSONObject jsonRequestBody = new JSONObject();
		requestBody.put("vehicleCode", vehicleCode);
		requestBody.put("ownerCode", "91fb286a-9c84-4a74-bb95-3497d7");
		requestBody.put("pickUpLocation", "pickUpLocationRequestBody");
		requestBody.put("dropLocation", "dropLocationRequestBody");
		requestBody.put("startDate", startDate);
		requestBody.put("endDate", endDate);
		requestBody.put("json", "jsonRequestBody");
		pickUpLocationRequestBody.put("latitutde", latitude);
		pickUpLocationRequestBody.put("longitude", longitude);
		pickUpLocationRequestBody.put("location", "India");
		pickUpLocationRequestBody.put("region", "India");
		dropLocationRequestBody.put("latitutde", latitude);
		dropLocationRequestBody.put("longitude", longitude);
		dropLocationRequestBody.put("location", "India");
		dropLocationRequestBody.put("region", "India");
		jsonRequestBody.put("rentPerDay", "5000");
		jsonRequestBody.put("noc", "null");
		jsonRequestBody.put("pollution", "");
		jsonRequestBody.put("insurance", "");
		jsonRequestBody.put("rcBack", "");
		jsonRequestBody.put("rcFront", "");

		String createTripurl = baseURL+LinkConstants.TRIPS+"create";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("createTrip URL : "+createTripurl);

		String response = auth_Response(requestBody,confirm_Token,createTripurl);
		System.out.println("createTrips Response : "+response);
	}

	public void update() {

		JSONObject requestBody = new JSONObject();
		JSONObject pickUpLocationRequestBody = new JSONObject();
		JSONObject dropLocationRequestBody = new JSONObject();
		//JSONObject jsonRequestBody = new JSONObject();
		requestBody.put("code", "6ad1512d-d996-4918-abd5-408c49");
		//requestBody.put("tripStatus", "CANCELLED");
		requestBody.put("pickUpLocation", "pickUpLocationRequestBody");
		requestBody.put("dropLocation", "dropLocationRequestBody");
		requestBody.put("startDate", "1694588968000");
		requestBody.put("endDate", "1694848168000");
		//requestBody.put("json", "jsonRequestBody");
		pickUpLocationRequestBody.put("region", "region address");
		pickUpLocationRequestBody.put("location", "India");
		pickUpLocationRequestBody.put("latitutde", "null");
		pickUpLocationRequestBody.put("longitude", "null");
		dropLocationRequestBody.put("region", "region address");
		dropLocationRequestBody.put("location", "India");
		dropLocationRequestBody.put("latitutde", "null");
		dropLocationRequestBody.put("longitude", "null");

		String updateTripsurl = baseURL+LinkConstants.TRIPS+"update";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("updateTrips URL : "+updateTripsurl);

		String response = auth_Response(requestBody,confirm_Token,updateTripsurl);
		System.out.println("updateTrips Response : "+response);
	}

	@Parameters("VehicleCodeForUpdate, EditStartDate, EditEndDate")
	@Test(priority = 5, groups = {"EditTrip"})
	public void editTrip(String vehicleCode, String startDate, String endDate) {

		JSONObject requestBody = new JSONObject();
		JSONObject pickUpLocationRequestBody = new JSONObject();
		JSONObject dropLocationRequestBody = new JSONObject();
		//JSONObject jsonRequestBody = new JSONObject();
		requestBody.put("code", vehicleCode);
		//requestBody.put("tripStatus", "CANCELLED");
		requestBody.put("pickUpLocation", "pickUpLocationRequestBody");
		requestBody.put("dropLocation", "dropLocationRequestBody");
		requestBody.put("startDate", startDate);
		requestBody.put("endDate", endDate);
		//requestBody.put("json", "jsonRequestBody");
		pickUpLocationRequestBody.put("region", "Dehradun");
		pickUpLocationRequestBody.put("location", "Dehradun, Uttarakhand, India");
		pickUpLocationRequestBody.put("latitutde", "30.31649398803711");
		pickUpLocationRequestBody.put("longitude", "78.03218841552734");
		dropLocationRequestBody.put("region", "Dehradun");
		dropLocationRequestBody.put("location", "Dehradun, Uttarakhand, India");
		dropLocationRequestBody.put("latitutde", "30.31649398803711");
		dropLocationRequestBody.put("longitude", "78.03218841552734");

		String editTripurl = baseURL+LinkConstants.TRIPS+"editTrip";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("editTrip URL : "+editTripurl);

		String response = auth_Response(requestBody,confirm_Token,editTripurl);
		System.out.println("editTrip Response : "+response);
	}

	@Test(priority = 6, groups = {"UpdatedTripsCount"})
	public void countOfUpdatedTrips() {

		String countOfUpdatedTripsurl = baseURL+LinkConstants.TRIPS+"countOfUpdatedTrips";
		System.out.println("CountOfUpdatedTrips URL : "+countOfUpdatedTripsurl);

		String response = get_Response(confirm_Token,countOfUpdatedTripsurl);
		System.out.println("CountOfUpdatedTrips Response : "+response);
	}

}
