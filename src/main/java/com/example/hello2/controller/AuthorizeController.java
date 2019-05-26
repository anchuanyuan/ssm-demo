package com.example.hello2.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hello2.dto.AccessTokenDTO;
import com.example.hello2.dto.GithubUser;
import com.example.hello2.provider.GithubProvider;

@Controller
public class AuthorizeController {
	
	@Autowired
	private GithubProvider githubProvider;
	
	
	@GetMapping("/callback")
	public String callback(@RequestParam(name = "code")String code ,
						@RequestParam(name = "state")String state) throws IOException {
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClient_id("ad5534e20ea4e811a1fe");
		accessTokenDTO.setClient_secret("11c42f3356b189e6c07766c70c0aa3eeff82f1dd");
		accessTokenDTO.setCode(code);
		accessTokenDTO.setRedirect_uri("http://localhost:8087/callback");
		accessTokenDTO.setState(state);
		String accesstoken =githubProvider.getaAcessToken(accessTokenDTO);
		GithubUser githubUser =  githubProvider.getUserInfo(accesstoken);
		System.out.println(githubUser.getId());
		return "index";
	}

}