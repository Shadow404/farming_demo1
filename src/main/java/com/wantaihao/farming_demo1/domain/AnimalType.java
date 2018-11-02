package com.wantaihao.farming_demo1.domain;

import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity

public class AnimalType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int AnimalTypeId;
    @Column(nullable = false)
    private String AnimalTypeName;
    @Column(nullable = false)
    private String animalTypeFrom;
    @Column(updatable = false,nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP")
    private Timestamp AnimalTypeCreate;
    @Column(nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ")
    private Timestamp AnimalTypeUpdate;
    @Column(nullable = false,columnDefinition = "int default 1")
    private int AnimalTypeStatus;
    public AnimalType(){


    }

}
