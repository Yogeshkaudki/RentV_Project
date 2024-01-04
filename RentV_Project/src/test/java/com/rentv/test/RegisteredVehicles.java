package com.rentv.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisteredVehicles extends Authentications {

	String contentType = "application/json";

	@Test(priority = 3, groups = {"RegisteredVehicles"})
	public void getMyVehicles() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("perPageRecords", "100");
		requestBody.put("pageNo", "1");
		
		String getMyVehiclesurl = baseURL+LinkConstants.VEHICLES+"getMyVehicles";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("getMyVehicles URL : "+getMyVehiclesurl);

		String response = auth_Response(requestBody,confirm_Token,getMyVehiclesurl);
		System.out.println("getMyVehicles Response : "+response);
	}
	
	@Parameters("RegNo")
	@Test(priority = 4, groups = {"RegisteredVehicles"})
	public void createVehicle(String regNo) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("modelCode", "27abe026-7369-430d-a974-f656a6");
		requestBody.put("fuelType", "Petrol");
		requestBody.put("registrationNumber", regNo);
		requestBody.put("rcDocument", "null");
		requestBody.put("vehicleType", "CAR");
		requestBody.put("company", "BMW");
		requestBody.put("modelName", "3 Series");
		requestBody.put("json", "null");
		requestBody.put("seater", "5");
		requestBody.put("transmission", "Manual");
		
		String createVehiclesurl = baseURL+LinkConstants.VEHICLES+"create";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("create URL : "+createVehiclesurl);

		String response = auth_Response(requestBody,confirm_Token,createVehiclesurl);
		System.out.println("createVehicles Response : "+response);
	}

	@Parameters("UpdateByCompanyName, UpdateByModelName")
	@Test(priority = 5, groups = {"RegisteredVehicles"})
	public void updateVehicle(String companyName, String modelName) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("modelCode", "de2666a5-48fa-4902-a188-27cce6");
		requestBody.put("fuelType", "Petrol");
		requestBody.put("registrationNumber", "TG0123");
		
		requestBody.put("rcDocument", "null");
		
		requestBody.put("vehicleType", "CAR");
		requestBody.put("company", companyName);
		requestBody.put("modelName", modelName);
		
		requestBody.put("json", "{}");
		requestBody.put("code", "14d67681-a38e-4b27-b645-395f56");
		
		String updateVehicleurl = baseURL+LinkConstants.VEHICLES+"updateVehicle";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("updateVehicle URL : "+updateVehicleurl);

		String response = auth_Response(requestBody,confirm_Token,updateVehicleurl);
		System.out.println("updateVehicle Response : "+response);
	}

	@Parameters("DeleteVehicleCode")
	@Test(priority = 6, groups = {"RegisteredVehicles"})
	public void deleteVehicle(String vehicleCode) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("vehicleCode", vehicleCode);
				
		String deleteVehiclesurl = baseURL+LinkConstants.VEHICLES+"delete";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("delete URL : "+deleteVehiclesurl);

		String response = auth_Response(requestBody,confirm_Token,deleteVehiclesurl);
		System.out.println("delete Response : "+response);
	}

	//------Listed Vehicles-------
	@Parameters("StartDateForListing, EndDateForListing")
	@Test(priority = 8, groups = {"ListedVehicles"})
	public void vehiclesCreateListing(String startDate, String endDate) {

		JSONObject requestBody = new JSONObject();
		JSONObject locationBody = new JSONObject();
		
		requestBody.put("vehicleCode", "3406bbd1-be44-4bee-9f35-4e4d14");
		requestBody.put("latitude", "17.38504409790039");
		requestBody.put("longitude", "78.4866714477539");
		requestBody.put("rentPerDay", "3000");
		requestBody.put("json", "{}");
		requestBody.put("location", "locationBody");
		locationBody.put("fullAddress", "Hyderabad, Telangana, India");
		locationBody.put("region", "Hyderabad");
		requestBody.put("startDate", startDate);
		requestBody.put("endDate", endDate);
				
		String createVehiclesurl = baseURL+LinkConstants.LISTING+"create";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("create URL : "+createVehiclesurl);

		String response = auth_Response(requestBody,confirm_Token,createVehiclesurl);
		System.out.println("create Response : "+response);
	}

	
	@Test(priority = 7, groups = {"ListedVehicles"})
	public void getAllListings() {
		
		JSONObject requestBody = new JSONObject();
		
		requestBody.put("perPageRecords", "20");
		requestBody.put("pageNo", "1");
		requestBody.put("startDate", "1701129600000");
		requestBody.put("endDate", "1701302400000");
		
		String getAllListingsurl = baseURL+LinkConstants.LISTING+"getAllListings";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("getAllListings URL : "+getAllListingsurl);

		String response = auth_Response(requestBody,confirm_Token,getAllListingsurl);
		System.out.println("getAllListings Response : "+response);

	}
}
