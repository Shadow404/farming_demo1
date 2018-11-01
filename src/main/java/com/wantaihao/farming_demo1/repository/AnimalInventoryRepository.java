package com.wantaihao.farming_demo1.repository;

import com.wantaihao.farming_demo1.domain.AnimalInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AnimalInventoryRepository extends JpaRepository<AnimalInventory,Integer> {

    @Query(nativeQuery = true,value = "select * from animal_inventory where animal_born_id=?1")
    List<AnimalInventory> findAllById(int id);
    @Query(nativeQuery = true,value = "SELECT * FROM animal_inventory WHERE animal_born_log_id=?1")
    AnimalInventory findOne(int logId);
    @Query(nativeQuery = true,value = "SELECT animal_type.animal_type_name FROM animal_type where animal_type_status =1")
    List<String> findType();
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO animal_inventory (animal_inventory.animal_type_name,animal_inventory.animal_born_count,animal_inventory.animal_last_count,animal_inventory.animal_in_date,animal_inventory.animal_out_date,animal_inventory.animal_from,animal_inventory.animal_born_id,animal_inventory.animal_born_count) values (?1,?2,?2,?3,?4,?5,'-1','-1')")
    int addInventory(String animalTypeName, int animalBornCount, Date animalInDate, Date animalOutDate, String animalFrom);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE animal_inventory SET animal_born_count=?1,animal_last_count=?2,animal_from=?3,animal_in_date=?4,animal_out_date=?5,animal_note=?6 WHERE animal_born_log_id=?7")
    int editInventory(int animalBornCount, int animalLastCount, String animalFrom, Date animalInDate, Date animalOutDate, String animalNote, int animalBornLogId);
    @Modifying
    @Transactional
    @Query(nativeQuery =true,value = "DELETE FROM animal_inventory WHERE animal_inventory.animal_born_log_id=?1")
    int deleteById(int animalBornLogId);
    @Modifying
    @Transactional
    @Query(nativeQuery =true,value = "update  animal_inventory set animal_last_count =animal_last_count-?2 WHERE animal_inventory.animal_born_log_id=?1")
    int delCount(int animalLogId, BigDecimal animalNum);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE animal_inventory SET animal_in_status=-1 WHERE animal_last_count=0")
    void cleanStatus();
}
