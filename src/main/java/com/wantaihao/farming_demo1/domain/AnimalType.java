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
    private int animalTypeId;
    @Column(nullable = false)
    private String animalTypeName;
    @Column(nullable = false)
    private String animalTypeFrom;
    @Column(updatable = false,nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP")
    private Timestamp animalTypeCreate;
    @Column(nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ")
    private Timestamp animalTypeUpdate;
    @Column(nullable = false,columnDefinition = "int default 1")
    private int animalTypeStatus;
    public AnimalType(){


    }

}
