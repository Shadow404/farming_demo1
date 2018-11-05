package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import com.wantaihao.farming_demo1.service.AnimalWorkerService;
import com.wantaihao.farming_demo1.vo.AnimalWorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AnimalWorkerController {
    @Autowired
    private AnimalWorkerService animalWorkerService;
    @RequestMapping("worker")
    public String worker(ModelMap map){
        List<AnimalWorkerVO> workerList=animalWorkerService.findAll();
        map.addAttribute("workerList",workerList);
        map.addAttribute("size",workerList.size());
        return "worker.html";
    }
}
