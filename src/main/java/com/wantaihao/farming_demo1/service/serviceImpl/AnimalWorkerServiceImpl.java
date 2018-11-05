package com.wantaihao.farming_demo1.service.serviceImpl;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import com.wantaihao.farming_demo1.repository.AnimalWorkerRepository;
import com.wantaihao.farming_demo1.service.AnimalWorkerService;
import com.wantaihao.farming_demo1.vo.AnimalWorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
