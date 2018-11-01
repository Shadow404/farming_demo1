package com.wantaihao.farming_demo1.service;

import com.wantaihao.farming_demo1.domain.AnimalBorn;
import com.wantaihao.farming_demo1.domain.AnimalInventory;

import java.util.List;
import java.util.Map;

public interface AnimalBornService {
    public List<AnimalBorn> findAll();
    public AnimalBorn findOne(int bornId);
    public String addBorn(AnimalBorn animalBorn);
    public List<String> findAnimalType();
    public Map<String,Object> editBorn(int animalBornId);
    public String doEditBorn(AnimalBorn animalBorn);
    public Map comp(int animalBornId);
    public Map<String,Object> chart(int id);
    public  Map unlock(int animalBornId);
    public String newBorn(AnimalBorn animalBorn);
    public String delBorn(int animalBornId);
}
