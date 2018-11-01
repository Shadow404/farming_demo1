package com.wantaihao.farming_demo1.vo;

import com.wantaihao.farming_demo1.domain.AnimalInventory;
import lombok.Data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Data
public class AnimalInventoryVO  {
    private AnimalInventory animalInventory;
    private int AnimalBornLogId;//记录id
    private String AnimalTypeName;//类型名称
    private int AnimalBornId;//动物id（自生产）
    private Date AnimalOutDate;//预计出库日期(自生产)
    private Date AnimalInDate;//生产日期or引进日
    private int AnimalBornCount;//生产个数（自生产）or引进个数
    private Timestamp AnimalInLogDate;//记录日期
    private int AnimalBornNum;//生产次数（自生产）
    private int AnimalInStatus;//状态
    private String AnimalNote;//疫苗记录
    private String AnimalFrom;//来源
    private int AnimalLastCount;//剩余个数
    public AnimalInventoryVO(AnimalInventory animalInventory) {
        this.animalInventory = animalInventory;
        AnimalBornLogId = animalInventory.getAnimalBornLogId();
        AnimalTypeName = animalInventory.getAnimalTypeName();
        AnimalBornId = animalInventory.getAnimalBornId();
        AnimalOutDate = animalInventory.getAnimalOutDate();
        AnimalInDate = animalInventory.getAnimalInDate();
        AnimalBornCount = animalInventory.getAnimalBornCount();
        AnimalInLogDate = animalInventory.getAnimalInLogDate();
        AnimalBornNum = animalInventory.getAnimalBornNum();
        AnimalInStatus = animalInventory.getAnimalInStatus();
        AnimalNote = animalInventory.getAnimalNote();
        AnimalFrom = animalInventory.getAnimalFrom();
        AnimalLastCount = animalInventory.getAnimalLastCount();
        AnimalInStatus=animalInventory.getAnimalInStatus();
    }
    public String getInfo(){
        Date today=new Date();
        String msg=null;
        if(AnimalInStatus==-1){
            return "没有库存";
        }
        if(AnimalOutDate==null){
            return "未设置出库时间";
        }
        if(AnimalOutDate.compareTo(today)<0){
            msg= "可出库";
        }
        else if(AnimalOutDate.compareTo(today)>=0){
            msg= "培育中";
        }
        return msg;
    }
}
