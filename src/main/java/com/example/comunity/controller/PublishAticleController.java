package com.example.comunity.controller;


import com.example.comunity.mapper.AticleMapper;
import com.example.comunity.mapper.UserMapper;
import com.example.comunity.model.Article;
import com.example.comunity.model.User;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PublishAticleController {


    @Autowired
    private AticleMapper aticleMapper;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/publish")
    public String publish(


    ) {

        return "publish";
    }

    @PostMapping("/pubilsh")
    public String toDoPublishAticle(
            Model model,

            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "tag", required = false) String tag,
            HttpServletRequest request,
            HttpServletResponse response) {
        User user = null;
        Cookie[] cookies = request.getCookies();// tip:ctrl+alt+v 抽取变量
        if (cookies != null && cookies.length != 0) {

            for (int i = 0; i < cookies.length; i++) {
                //System.out.println(cookies[i].getName());
                if (cookies[i].getName().equals("token")) {
                    String token = cookies[i].getValue();
                    //System.out.println(token);
                    user = userMapper.findByToken(token);
                    //System.out.println(user);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                        break;
                    }

                }

            }
        }

        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setTag(tag);
        article.setGmtCreate(System.currentTimeMillis());
        article.setGmtModified(article.getGmtCreate());
        article.setId(user.getId());
        System.out.println("article");
        aticleMapper.addAticle(article);


        return "index";


    }
}