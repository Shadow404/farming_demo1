package com.wantaihao.farming_demo1.vo;


import com.wantaihao.farming_demo1.domain.AnimalDeliver;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class AnimalDeliverVO {
    private AnimalDeliver animalDeliver;
    private int AnimalDeliverId;
    private String AnimalType;//类型
    private BigDecimal UnitPrice;//单价
    private BigDecimal AnimalNum;//个数
    private int AnimalLogId;//库存号
    private Date TransDate;
    private String BuyerInfo;
    public AnimalDeliverVO(AnimalDeliver animalDeliver) {
        this.animalDeliver = animalDeliver;
        AnimalDeliverId = animalDeliver.getAnimalDeliverId();
        AnimalType = animalDeliver.getAnimalType();
        UnitPrice = animalDeliver.getUnitPrice();
        AnimalNum = animalDeliver.getAnimalNum();
        AnimalLogId = animalDeliver.getAnimalLogId();
        TransDate = animalDeliver.getTransDate();
        BuyerInfo = animalDeliver.getBuyerInfo();
    }
    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice=UnitPrice.multiply(AnimalNum);
        return totalPrice;
    }



}
