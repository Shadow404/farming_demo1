package com.wantaihao.farming_demo1.repository;

import com.wantaihao.farming_demo1.domain.AnimalDeliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface AnimalDeliverRepository extends JpaRepository<AnimalDeliver ,Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO animal_deliver (animal_deliver.animal_type,\tanimal_deliver.unit_price,animal_deliver.animal_num,animal_deliver.animal_log_id,animal_deliver.trans_date,animal_deliver.buyer_info)VALUES (?1,?2,?3,?4,?5,?6)")
    int addDeliver(String animalType, BigDecimal unitPrice, BigDecimal animalNum, int animalLogId, Date transDate, String buyerInfo);
}
