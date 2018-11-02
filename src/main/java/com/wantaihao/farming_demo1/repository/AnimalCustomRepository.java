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
    @Query(nativeQuery = true,value = "SELECT * FROM animal_custom WHERE custom_type=1")
    List<AnimalCustom> findByType();
    @Modifying
    @Transactional
    int add(AnimalCustom animalCustom);
}
