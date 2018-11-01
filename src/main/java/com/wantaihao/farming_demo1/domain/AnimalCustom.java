package com.wantaihao.farming_demo1.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

}
