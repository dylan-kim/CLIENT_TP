package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class RequeteGet {

	public String requeteGet(String url) {
		String result = "";
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			result = rd.readLine();
		} catch (IOException e) {
			e.getMessage();
		}

		return result;
	}

}
