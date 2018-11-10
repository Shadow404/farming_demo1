package com.wantaihao.farming_demo1.service;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import com.wantaihao.farming_demo1.vo.AnimalWorkerVO;

import java.util.List;
import java.util.Map;

public interface AnimalWorkerService {
    /*显示所有饲养员列表*/
    List<AnimalWorkerVO> findAll();
    /*添加饲养员*/
    String addWorker(AnimalWorker animalWorker);
    /*离职饲养员*/
    Map<String, Object> delWorker(Integer workerId);
    /*查询饲养员*/
    AnimalWorker findWorker(Integer workerId);
    /*修改饲养员*/
    String editWorker(AnimalWorker animalWorker);
}
