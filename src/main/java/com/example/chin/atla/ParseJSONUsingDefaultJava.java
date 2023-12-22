package com.practice.chin.atla;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ParseJSONUsingDefaultJava {
	
	public static void main(String[] args) throws IOException {
		URL obj = new URL("https://jsonmock.hackerrank.com/api/countries?name=Afghanistan");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			String newStr=response.toString().replace("\"", "");
			int capIndex=newStr.toString().indexOf("capital:");
			int comma=newStr.toString().indexOf(",", capIndex);
			System.out.println(newStr.substring(capIndex+8,comma));
		} else {
			System.out.println("GET request not worked");
		}
	}

}
