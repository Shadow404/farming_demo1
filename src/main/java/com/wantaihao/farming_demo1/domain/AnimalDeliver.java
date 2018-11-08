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
    private int animalDeliverId;
    @Column(nullable = false)
    private String animalType;//类型
    @Column(nullable = false,scale = 1,precision = 10)
    private BigDecimal unitPrice;//单价
    @Column(precision = 11,scale = 0)
    private BigDecimal animalNum;//个数
    @Column(nullable = false)
    private int animalLogId;//库存号
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp deliverCreate;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transDate;
    @Column(nullable = false)
    private String buyerInfo;

}
