package com.wantaihao.farming_demo1.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
@Data
@NoArgsConstructor
@Entity//入库表
public class AnimalInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AnimalBornLogId;//记录id
    @Column(nullable = false)
    private String AnimalTypeName;//类型名称
    @Column(nullable = true)
    private int AnimalBornId;//动物id（自生产）
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date AnimalOutDate;//预计出库日期(自生产)
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date AnimalInDate;//生产日期or引进日期
    @Column(nullable = false)
    private int AnimalBornCount;//生产个数（自生产）or引进个数
    @Column(columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ")
    private Timestamp AnimalInLogDate;//记录日期
    @Column
    private int AnimalBornNum;//生产次数（自生产）
    @Column(nullable = false,columnDefinition = "int default 1")//状态
    private int AnimalInStatus;
    @Column
    private String AnimalNote;//疫苗记录
    @Column(nullable = false)
    private String AnimalFrom;//来源
    @Column(nullable = false)
    private int AnimalLastCount;//剩余个数
}
