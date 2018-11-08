package com.wantaihao.farming_demo1.vo;


import com.wantaihao.farming_demo1.domain.AnimalDeliver;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
@Data
public class AnimalDeliverVO {
    private AnimalDeliver animalDeliver;
    private int animalDeliverId;
    private String animalType;//类型
    private BigDecimal unitPrice;//单价
    private BigDecimal animalNum;//个数
    private int animalLogId;//库存号
    private Date transDate;
    private String buyerInfo;
    public AnimalDeliverVO(AnimalDeliver animalDeliver) {
        this.animalDeliver = animalDeliver;
        animalDeliverId = animalDeliver.getAnimalDeliverId();
        animalType = animalDeliver.getAnimalType();
        unitPrice = animalDeliver.getUnitPrice();
        animalNum = animalDeliver.getAnimalNum();
        animalLogId = animalDeliver.getAnimalLogId();
        transDate = animalDeliver.getTransDate();
        buyerInfo = animalDeliver.getBuyerInfo();
    }
    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice=unitPrice.multiply(animalNum);
        return totalPrice;
    }



}
