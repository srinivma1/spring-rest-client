/**
 * 
 */
package com.example.demo.restClient.simple;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * @author mahes
 *
 */
public class RestClientApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String restUrl = "http://localhost:8095/books/save";

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");

		JSONObject category = new JSONObject();
		category.put("name", "CategoryB");
		JSONArray jsonArray = new JSONArray();
		JSONObject book1 = new JSONObject();
		book1.put("name", "BookA");
		
		
		JSONObject book2 = new JSONObject();
		book2.put("name", "BookB");
		
		
		JSONObject book3 = new JSONObject();
		book3.put("name", "BookC");
		
		
		jsonArray.put(book1);
		jsonArray.put(book2);
		jsonArray.put(book3);
		category.put("books", jsonArray);
		System.out.println("String is "+category.toString());
		HttpEntity <String> httpEntity = new HttpEntity <String> (category.toString(), httpHeaders);

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(restUrl, httpEntity, String.class);

		JSONObject jsonObj = new JSONObject(response);
		String balance = jsonObj.get("data").toString();
		System.out.println("Output response is"+balance);
	}

}
