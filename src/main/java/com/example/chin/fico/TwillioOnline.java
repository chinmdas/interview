package com.practice.chin.fico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class TwillioOnline {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=Pakistan");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/xml");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String apiOutput = br.readLine();
		
		System.out.println(apiOutput.substring(apiOutput.indexOf("capital")+10, apiOutput.indexOf("\",",apiOutput.indexOf("capital")+10)));
		
		String total = apiOutput.substring(apiOutput.indexOf("total")+7, apiOutput.indexOf("total")+8);
		if(Integer.parseInt(total)>0) {
			
		}else {
			
		}

	}

}
