package com.example.hello2.controller;

import com.example.hello2.mapper.UserMapper;
import com.example.hello2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
	@Autowired
	private UserMapper userMapper;




	@GetMapping("/")

	public String index(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();// tip:ctrl+alt+v 抽取变量
		for (int i = 0; i <cookies.length ; i++)
		{
			//System.out.println(cookies[i].getName());
			if (cookies[i].getName().equals("token")){
				String token = cookies[i].getValue();
				System.out.println(token);
				User user = userMapper.findByToken(token);//请复习局部变量！！！！！！！
				//System.out.println(user);
				if (user!=null){
					request.getSession().setAttribute("user",user);
				break;
			}

		}


		}

		//User user = userMapper.findByToken(token);//tip:alt+Enter 快速创建方法

		//如果token和数据库中有一致的，将对象再放到session中




		return "index";
	}
}
