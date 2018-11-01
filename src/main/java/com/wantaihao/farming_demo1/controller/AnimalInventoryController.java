package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.domain.AnimalDeliver;
import com.wantaihao.farming_demo1.domain.AnimalInventory;
import com.wantaihao.farming_demo1.service.AnimalInventoryService;
import com.wantaihao.farming_demo1.vo.AnimalInventoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class AnimalInventoryController {
    @Autowired
    private AnimalInventoryService animalInventoryService;
    @RequestMapping("inventory")
    public String inventory(ModelMap map){
        List<AnimalInventoryVO> list=animalInventoryService.findAll();
        map.addAttribute("InventoryList",list);
        map.addAttribute("size",list.size());
        return "inventory.html";
    }

    @RequestMapping("inventoryItem")
    public String inventoryItem(@RequestParam int logId,ModelMap map){
        AnimalInventory animalInventory=animalInventoryService.findOne(logId);
        map.addAttribute("inventItem",animalInventory);
        return "inventoryItem.html";
    }
    @RequestMapping("addInventory")
    public String addInventory(ModelMap map){
        List<String> typeList=null;
        try {
            typeList=animalInventoryService.findType();
            map.addAttribute("typeList",typeList);
        }catch (Exception e){
            map.addAttribute("message",e.getMessage());
        }
        return "addInventory.html";
    }
    @ResponseBody
    @RequestMapping("doAddInventory")
    public String doAddInventory(AnimalInventory animalInventory){
        String message=animalInventoryService.addInventory(animalInventory);
        return message;
    }
    @RequestMapping("editInventory")
    public String editInventory(ModelMap map,@RequestParam int animal_log_id){
        AnimalInventory animalInventory=animalInventoryService.findOne(animal_log_id);
        map.addAttribute("animalInventory",animalInventory);
        return "editInventory.html";
    }
    @ResponseBody
    @RequestMapping("doEditInventory")
    public String doEditInventory(AnimalInventory animalInventory){

        String message=animalInventoryService.editInventory(animalInventory);
        return message;
    }
    @RequestMapping("delInventory")
    @ResponseBody
    Map<String,Object> delInventory(@RequestParam int animalBornLogId){
        Map map=null;
        map=animalInventoryService.delInventory(animalBornLogId);
        return map;
    }
    @RequestMapping("addDeliver")
    public String addDeliver(ModelMap map,@RequestParam int animalLogId){
        AnimalInventory animalInventory=animalInventoryService.findOne(animalLogId);
        map.addAttribute("innt",animalInventory);
        return "addDeliver.html";
    }
    @RequestMapping("doAddDeliver")
    @ResponseBody
    public String doAddDeliver(AnimalDeliver animalDeliver){

        String message=animalInventoryService.addDeliver(animalDeliver);
        return message;
    }
}
