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
    private int animalBornLogId;//记录id
    @Column(nullable = false)
    private String animalTypeName;//类型名称
    @Column(nullable = true)
    private int animalBornId;//动物id（自生产）
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date animalOutDate;//预计出库日期(自生产)
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date animalInDate;//生产日期or引进日期
    @Column(nullable = false)
    private int animalBornCount;//生产个数（自生产）or引进个数
    @Column(columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ")
    private Timestamp animalInLogDate;//记录日期
    @Column
    private int animalBornNum;//生产次数（自生产）
    @Column(nullable = false,columnDefinition = "int default 1")//状态
    private int animalInStatus;
    @Column
    private String animalNote;//疫苗记录
    @Column(nullable = false)
    private String animalFrom;//来源
    @Column(nullable = false)
    private int animalLastCount;//剩余个数
}
