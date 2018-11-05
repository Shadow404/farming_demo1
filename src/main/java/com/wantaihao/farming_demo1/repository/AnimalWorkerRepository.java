package com.wantaihao.farming_demo1.repository;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalWorkerRepository extends JpaRepository<AnimalWorker,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM animal_worker ORDER BY worker_status DESC")
    List<AnimalWorker> findAll();
}
