package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.domain.AnimalCustom;
import com.wantaihao.farming_demo1.service.AnimalCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AnimalCustomController {
    @Autowired
    private AnimalCustomService animalCustomService;
    @RequestMapping("provider")
    public String provider(ModelMap map){
        List<AnimalCustom> customs=animalCustomService.findAllProvider();
        map.addAttribute("customs",customs);
        map.addAttribute("size",customs.size());
        return "provider.html";
    }
}
