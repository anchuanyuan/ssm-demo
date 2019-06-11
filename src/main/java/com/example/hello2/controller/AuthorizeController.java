package com.example.hello2.controller;

import java.io.IOException;
import java.util.UUID;

import com.example.hello2.mapper.UserMapper;
import com.example.hello2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hello2.dto.AccessTokenDTO;
import com.example.hello2.dto.GithubUser;
import com.example.hello2.provider.GithubProvider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizeController {
	
	@Autowired
	private GithubProvider githubProvider;
	@Autowired
	private UserMapper userMapper;

	@Value("${github.client.id}")
    private  String clientid;

    @Value("${github.client.secret}")
	private  String secret;

    @Value("${github.client.redirect_uri}")
	private  String redirect_uri;



	
	
	@GetMapping("/callback")
	public String callback(@RequestParam(name = "code")String code ,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClient_id(clientid);
		accessTokenDTO.setClient_secret(secret);
		accessTokenDTO.setCode(code);
		accessTokenDTO.setRedirect_uri(redirect_uri);
		accessTokenDTO.setState(state);
		String accesstoken =githubProvider.getaAcessToken(accessTokenDTO);
		GithubUser githubUser =  githubProvider.getUserInfo(accesstoken);
		//System.out.println(githubUser.getId());

		if (githubUser!= null){
		    //登录成功，写个session 和cookie

			User user = new User();

            String token = UUID.randomUUID().toString();
            user.setToken(token);
            response.addCookie(new Cookie("token", token ));
			//user.setName(githubUser.getName());
			user.setName("acy");
			user.setId(githubUser.getId());
			//user.setAccount(githubUser.getBioString());
			user.setAccount("bbb");
			user.setGmtCreate(System.currentTimeMillis());
			user.setGmtModified(user.getGmtCreate());
			System.out.println(user);
            userMapper.insert(user);
            //session
            request.getSession().setAttribute("user" , user);

		}else {
			return "redirect:/";
		}
		return "redirect:/";
	}

}