package com.wantaihao.farming_demo1.service;

import com.wantaihao.farming_demo1.domain.AnimalCustom;

import java.util.List;
import java.util.Map;

public interface AnimalCustomService {
    /*显示所有供应商信息*/
    List<AnimalCustom> findAllProvider();
    /*添加供应商到数据库*/
    String addProvider(AnimalCustom animalCustom);
    /*显示所有收购商信息*/
    List<AnimalCustom> findAllBuyer();
    /*添加供应商到数据库*/
    String addBuyer(AnimalCustom animalCustom);
    /*删除客户*/
    Map delCustom(Integer customId);
    /*编辑客户信息*/
    String editProvider(AnimalCustom animalCustom,String originName);
    /*查找需要编辑的客户信息*/
    AnimalCustom findProvider(Integer customId);
    /*查询收购商信息*/
    AnimalCustom findBuyer(Integer customId);
    /*修改收购商信息*/
    String editBuyer(AnimalCustom animalCustom);
}
