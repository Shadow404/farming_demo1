package com.wantaihao.farming_demo1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class AnimalBorn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalBornId;//id
    @Column(nullable = false)
    private String animalTypeName;//品种名称
    @Column(nullable = false)
    private int animalBornCount;//生产个数
    @Column()
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date animalSeedDate;//配种时间
    @Column()
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date animalBornDate;//生产时间or预计生产时间
    @Column(nullable = false,columnDefinition = "int default 1")
    private int animalBornStatus;//1。开始生育 1; 2.完成生育并加入库存 -1
    @Column(nullable = true)
    private String animalBornNote;//备注
    @Column(nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ")
    private Timestamp animalBornCreate;
    @Column(nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ")
    private Timestamp animalBornUpdate;
    @Column()
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date animalInDate;//引进时间
    @Column(nullable = false ,columnDefinition = "int default 1")//生产次数
    private int animalBornNum;

}
