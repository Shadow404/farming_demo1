package com.wantaihao.farming_demo1.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class AnimalDeliver {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int AnimalDeliverId;
    @Column(nullable = false)
    private String AnimalType;//类型
    @Column(nullable = false,scale = 1,precision = 10)
    private BigDecimal UnitPrice;//单价
    @Column(precision = 11,scale = 0)
    private BigDecimal AnimalNum;//个数
    @Column(nullable = false)
    private int AnimalLogId;//库存号
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp DeliverCreate;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date TransDate;
    @Column(nullable = false)
    private String BuyerInfo;

}
