package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.domain.AnimalDeliver;
import com.wantaihao.farming_demo1.service.AnimalDeliverService;
import com.wantaihao.farming_demo1.vo.AnimalDeliverVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class AnimalDeliverController {
    @Autowired
    private AnimalDeliverService animalDeliverService;
    @RequestMapping("deliver")
    public String deliver(ModelMap map){
        List<AnimalDeliverVO> deliverList=animalDeliverService.findAll();
        map.addAttribute("deliverList",deliverList);
        map.addAttribute("size",deliverList.size());
        return "deliver.html";
    }
}
