package com.wantaihao.farming_demo1.service.serviceImpl;


import com.wantaihao.farming_demo1.domain.AnimalCustom;
import com.wantaihao.farming_demo1.domain.AnimalType;
import com.wantaihao.farming_demo1.repository.AnimalCustomRepository;
import com.wantaihao.farming_demo1.repository.AnimalTypeRepository;
import com.wantaihao.farming_demo1.service.AnimalCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnimalCustomServiceImpl implements AnimalCustomService {
    @Autowired
    private AnimalCustomRepository animalCustomRepository;
    @Autowired
    private AnimalTypeRepository animalTypeRepository;
    @Override
    public List<AnimalCustom> findAllProvider() {
        List<AnimalCustom> customs=animalCustomRepository.findByType(1);
        return customs;
    }

    @Override
    public String addProvider(AnimalCustom animalCustom) {
        String message="添加供应商失败！";
        String customName=animalCustom.getCustomName();
        String customTel=animalCustom.getCustomPhone();
        String customAddr=animalCustom.getCustomAddr();
        String customMail=animalCustom.getCustomMail();

        int result=animalCustomRepository.add(customName,customTel,customAddr,customMail,2);
        if(result>0){
            message="添加供应商成功！";

        }
        return message;
    }

    @Override
    public List<AnimalCustom> findAllBuyer() {
        List<AnimalCustom> customs=animalCustomRepository.findByType(2);
        return customs;
    }

    @Override
    public String addBuyer(AnimalCustom animalCustom) {
        String message="添加收购商失败！";
        String customName=animalCustom.getCustomName();
        String customTel=animalCustom.getCustomPhone();
        String customAddr=animalCustom.getCustomAddr();
        String customMail=animalCustom.getCustomMail();

        int result=animalCustomRepository.add(customName,customTel,customAddr,customMail,2);
        if(result>0){
            message="添加收购商成功！";

        }
        return message;
    }

    @Override
    public Map delCustom(Integer customId) {
        int result=animalCustomRepository.delCustom(customId);
        Map<String,Object> map=new HashMap<>();
        if(result>0){
            map.put("message","删除成功！");
        }
        else {
            map.put("message","删除失败！");
        }
        return map;
    }
    @Transactional(rollbackOn = Exception.class)
    @Override
    public String editProvider(AnimalCustom animalCustom) {
        Integer customId=animalCustom.getCustomId();
        String customName=animalCustom.getCustomName();
        String customTel=animalCustom.getCustomPhone();
        String customAddr=animalCustom.getCustomAddr();
        String customMail=animalCustom.getCustomMail();
        String message="修改失败！";
        AnimalCustom origncustom=animalCustomRepository.getOne(customId);
        int result1=animalCustomRepository.editCustom(customName,customTel,customAddr,customMail,customId);
        int result2=animalTypeRepository.changeTypeFrom(customName,origncustom.getCustomName());
        if(result1>0&&result2>0){
            message="修改成功！";
        }
        return message;
    }
}
