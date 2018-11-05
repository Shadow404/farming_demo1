package com.wantaihao.farming_demo1.repository;

import com.wantaihao.farming_demo1.domain.AnimalWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface AnimalWorkerRepository extends JpaRepository<AnimalWorker,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM animal_worker ORDER BY worker_status DESC")
    List<AnimalWorker> findAll();
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO animal_worker (worker_name,worker_tel,worker_addr,worker_wage,worker_birth,worker_note) values (?1,?2,?3,?4,?5,?6)")
    int addWorker(String workerName, String workerTel, String workerAddr, BigDecimal workerWage, Date workerBirth, String workerNote);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE animal_worker set worker_status ='-1' where worker_id=?1")
    int delWorker(Integer workerId);
}
