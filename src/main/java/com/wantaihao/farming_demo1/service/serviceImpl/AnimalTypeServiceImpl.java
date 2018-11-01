package com.wantaihao.farming_demo1.service.serviceImpl;

import com.wantaihao.farming_demo1.domain.AnimalType;
import com.wantaihao.farming_demo1.repository.AnimalTypeRepository;
import com.wantaihao.farming_demo1.service.AnimalTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class AnimalTypeServiceImpl implements AnimalTypeService {
    @Autowired
    private AnimalTypeRepository animalTypeRepository;
    @Override
    public Page<AnimalType> findAll(Pageable pageable) {
        return animalTypeRepository.findAll(pageable);
    }

    @Override
    public List<AnimalType> findAll() {
        return animalTypeRepository.findAll();
    }

    @Override
    public Page<AnimalType> findByAnimalTypeName(Pageable pageable) {
        return animalTypeRepository.findByAnimalTypeName(pageable);
    }

    @Override
    public String addType(AnimalType animalType) {
        String animalTypeName=animalType.getAnimalTypeName();
        String animalTypeFrom=animalType.getAnimalTypeFrom();
        int result=animalTypeRepository.addType(animalTypeName,animalTypeFrom);
        if(result>0){
            return "添加成功！";
        }
        return "添加失败！";
    }

    @Override
    public String delType(int animalTypeId) {
        int result=animalTypeRepository.delType(animalTypeId);
        if(result>0){
            return "删除成功！";
        }
        return "删除失败！";
    }

    @Override
    public Map<String,Object> findById(int animalTypeId) {
        Map map=animalTypeRepository.findById(animalTypeId);
        if(map.size()<1){
            map.put("message","没有查询到此动物品种");
        }
        return map;
    }

    @Override
    public String editType(AnimalType animalType) {
        String animalTypeFrom=animalType.getAnimalTypeFrom();
        String animalTypeName=animalType.getAnimalTypeName();
        int animalTypeId=animalType.getAnimalTypeId();
        int result=animalTypeRepository.editType(animalTypeName,animalTypeFrom,animalTypeId);
        if(result>0){
            return "修改成功！";
        }
        return "修改失败！";
    }

    @Override
    public String changeTypeStatus(int animalTypeId, int animalTypeStatus) {
        int result=animalTypeRepository.changeTypeStatus(animalTypeId,animalTypeStatus);
        if(result>0){
            return "操作成功！";
        }
        return "操作失败！";
    }
}
