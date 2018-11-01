package com.wantaihao.farming_demo1.service;

import com.wantaihao.farming_demo1.domain.AnimalDeliver;
import com.wantaihao.farming_demo1.domain.AnimalInventory;
import com.wantaihao.farming_demo1.vo.AnimalInventoryVO;

import java.util.List;
import java.util.Map;

public interface AnimalInventoryService {

    public List<AnimalInventoryVO> findAll();

    public AnimalInventory findOne(int logId);

    public List<String> findType();

    public String addInventory(AnimalInventory animalInventory);

    public String editInventory(AnimalInventory animalInventory);

    public Map delInventory(int animalBornLogId);

    public String addDeliver(AnimalDeliver animalDeliver);
}
