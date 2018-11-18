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

    @Modifying
    @Transactional
    @Query(value = "UPDATE animal_worker SET worker_name=?1,worker_tel=?2,worker_addr=?3,worker_wage=?4,worker_birth=?5,worker_note=?6 where worker_id=?7",nativeQuery = true)
    int editWorker(String workerName, String workerTel, String workerAddr, BigDecimal workerWage, Date workerBirth, String workerNote,Integer workerId);
    /*休假记录*/
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE animal_worker  SET animal_worker.worker_rest_note= CONCAT(?1,';',IFNULL(worker_rest_note,'')),worker_status=0 WHERE animal_worker.worker_id=?2 ")
    int offWorker(String workerRestNote, Integer workerId);
    /*复职*/
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE animal_worker SET worker_status=1 WHERE worker_id=?1")
    int reWorker(Integer workerId);
    /*结束休假*/
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE animal_worker SET worker_status=1 WHERE worker_id=?1")
    int noRestWorker(Integer workerId);
    /*查询休假记录*/
    @Query(nativeQuery = true,value = "select worker_rest_note from animal_worker where worker_id=?1")
    String findNoteById(Integer workerId);
}
