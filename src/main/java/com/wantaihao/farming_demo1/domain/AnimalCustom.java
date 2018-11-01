package com.wantaihao.farming_demo1.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class AnimalCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CustomId;
    @Column(nullable = false)
    private int CustomType;//客户类型
    @Column(nullable = false)
    private String CustomName;//客户名称
    @Column(nullable = false)
    private String CustomPhone;//电话号码
    @Column(nullable = false)
    private String CustomAddr;//地址
    @Column(nullable = false)
    private String CustomMail;//电子邮箱
    @Column(nullable = false ,columnDefinition = "int default 1")
    private int CustomStatus;
    @Column(columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP",nullable = false)
    private Timestamp CustomCreate;
    @Column(columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP",nullable = false)
    private Timestamp CustomUpdate;


}
