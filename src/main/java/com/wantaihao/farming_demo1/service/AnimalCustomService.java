package com.wantaihao.farming_demo1.service;

import com.wantaihao.farming_demo1.domain.AnimalCustom;

import java.util.List;

public interface AnimalCustomService {
    /*显示所有供应商信息*/
    List<AnimalCustom> findAllProvider();
    /*添加供应商到数据库*/
    String addProvider(AnimalCustom animalCustom);
    /*显示所有收购商信息*/
    List<AnimalCustom> findAllBuyer();
    /*添加供应商到数据库*/
    String addBuyer(AnimalCustom animalCustom);
}
