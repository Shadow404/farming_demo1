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
    private Integer customId;
    @Column(nullable = false)
    private int customType;//客户类型
    @Column(nullable = false)
    private String customName;//客户名称
    @Column(nullable = false)
    private String customPhone;//电话号码
    @Column(nullable = false)
    private String customAddr;//地址
    @Column(nullable = false)
    private String customMail;//电子邮箱
    @Column(nullable = false ,columnDefinition = "int default 1")
    private int customStatus;
    @Column(columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP",nullable = false)
    private Timestamp customCreate;
    @Column(columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP",nullable = false)
    private Timestamp customUpdate;


}
