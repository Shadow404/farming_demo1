package com.wantaihao.farming_demo1.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class AnimalCustom {
    private Integer CustomId;
    private int CustomType;//客户类型
    private String CustomName;//客户名称

}
