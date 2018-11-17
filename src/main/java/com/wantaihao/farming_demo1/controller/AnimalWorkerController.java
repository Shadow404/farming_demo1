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
    @ResponseBody
    @RequestMapping("delWorker")
    public Map<String,Object> delWorker(@RequestParam Integer workerId){
        Map<String,Object> map=animalWorkerService.delWorker(workerId);
        return map;
    }

    @RequestMapping("workerOff")
    public String workerOff(@RequestParam Integer workerId,ModelMap map){
        map.addAttribute("workerId",workerId);
        return "workerOff.html";
    }
    @RequestMapping("editWorker")
    public String editWorker(@RequestParam Integer workerId,ModelMap map){
        AnimalWorker worker=animalWorkerService.findWorker(workerId);
        map.addAttribute("worker",worker);
        return "editWorker.html";
    }
    @RequestMapping("doEditWorker")
    @ResponseBody
    public String doEditWorker(AnimalWorker animalWorker){
        String message=animalWorkerService.editWorker(animalWorker);
        return message;
    }
    @RequestMapping("doWorkerOff")
    @ResponseBody
    public String doWorkerOff(@RequestParam String workerRestNote,@RequestParam Integer workerId){
        log.info("{} restnotre {}",workerRestNote,workerId);
        String message=animalWorkerService.offWorker(workerRestNote,workerId);
        return message;
    }
    @ResponseBody
    @RequestMapping("reWorker")
    public Map<String,Object> reWorker(@RequestParam Integer workerId){
        Map map=animalWorkerService.reWorker(workerId);
        return map;
    }
    @ResponseBody
    @RequestMapping("noRestWorker")
    public Map<String,Object> noRestWorker(@RequestParam Integer workerId){
        Map map=animalWorkerService.noRestWorker(workerId);
        return map;
    }
}
