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

    @Override
    public String addProvider(AnimalCustom animalCustom) {
        String message="添加供应商失败！";
        String customName=animalCustom.getCustomName();
        String customTel=animalCustom.getCustomPhone();
        String customAddr=animalCustom.getCustomAddr();
        String customMail=animalCustom.getCustomMail();

        int result=animalCustomRepository.add(customName,customTel,customAddr,customMail);
        if(result>0){
            message="添加供应商成功！";

        }
        return message;
    }
}
