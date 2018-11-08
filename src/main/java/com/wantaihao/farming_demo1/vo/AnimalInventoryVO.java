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
    private int animalBornLogId;//记录id
    private String animalTypeName;//类型名称
    private int animalBornId;//动物id（自生产）
    private Date animalOutDate;//预计出库日期(自生产)
    private Date animalInDate;//生产日期or引进日
    private int animalBornCount;//生产个数（自生产）or引进个数
    private Timestamp animalInLogDate;//记录日期
    private int animalBornNum;//生产次数（自生产）
    private int animalInStatus;//状态
    private String animalNote;//疫苗记录
    private String animalFrom;//来源
    private int animalLastCount;//剩余个数
    public AnimalInventoryVO(AnimalInventory animalInventory) {
        this.animalInventory = animalInventory;
        animalBornLogId = animalInventory.getAnimalBornLogId();
        animalTypeName = animalInventory.getAnimalTypeName();
        animalBornId = animalInventory.getAnimalBornId();
        animalOutDate = animalInventory.getAnimalOutDate();
        animalInDate = animalInventory.getAnimalInDate();
        animalBornCount = animalInventory.getAnimalBornCount();
        animalInLogDate = animalInventory.getAnimalInLogDate();
        animalBornNum = animalInventory.getAnimalBornNum();
        animalInStatus = animalInventory.getAnimalInStatus();
        animalNote = animalInventory.getAnimalNote();
        animalFrom = animalInventory.getAnimalFrom();
        animalLastCount = animalInventory.getAnimalLastCount();
        animalInStatus=animalInventory.getAnimalInStatus();
    }
    public String getInfo(){
        Date today=new Date();
        String msg=null;
        if(animalInStatus==-1){
            return "没有库存";
        }
        if(animalOutDate==null){
            return "未设置出库时间";
        }
        if(animalOutDate.compareTo(today)<0){
            msg= "可出库";
        }
        else if(animalOutDate.compareTo(today)>=0){
            msg= "培育中";
        }
        return msg;
    }
}
