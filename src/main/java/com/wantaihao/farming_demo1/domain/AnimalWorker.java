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
    private Integer WorkerId;
    @Column(nullable = false)
    private String WorkerName;//姓名
    @Column(nullable = false)
    private String WorkerTel;//电话号码
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date WorkerBirth;//生日
    @Column(nullable = false)
    private String WorkerAddr;//工作地址
    @Column(nullable = false,scale = 1)
    private BigDecimal WorkerWage;//工资
    @Column(nullable = false,columnDefinition = "int default 1")
    private int WorkerStatus;//状态 1 在职 2休假 -1离职
    @Column
    private String WorkerNote;//备注

}
