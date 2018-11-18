package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.domain.User;
import com.wantaihao.farming_demo1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("doLogin")
    public String login(HttpServletRequest request, @RequestParam String userName, @RequestParam String password, ModelMap map){
        /*request.getSession().setAttribute();*/
        log.info("{} username ,{}password",userName,password);
        String msg="登录失败！";
        User user= userRepository.findByUserName(userName);
        log.info("{}user",user);
        if (user!=null && user.getPassword().equals(password)){
            request.getSession().setAttribute("user",user);
            msg="登录成功！";
            map.addAttribute("msg",msg);
            return "redirect:/index";
        }
        map.addAttribute("msg",msg);
        return "forward:/";

    }
}
