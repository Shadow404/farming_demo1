package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.annoation.CacheLock;
import com.wantaihao.farming_demo1.annoation.CacheParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @RequestMapping("index")
    public String index(HttpServletRequest request, ModelMap map){
        Object user= request.getSession().getAttribute("user");

        if (user==null){
           String msg="请先登录！";
            map.addAttribute("msg",msg);
            return "redirect:/";
        }

        return "index.html";
    }
    @RequestMapping("/")
    public String login(){
        return "login.html";
    }
/*    @CacheLock(prefix = "books")
    @GetMapping
    public String query(@CacheParam(name = "token") @RequestParam String token) {
        return "success - " + token;
    }*/

}
