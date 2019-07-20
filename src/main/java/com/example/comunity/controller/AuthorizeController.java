package com.example.comunity.controller;

import com.example.comunity.dto.AccessTokenDTO;
import com.example.comunity.dto.GithubUser;
import com.example.comunity.mapper.UserMapper;
import com.example.comunity.model.User;
import com.example.comunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AuthorizeController {
	
	@Autowired
	private GithubProvider githubProvider;
	@Autowired
	private UserMapper userMapper;

	@Value("${github.client.id}")
    private  String clientId;

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
		accessTokenDTO.setClient_id(clientId);
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