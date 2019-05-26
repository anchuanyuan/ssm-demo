package com.example.hello2.provider;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.hello2.dto.AccessTokenDTO;
import com.example.hello2.dto.GithubUser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class GithubProvider {
	public String getaAcessToken(AccessTokenDTO accesstoken) throws IOException {
		
		MediaType mediaType = MediaType.get("application/json; charset=utf-8");

		OkHttpClient client = new OkHttpClient();
		

	  RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesstoken));
	  Request request = new Request.Builder()
	      .url("https://github.com/login/oauth/access_token")
	      .post(body)
	      .build();
	  Response response = client.newCall(request).execute(); 
	     String anstring =response.body().string();
	     System.out.println(anstring);
	     String s2 = anstring.split("=")[1];
	     String access_token=s2.split("&")[0];
	     System.out.println(access_token);
	     return access_token;
	}
	
	public GithubUser getUserInfo(String accesstoken) throws IOException {
		OkHttpClient client =new OkHttpClient();
		Request request =new Request.Builder()
				.url("https://api.github.com/user?access_token="+ accesstoken)
				.build();
		Response response = client.newCall(request).execute();
		String aString = response.body().string();
		System.out.println(aString);
		GithubUser githubUser= JSON.parseObject(aString,GithubUser.class);
		System.out.println(githubUser.toString());
				return githubUser;
				
	}
	 
}

