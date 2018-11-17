package com.wantaihao.farming_demo1.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class AnimalWorker {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer workerId;
    @Column(nullable = false)
    private String workerName;//姓名
    @Column(nullable = false)
    private String workerTel;//电话号码
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date workerBirth;//生日
    @Column(nullable = false)
    private String workerAddr;//工作地址
    @Column(nullable = false,scale = 1,precision = 10)
    private BigDecimal workerWage;//工资
    @Column(nullable = false,columnDefinition = "int default 1")
    private int workerStatus;//状态 1 在职 0休假 -1离职
    @Column
    private String workerNote;//备注
    /*休假记录*/
    @Column
    private String workerRestNote;

}
