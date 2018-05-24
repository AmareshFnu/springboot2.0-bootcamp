package com.testing.springboot.client;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JersyRestClient {

	public static void main(String[] args) {
		createEmployee();
		getEmployee();
		deleteEmployee();

	}

	private static void getEmployee() {
		try {

			Client client = Client.create();

			WebResource webResource2 = client.resource("http://localhost:8086/getEmployee");
			ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}

			String output2 = response2.getEntity(String.class);
			System.out.println("::::::::::::::::::::::::::Employee List::::::::::::::::::::::::::::");
			System.out.println(output2);

			Gson gson = new Gson();
	        String json = gson.toJson(output2);
	        
	        JsonElement jelement = new JsonParser().parse(json);
	        JsonObject  jobject = jelement.getAsJsonObject();
	        
	        System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createEmployee() {
		try {

			Client client = Client.create();
			String input = " {\n" + "        \"empID\": \"8623\",\n" + "        \"empName\": \"Ram\",\n"
					+ "        \"empSalary\": \"10000\",\n" + "        \"empDesignation\": \"PA\"\n" + "    },";

			WebResource webResource2 = client.resource("http://localhost:8086/createEmployee");

			ClientResponse response2 = webResource2.accept("application/json").type("application/json")
					.post(ClientResponse.class, input);
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}

			String output2 = response2.getEntity(String.class);
			System.out.println(output2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteEmployee() {
		try {

			Client client = Client.create();
			String input = " {\n" + "        \"empID\": \"8623\",\n" + "        \"empName\": \"Ram\",\n"
					+ "        \"empSalary\": \"10000\",\n" + "        \"empDesignation\": \"PA\"\n" + "    },";

			WebResource webResource2 = client.resource("http://localhost:8086/deleteEmployee");

			ClientResponse response2 = webResource2.accept("application/json").type("application/json")
					.delete(ClientResponse.class, input);
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}

			String output2 = response2.getEntity(String.class);
			System.out.println("::::::::::::::Employee deleted successfuly::::::::::::::::::::");
			System.out.println(output2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
