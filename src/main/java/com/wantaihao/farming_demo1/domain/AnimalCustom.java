package com.wantaihao.farming_demo1.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class AnimalCustom {
    private Integer CustomId;
    private int CustomType;//客户类型
    private String CustomName;//客户名称

}
