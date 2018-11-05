package com.wantaihao.farming_demo1.service;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import com.wantaihao.farming_demo1.vo.AnimalWorkerVO;

import java.util.List;

public interface AnimalWorkerService {
    /*显示所有饲养员列表*/
    List<AnimalWorkerVO> findAll();
}
