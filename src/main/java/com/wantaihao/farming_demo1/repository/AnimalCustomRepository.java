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
    @Query(nativeQuery = true,value = "SELECT * FROM animal_custom WHERE custom_type=?1")
    List<AnimalCustom> findByType(int customType);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO animal_custom (animal_custom.custom_name,animal_custom.custom_phone,animal_custom.custom_addr,animal_custom.custom_mail,animal_custom.custom_type) values (?1,?2,?3,?4,'1')")
    int add(String customName,String customTel,String customAddr,String customMail);
}
