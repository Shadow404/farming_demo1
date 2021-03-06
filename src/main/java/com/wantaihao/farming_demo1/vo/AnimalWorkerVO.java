package com.wantaihao.farming_demo1.vo;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Data
public class AnimalWorkerVO {
    private Integer workerId;
    private String workerName;//姓名
    private String workerTel;//电话号码
    private Date workerBirth;//生日
    private String workerAddr;//工作地址
    private BigDecimal workerWage;//工资
    private int workerStatus;//状态 1 在职 2休假 -1离职
    private String workerNote;//备注
    private AnimalWorker animalWorker;
    private String workerRestNote;
    public AnimalWorkerVO(AnimalWorker animalWorker) {
        workerId = animalWorker.getWorkerId();
        workerName = animalWorker.getWorkerName();
        workerTel = animalWorker.getWorkerTel();
        workerBirth = animalWorker.getWorkerBirth();
        workerAddr = animalWorker.getWorkerAddr();
        workerWage = animalWorker.getWorkerWage();
        workerStatus = animalWorker.getWorkerStatus();
        workerNote = animalWorker.getWorkerNote();
        this.animalWorker = animalWorker;
        workerRestNote=animalWorker.getWorkerRestNote();
    }
    public String getAge(){
        Date today=new  Date();
        int age=today.getYear()-workerBirth.getYear();
        Date birthday= new Date(today.getYear(),workerBirth.getMonth(),workerBirth.getDate());
        if(birthday.compareTo(today)>=0){
            age--;
        }
        return age+"岁";
        }
}
