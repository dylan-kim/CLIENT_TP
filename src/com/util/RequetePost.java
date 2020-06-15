package com.util;

import java.io.IOException;
import java.util.List;


import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class RequetePost {

	public void requetePost(String url, List<NameValuePair> urlParameters) {
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);

			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			httpclient.execute(post);
		} catch (IOException e) {
			e.getMessage();
		}

	}

}
