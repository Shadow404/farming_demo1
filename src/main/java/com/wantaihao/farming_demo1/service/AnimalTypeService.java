package com.wantaihao.farming_demo1.service;

import com.wantaihao.farming_demo1.domain.AnimalType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface AnimalTypeService {
    Page<AnimalType> findAll(Pageable pageable);
    List<AnimalType> findAll();
    Page<AnimalType> findByAnimalTypeName(Pageable pageable);
    String addType(AnimalType animalType);
    String delType(int animalTypeId);
    Map<String,Object> findById(int animalTypeId);
    String editType(AnimalType animalType);
    String changeTypeStatus(int animalTypeId,int animalTypeStatus);
    List<String> findProviders();
}
