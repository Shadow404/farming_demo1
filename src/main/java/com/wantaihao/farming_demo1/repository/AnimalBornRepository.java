package com.wantaihao.farming_demo1.repository;


import com.wantaihao.farming_demo1.domain.AnimalBorn;
import com.wantaihao.farming_demo1.domain.AnimalInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface AnimalBornRepository extends JpaRepository<AnimalBorn,Integer> {
    @Query(value = "SELECT * FROM animal_born WHERE animal_born_id=?1 ",nativeQuery = true)
    AnimalBorn findOne(int AnimalBornId);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO animal_born (animal_born.animal_type_name,animal_born.animal_born_count,animal_born.animal_seed_date,animal_born.animal_born_date,animal_born.animal_in_date)VALUES(?1,?2,?3,?4,?5) ")
    int add(String animalTypeName, int animalBornCount, Date animalSeedDate,Date animalBornDate,Date animalInDate);
    @Query(nativeQuery = true,value = "SELECT animal_type.animal_type_name FROM animal_type where animal_type_status =1")
    List<String> findAnimalList();
    @Query(nativeQuery = true,value = "select * from animal_born where animal_born_id=?1")
    AnimalBorn editBorn(int animalBornId);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE animal_born set animal_born_count=?1,animal_seed_date=?2,animal_born_date=?3,animal_in_date=?4,animal_born_note=?5 WHERE animal_born_id=?6")
    int doEditBorn(int animalBornCount, Date animalSeedDate, Date animalBornDate, Date animalInDate, String animalBornNote, int animalBornId);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE animal_born SET animal_born_count = 0,animal_born_status = ?2, animal_born_note=null, animal_seed_date=null, animal_born_date=null WHERE animal_born_id = ?1 ")
    int comp(int animalBornId, int animalBornStatus);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO animal_inventory ( animal_inventory.animal_type_name,animal_inventory.animal_born_count,animal_inventory.animal_born_num, animal_inventory.animal_in_date, animal_inventory.animal_note, animal_inventory.animal_born_id,animal_inventory.animal_from,animal_last_count) VALUES (?6,?2,?4,?3,?5,?1,'自生产',?2)")
    int log(int animalBornId, int animalBornCount, Date animalBornDate, int animalBornNum, String animalNote, String animalTypeName);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE animal_born SET animal_born_status=0 WHERE animal_born_id=?1")
    int unlock(int animalBornId);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE animal_born SET animal_born_count=?1,animal_seed_date=?2,animal_born_date=?3,animal_born_status=1,animal_born_num=animal_born_num+1 WHERE animal_born_id=?4")
    int newBorn(int animalBornCount, Date animalSeedDate, Date animalBornDate, int animalBornId);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "delete from animal_born where animal_born_id=?1")
    int delBron(int animalBornId);
}
