package com.wantaihao.farming_demo1.service.serviceImpl;

import com.wantaihao.farming_demo1.domain.AnimalBorn;
import com.wantaihao.farming_demo1.domain.AnimalInventory;
import com.wantaihao.farming_demo1.repository.AnimalBornRepository;
import com.wantaihao.farming_demo1.repository.AnimalInventoryRepository;
import com.wantaihao.farming_demo1.service.AnimalBornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class AnimalBornServiceImpl implements AnimalBornService {
    @Autowired
    private AnimalBornRepository animalBornRepository;
    @Autowired
    private AnimalInventoryRepository animalInventoryRepository;
    public List<AnimalBorn> findAll() {
        return animalBornRepository.findAll();
    }

    @Override
    public AnimalBorn findOne(int bornId) {

        return animalBornRepository.findOne(bornId);
    }

    @Override
    public String addBorn(AnimalBorn animalBorn) {
        String animalTypeName=animalBorn.getAnimalTypeName();
        int animalBornCount=animalBorn.getAnimalBornCount();
        Date animalBornDate =animalBorn.getAnimalBornDate();
        Date animalInDate=animalBorn.getAnimalInDate();
        Date animalSeedDate=animalBorn.getAnimalSeedDate();
        int result=animalBornRepository.add(animalTypeName,animalBornCount,animalSeedDate,animalBornDate,animalInDate);
        if(result>0){
            return "添加成功！";
        }
        return "添加失败！";
    }

    @Override
    public List<String> findAnimalType() {
        List<String> typeList=animalBornRepository.findAnimalList();
        if(typeList.size()>0){
            return typeList;
        }
        else{
            throw new  RuntimeException("没有数据！");
        }
    }

    @Override
    public Map<String,Object> editBorn(int animalBornId) {
        Map<String,Object> bornMap=new HashMap<>();
        AnimalBorn animalBorn=null;
        try{
            animalBorn=animalBornRepository.editBorn(animalBornId);
            bornMap.put("animalBorn",animalBorn);
        }catch (Exception e){
            throw new RuntimeException("没有数据！");
        }
        return bornMap;
    }

    @Override//完成编辑
    public String doEditBorn(AnimalBorn animalBorn) {
        int animalBornId=animalBorn.getAnimalBornId();
        int animalBornCount=animalBorn.getAnimalBornCount();
        Date animalSeedDate=animalBorn.getAnimalSeedDate();
        Date animalBornDate=animalBorn.getAnimalBornDate();
        Date animalInDate=animalBorn.getAnimalInDate();
        String animalBornNote=animalBorn.getAnimalBornNote();
        String message="修改失败！";
        int result=animalBornRepository.doEditBorn(animalBornCount,animalSeedDate,animalBornDate,animalInDate,animalBornNote,animalBornId);
        if(result>0){
            message="修改成功！";
        }
        return message;
    }
    @Transactional(rollbackOn = Exception.class)
    @Override//完成生产
    public Map comp(int animalBornId) {

        AnimalBorn animalBorn=animalBornRepository.findOne(animalBornId);
        Map<String,Object> map=new HashMap<>();

            int result1=animalBornRepository.comp(animalBornId,-1);//完成生产状态2
            String animalTypeName=animalBorn.getAnimalTypeName();//类型名称
            Date animalBornDate=animalBorn.getAnimalBornDate();//生产日期
            int animalBornNum=animalBorn.getAnimalBornNum();//生产的批次
            int animalBornCount=animalBorn.getAnimalBornCount();//生产个数
            String animalNote=animalBorn.getAnimalBornNote();//疫苗记录
            int result2=animalBornRepository.log(animalBornId,animalBornCount,animalBornDate,animalBornNum,animalNote,animalTypeName);
           if(result1>0&&result2>0){
               map.put("message","入库成功！");
           }
           map.put("message","入库失败！");
        return map;
    }

    @Override//获得图表内容
    public Map<String,Object> chart(int id) {
        Map<String,Object> map=new HashMap<>();

        List<AnimalInventory> list=animalInventoryRepository.findAllById(id);
        if(list.size()>0){
            map.put("animalBornList",list);
            return map;
        }
        map.put("message","没有数据");
        return map;
    }

    @Override//解锁
    public Map unlock(int animalBornId) {
        int result=animalBornRepository.unlock(animalBornId);
        Map<String,Object> map=new HashMap<>();
        if(result>0){
            map.put("message","解锁成功！");
        }
        else {
            map.put("message","解锁失败！");
        }
        return map;
    }

    @Override
    public String newBorn(AnimalBorn animalBorn) {
        int animalBornCount=animalBorn.getAnimalBornCount();
        Date animalSeedDate=animalBorn.getAnimalSeedDate();
        Date animalBornDate=animalBorn.getAnimalBornDate();
        int animalBornId=animalBorn.getAnimalBornId();
        int result=animalBornRepository.newBorn(animalBornCount,animalSeedDate,animalBornDate,animalBornId);
        String message="添加失败！";
        if(result>0){
            message="添加成功！";
        }
        return message;
    }

    @Override
    public String delBorn(int animalBornId) {
        int result=animalBornRepository.delBron(animalBornId);
        String message="删除失败";
        if(result>0){
            message="删除成功！";
        }
        return message;
    }
}
