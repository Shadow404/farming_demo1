package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.domain.AnimalType;
import com.wantaihao.farming_demo1.service.AnimalTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Controller
public class AnimalTypeController {
    @Autowired
    private AnimalTypeService typeService;
    @GetMapping("/type")
    public String animalTypeAll(ModelMap map){
         List<AnimalType> list=typeService.findAll();
         map.addAttribute("typeNums",list.size());
         map.addAttribute("typeList",list);
         return "type.html";
    }
    @GetMapping("/list")
    @ResponseBody
    public List<AnimalType> lists(@RequestParam(defaultValue = "0") int page){

        Pageable pageable=new PageRequest(page,4);
        return typeService.findAll(pageable).getContent();
    }
    @RequestMapping("/addType")
    public String addType(){
        return "addType.html";
    }

    @RequestMapping("/doAddType")
    @ResponseBody
    public String doAddType( AnimalType animalType){
        log.info("typename {}",animalType.getAnimalTypeName());
        log.info("typefrom {}",animalType.getAnimalTypeFrom());
        String message=typeService.addType(animalType);

        return message;
    }
    @RequestMapping("/delType")
    @ResponseBody
    public Map<String,String> delType(@RequestParam int animalTypeId){
        String message=typeService.delType(animalTypeId);
        Map map=new HashMap();
        map.put("message",message);
        return map;
    }
    @RequestMapping("editType")
    public String editType(@RequestParam int animalTypeId,ModelMap map){
        Map<String,Object> map1=typeService.findById(animalTypeId);
        map.addAttribute("message",map1.get("message"));
        map.addAttribute("animalTypeId",map1.get("animal_type_id"));
        map.addAttribute("animalTypeName",map1.get("animal_type_name"));
        map.addAttribute("animalTypeFrom",map1.get("animal_type_from"));
        return "editType.html";
    }
    @RequestMapping("doEditType")
    @ResponseBody
    public String doEditType(AnimalType animalType){
        String message=typeService.editType(animalType);
        return message;
    }
    @RequestMapping("/changeTypeStatus")
    @ResponseBody
    public Map<String,Object> changeTypeStatus(@RequestParam int animalTypeId,@RequestParam int status){
        log.info("id {}, status {}",animalTypeId,status);
        String message=null;
        if(status==1){
            message=typeService.changeTypeStatus(animalTypeId,2);
        }
        else if(status==2){
            message=typeService.changeTypeStatus(animalTypeId,1);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("message",message);
        return map;
    }
}
