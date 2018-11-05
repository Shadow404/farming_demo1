package com.wantaihao.farming_demo1.controller;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import com.wantaihao.farming_demo1.service.AnimalWorkerService;
import com.wantaihao.farming_demo1.vo.AnimalWorkerVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
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
    @RequestMapping("addWorker")
    public String addWorker(){
        return "addWorker.html";
    }
    @RequestMapping("doAddWorker")
    @ResponseBody
    public String doAddWorker(AnimalWorker animalWorker){
        log.info("{} worker",animalWorker);
        String message=animalWorkerService.addWorker(animalWorker);
        return message;
    }
    @RequestMapping("delWorker")
    public Map<String,Object> delWorker(@RequestParam Integer workerId){
        Map<String,Object> map=animalWorkerService.delWorker(workerId);
        return map;
    }
    @RequestMapping("workerOff")
    public String workerOff(){
        return "workerOff.html";
    }
}
