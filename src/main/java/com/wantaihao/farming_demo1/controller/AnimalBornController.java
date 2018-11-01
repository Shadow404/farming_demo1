package com.wantaihao.farming_demo1.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wantaihao.farming_demo1.annoation.CacheLock;
import com.wantaihao.farming_demo1.annoation.CacheParam;
import com.wantaihao.farming_demo1.domain.AnimalBorn;
import com.wantaihao.farming_demo1.domain.AnimalInventory;
import com.wantaihao.farming_demo1.service.AnimalBornService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class AnimalBornController {
    @Autowired
    private AnimalBornService animalBornService;
    @GetMapping("/born")
    public String born(ModelMap map){
        List<AnimalBorn> list=animalBornService.findAll();
        log.info("{} ",list);
        map.addAttribute("bornList",list);
        map.addAttribute("bornSize",list.size());
        return "born.html";
    }
    @GetMapping("/bornItem")
    public String bornItem(@RequestParam int bornId,ModelMap map){
        AnimalBorn animalBornItem=animalBornService.findOne(bornId);
        map.addAttribute("animalBornItem",animalBornItem);
        return "bornItem.html";
    }
    @RequestMapping("/addBorn")
    public String addBorn(ModelMap map){
        List<String> typeList=null;
        try{typeList=animalBornService.findAnimalType();}
        catch (Exception e){
            map.addAttribute("message",e.getMessage());
        }
        map.addAttribute("typeList",typeList);
        return "addBorn.html";
    }
    @RequestMapping("/doAddBorn")
    @ResponseBody
    public String doAddBorn( AnimalBorn animalBorn){
        String message=animalBornService.addBorn(animalBorn);
        return message;
    }

    @RequestMapping("editBorn")
    public String editBorn(@RequestParam int aniamlBornId,ModelMap map){
        Map<String,Object> map1=animalBornService.editBorn(aniamlBornId);
        map.addAttribute("animalBorn",map1.get("animalBorn"));
        map.addAttribute("message",map1.get("message"));
        return "editBorn.html";
    }
    @RequestMapping("/doEditBorn")
    @ResponseBody

    public String doEditBorn( AnimalBorn animalBorn){
        String message=animalBornService.doEditBorn(animalBorn);
        return message;
    }
    @RequestMapping("/compBorn")
    @ResponseBody
    public Map<String,Object> compBorn(@RequestParam int animalBornId){
        Map map =animalBornService.comp(animalBornId);
        return  map;
    }
    @ResponseBody
    @RequestMapping("bornChart")
    public Map<String,Object> bornChart(@RequestParam int id){
        log.info("{} id =====",id);
        Map map=animalBornService.chart(id);

        return map;
    }
    @RequestMapping("/unlockBorn")
    @ResponseBody
    public Map<String,Object> unlockBorn(@RequestParam int animalBornId){
        log.info("{}=======animalId",animalBornId);
        Map map =animalBornService.unlock(animalBornId);
        return map;
    }
    @RequestMapping("newAdd")

    public String newAdd(@RequestParam int animalBornId,ModelMap map){

        map.addAttribute("animalBornId",animalBornId);
        return "newBorn.html";
    }
    @ResponseBody
    @RequestMapping("doNewBorn")
    public String doNewBorn(AnimalBorn animalBorn){

        String message=animalBornService.newBorn(animalBorn);
        return message;
    }
    @ResponseBody
    @RequestMapping("delBorn")
    public Map<String,Object> delBorn(@RequestParam int animalBornId){
        String message=animalBornService.delBorn(animalBornId);
        Map<String,Object> map=new HashMap<>();
        map.put("message",message);
        return map;
    }
}
