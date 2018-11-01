package com.wantaihao.farming_demo1.service.serviceImpl;

import com.wantaihao.farming_demo1.domain.AnimalDeliver;
import com.wantaihao.farming_demo1.repository.AnimalDeliverRepository;
import com.wantaihao.farming_demo1.service.AnimalDeliverService;
import com.wantaihao.farming_demo1.vo.AnimalDeliverVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalDeliverServiceImpl implements AnimalDeliverService {
    @Autowired
    private AnimalDeliverRepository animalDeliverRepository;
    @Override
    public List<AnimalDeliverVO> findAll() {
        List<AnimalDeliver> list=animalDeliverRepository.findAll();
        List<AnimalDeliverVO> deliverVOList=new ArrayList<>();
        for (AnimalDeliver animalDeliver:
            list ) {
            deliverVOList.add(new AnimalDeliverVO(animalDeliver));
        }
        return deliverVOList;
    }
}
