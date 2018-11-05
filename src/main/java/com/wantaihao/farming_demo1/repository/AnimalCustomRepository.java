package com.wantaihao.farming_demo1.repository;

import com.wantaihao.farming_demo1.domain.AnimalCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AnimalCustomRepository extends JpaRepository<AnimalCustom,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM animal_custom WHERE custom_type=?1 and custom_status>0")
    List<AnimalCustom> findByType(int customType);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO animal_custom (animal_custom.custom_name,animal_custom.custom_phone,animal_custom.custom_addr,animal_custom.custom_mail,animal_custom.custom_type) values (?1,?2,?3,?4,?5)")
    int add(String customName,String customTel,String customAddr,String customMail,int customType);
    @Modifying
    @Transactional
    @Query(value = " UPDATE animal_custom SET custom_status='-1' WHERE custom_id=?1",nativeQuery = true)
    int delCustom(Integer customId);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE animal_custom SET animal_custom.custom_name=?1,animal_custom.custom_phone=?2,animal_custom.custom_addr=?3,animal_custom.custom_mail=?4 WHERE custom_id=?5")
    int editCustom(String customName, String customTel, String customAddr, String customMail, Integer customId);
    @Query(nativeQuery = true,value = "select * from animal_custom where custom_id=?1 and custom_type=1")
    AnimalCustom findProvider(Integer customId);
    @Query(nativeQuery = true,value = "select * from animal_custom where custom_id=?1 and custom_type=2")
    AnimalCustom findBuyer(Integer customId);
}
