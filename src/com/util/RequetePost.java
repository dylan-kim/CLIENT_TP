package com.util;

import java.io.IOException;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class RequetePost {

	public void requetePost(String url) {
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);

			httpclient.execute(post);
		} catch (IOException e) {
			e.getMessage();
		}

	}

}
