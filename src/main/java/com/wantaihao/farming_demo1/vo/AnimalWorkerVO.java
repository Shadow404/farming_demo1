package com.wantaihao.farming_demo1.vo;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AnimalWorkerVO {
    private Integer WorkerId;
    private String WorkerName;//姓名
    private String WorkerTel;//电话号码
    private Date WorkerBirth;//生日
    private String WorkerAddr;//工作地址
    private BigDecimal WorkerWage;//工资
    private int WorkerStatus;//状态 1 在职 2休假 -1离职
    private String WorkerNote;//备注
    private AnimalWorker animalWorker;

    public AnimalWorkerVO(AnimalWorker animalWorker) {
        WorkerId = animalWorker.getWorkerId();
        WorkerName = animalWorker.getWorkerName();
        WorkerTel = animalWorker.getWorkerTel();
        WorkerBirth = animalWorker.getWorkerBirth();
        WorkerAddr = animalWorker.getWorkerAddr();
        WorkerWage = animalWorker.getWorkerWage();
        WorkerStatus = animalWorker.getWorkerStatus();
        WorkerNote = animalWorker.getWorkerNote();
        this.animalWorker = animalWorker;
    }
    public String getAge(){
    Date today=new Date();
    int age=today.getYear()-WorkerBirth.getYear();
    Date birthday=new Date(today.getYear(),WorkerBirth.getMonth(),WorkerBirth.getDay());
    if(birthday.compareTo(today)>=0){
        age--;
    }
    return age+"岁";
    }
}
