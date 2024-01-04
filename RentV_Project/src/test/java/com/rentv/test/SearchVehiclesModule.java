package com.rentv.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchVehiclesModule extends Authentications {

	String contentType = "application/json";

	@Parameters("StartDate, EndDate")
	@Test(priority = 3, groups = {"AvailableVehicles"})
	public void getAllListings(String startDate, String endDate) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("perPageRecords", "200");
		requestBody.put("pageNo", "1");
		requestBody.put("startDate", startDate);
		requestBody.put("endDate", endDate);

		String getAllListingsurl = baseURL+LinkConstants.LISTING+"getAllListings";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("getAllListings URL : "+getAllListingsurl);

		String response = auth_Response(requestBody,confirm_Token,getAllListingsurl);
		System.out.println("getAllListings Response : "+response);
	}

	// ------Search Vehicles Module Filters-----

	@Test(priority = 4, groups = {"SearchFilters"})
	public void searchVehicles() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("fuelType", "Petrol");
		requestBody.put("seater", 5);
		requestBody.put("transmission", "Manual");
		requestBody.put("sortBy", "PRICEHIGH");
		requestBody.put("company", "Audi");
		requestBody.put("modelName", "Q3");
		requestBody.put("latitude", "17.38504409790039");
		requestBody.put("longitude", "78.4866714477539");
		requestBody.put("vehicleType", "CAR");
		requestBody.put("startDate", "1699228800000");
		requestBody.put("endDate", "1700006400000");
		requestBody.put("pageNo", 1);

		String searchVehiclesurl = baseURL+LinkConstants.VEHICLES+"searchVehicles";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("searchVehicles URL : "+searchVehiclesurl);

		String response = auth_Response(requestBody,confirm_Token,searchVehiclesurl);
		System.out.println("searchVehicles Response : "+response);
	}
	
	@Parameters("SearchByCompanyName")
	@Test(priority = 5, groups = {"SearchFilters"})
	public void searchCompanyName(String companyName) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("vehicleType", "car");
		requestBody.put("keywoard", companyName);
		requestBody.put("pageNo", 1);
		requestBody.put("perPageRecords", 100);

		String searchCompanyNameurl = baseURL+LinkConstants.PRELOADED_VEHICLES+"searchCompanyName";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("searchCompanyName URL : "+searchCompanyNameurl);

		String response = auth_Response(requestBody,confirm_Token,searchCompanyNameurl);
		System.out.println("searchCompanyName Response : "+response);
	}
	
	@Parameters("SearchByCompany, SearchByModel")
	@Test(priority = 6, groups = {"SearchFilters"})
	public void searchModel(String company, String model) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("vehicleType", "car");
		requestBody.put("keywoard", model);
		requestBody.put("pageNo", 1);
		requestBody.put("perPageRecords", 100);
		requestBody.put("company", company);

		String searchModelurl = baseURL+LinkConstants.PRELOADED_VEHICLES+"searchModel";

		String requestBodyString = requestBody.toString();
		System.out.println("Request Body String : "+requestBody);
		System.out.println("searchModel URL : "+searchModelurl);

		String response = auth_Response(requestBody,confirm_Token,searchModelurl);
		System.out.println("searchModel Response : "+response);
	}
	
}
