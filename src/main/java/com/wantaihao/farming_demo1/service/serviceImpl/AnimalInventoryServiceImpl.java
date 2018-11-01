package com.wantaihao.farming_demo1.service.serviceImpl;

import com.wantaihao.farming_demo1.domain.AnimalDeliver;
import com.wantaihao.farming_demo1.domain.AnimalInventory;
import com.wantaihao.farming_demo1.repository.AnimalDeliverRepository;
import com.wantaihao.farming_demo1.repository.AnimalInventoryRepository;
import com.wantaihao.farming_demo1.service.AnimalInventoryService;
import com.wantaihao.farming_demo1.vo.AnimalInventoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
public class AnimalInventoryServiceImpl implements AnimalInventoryService {
    @Autowired
    private AnimalInventoryRepository animalInventoryRepository;
    @Autowired
    private AnimalDeliverRepository animalDeliverRepository;
    @Override
    @Transactional(rollbackOn = Exception.class)
    public List<AnimalInventoryVO> findAll() {
        animalInventoryRepository.cleanStatus();
        List<AnimalInventory> list=animalInventoryRepository.findAll();
        List<AnimalInventoryVO> voList=new ArrayList<>();
        for (AnimalInventory animalInventory:list
             ) {
            voList.add(new AnimalInventoryVO(animalInventory));
        }
        return voList;
    }

    @Override
    public AnimalInventory findOne(int logId) {
        AnimalInventory animalInventory=animalInventoryRepository.findOne(logId);
        return animalInventory;
    }

    @Override
    public List<String> findType() {
        List<String> list=null;
        try{list=animalInventoryRepository.findType();}
        catch (Exception e){
            throw new RuntimeException("没有类型数据！");
        }
        return list;
    }
    @Transactional(rollbackOn = Exception.class)
    @Override
    public String addInventory(AnimalInventory animalInventory) {
        String animalTypeName=animalInventory.getAnimalTypeName();
        Date animalOutDate=animalInventory.getAnimalOutDate();
        Date animalInDate=animalInventory.getAnimalInDate();
        int animalBornCount=animalInventory.getAnimalBornCount();
        String animalFrom=animalInventory.getAnimalFrom();
        String message="插入失败！";
        int result=animalInventoryRepository.addInventory(animalTypeName,animalBornCount,animalInDate,animalOutDate,animalFrom);
        if(result>0){
            message="插入成功！";
        }
        return message;
    }
    @Transactional
    @Override
    public String editInventory(AnimalInventory animalInventory) {
        int animalBornLogId=animalInventory.getAnimalBornLogId();
        int animalBornCount=animalInventory.getAnimalBornCount();
        int animalLastCount=animalInventory.getAnimalLastCount();
        String animalFrom=animalInventory.getAnimalFrom();
        Date animalInDate=animalInventory.getAnimalInDate();
        Date animalOutDate=animalInventory.getAnimalOutDate();
        String animalNote=animalInventory.getAnimalNote();
        int result=animalInventoryRepository.editInventory(animalBornCount,animalLastCount,animalFrom,animalInDate,animalOutDate,animalNote,animalBornLogId);
        String message="修改失败！";
        if(result>0){
             message="修改成功！";
        }
        return message;
    }

    @Override
    public Map delInventory(int animalBornLogId) {
        Map<String,Object> map=new HashMap<>();
        int result=animalInventoryRepository.deleteById(animalBornLogId);
        if(result>0){
            map.put("message","删除成功！");
        }
        else {
            map.put("message","删除失败！");
        }
        return map;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public String addDeliver(AnimalDeliver animalDeliver) {
        String animalType=animalDeliver.getAnimalType();
        BigDecimal unitPrice=animalDeliver.getUnitPrice();
        BigDecimal animalNum=animalDeliver.getAnimalNum();
        int animalLogId=animalDeliver.getAnimalLogId();
        Date transDate=animalDeliver.getTransDate();
        String buyerInfo=animalDeliver.getBuyerInfo();
        int result1=animalInventoryRepository.delCount(animalLogId,animalNum);
        int result2=animalDeliverRepository.addDeliver(animalType,unitPrice,animalNum,animalLogId,transDate,buyerInfo);
        String message="卖出失败！";
        if(result1>0&&result2>0){
            message="卖出成功！";
        }
        return message;
    }
}
