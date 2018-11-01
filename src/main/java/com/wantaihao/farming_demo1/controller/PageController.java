package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.annoation.CacheLock;
import com.wantaihao.farming_demo1.annoation.CacheParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {
    @RequestMapping("index")
    public String index(){
        return "index.html";
    }
//    @CacheLock(prefix = "books")
//    @GetMapping
//    public String query(@CacheParam(name = "token") @RequestParam String token) {
//        return "success - " + token;
//    }

}
