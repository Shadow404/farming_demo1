package com.wantaihao.farming_demo1.repository;

import com.wantaihao.farming_demo1.domain.AnimalCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalCustomRepository extends JpaRepository<AnimalCustom,Integer> {
}
