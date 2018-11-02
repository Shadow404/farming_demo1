package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.domain.AnimalCustom;
import com.wantaihao.farming_demo1.service.AnimalCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("addProvider")
    public String addProvider(){
        return "addProvider.html";
    }
    @RequestMapping("doAddProvider")
    @ResponseBody
    public String doAddProvider(AnimalCustom animalCustom){
        String message=animalCustomService.addProvider(animalCustom);
        return message;
    }
    @RequestMapping("buyer")
    public String buyer(ModelMap map){
        List<AnimalCustom> customs=animalCustomService.findAllBuyer();
        map.addAttribute("buyers",customs);
        map.addAttribute("size",customs.size());
        return "buyer.html";
    }
    @RequestMapping("addBuyer")
    public String addBuyer(){
        return "addProvider.html";
    }
    @RequestMapping("doAddBuyer")
    @ResponseBody
    public String doAddBuyer(AnimalCustom animalCustom){
        String message=animalCustomService.addProvider(animalCustom);
        return message;
    }
}
