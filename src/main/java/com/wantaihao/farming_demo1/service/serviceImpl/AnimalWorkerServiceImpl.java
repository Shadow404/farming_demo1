package com.wantaihao.farming_demo1.service.serviceImpl;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import com.wantaihao.farming_demo1.repository.AnimalWorkerRepository;
import com.wantaihao.farming_demo1.service.AnimalWorkerService;
import com.wantaihao.farming_demo1.vo.AnimalWorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class AnimalWorkerServiceImpl implements AnimalWorkerService {
    @Autowired
    private AnimalWorkerRepository animalWorkerRepository;

    @Override
    public List<AnimalWorkerVO> findAll() {
        List<AnimalWorker> workers=animalWorkerRepository.findAll();
        List<AnimalWorkerVO> list=new ArrayList<>();
        for (AnimalWorker worker:workers
             ) {
            list.add(new AnimalWorkerVO(worker));
        }
        return list;
    }

    @Override
    public String addWorker(AnimalWorker animalWorker) {
        String workerName=animalWorker.getWorkerName();
        String workerTel=animalWorker.getWorkerTel();
        String workerAddr= animalWorker.getWorkerAddr();
        BigDecimal workerWage=animalWorker.getWorkerWage();
        Date workerBirth=animalWorker.getWorkerBirth();
        String workerNote=animalWorker.getWorkerNote();
        int result=animalWorkerRepository.addWorker(workerName,workerTel,workerAddr,workerWage,workerBirth,workerNote);
        String message="添加饲养员失败！";
        if(result>0){
            message="添加饲养员成功！";
        }
        return message;
    }

    @Override
    public Map<String, Object> delWorker(Integer workerId) {
        Map<String,Object> map=new HashMap<>();
        int result=animalWorkerRepository.delWorker(workerId);
        if(result>0){
            map.put("message","离职成功！");
        }
        else {
            map.put("message","离职失败！");
        }
        return map;
    }

    @Override
    public AnimalWorker findWorker(Integer workerId) {
        AnimalWorker animalWorker=animalWorkerRepository.getOne(workerId);

        return animalWorker;
    }

    @Override
    public String editWorker(AnimalWorker animalWorker) {
        String workerName=animalWorker.getWorkerName();
        String workerTel=animalWorker.getWorkerTel();
        String workerAddr= animalWorker.getWorkerAddr();
        BigDecimal workerWage=animalWorker.getWorkerWage();
        Date workerBirth=animalWorker.getWorkerBirth();
        String workerNote=animalWorker.getWorkerNote();
        Integer workerId=animalWorker.getWorkerId();
        int result=animalWorkerRepository.editWorker(workerName,workerTel,workerAddr,workerWage,workerBirth,workerNote,workerId);
        String message="修改饲养员失败！";
        if(result>0){
            message="修改饲养员成功！";
        }
        return message;
    }

    @Override
    public String offWorker(String workerRestNote, Integer workerId) {
        String message="休假失败！";
        int result=animalWorkerRepository.offWorker(workerRestNote,workerId);
        if(result>0){
            message="休假成功！";
        }
        return message;
    }

    @Override
    public Map reWorker(Integer workerId) {
        Map<String,Object> map=new HashMap<>();
        int result=animalWorkerRepository.reWorker(workerId);
        if(result>0){
            map.put("message","复职成功！");
        }
        else {
            map.put("message","复职成功！");
        }
        return map;
    }

    @Override
    public Map noRestWorker(Integer workerId) {
        Map<String,Object> map=new HashMap<>();
        int result=animalWorkerRepository.noRestWorker(workerId);
        if(result>0){
            map.put("message","休假结束成功！");
        }
        else {
            map.put("message","休假结束成功！");
        }
        return map;
    }
}
