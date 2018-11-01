package com.wantaihao.farming_demo1.service.serviceImpl;


import com.wantaihao.farming_demo1.domain.AnimalCustom;
import com.wantaihao.farming_demo1.repository.AnimalCustomRepository;
import com.wantaihao.farming_demo1.service.AnimalCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalCustomServiceImpl implements AnimalCustomService {
    @Autowired
    private AnimalCustomRepository animalCustomRepository;

    @Override
    public List<AnimalCustom> findAllProvider() {
        List<AnimalCustom> customs=animalCustomRepository.findByType();
        return customs;
    }
}
