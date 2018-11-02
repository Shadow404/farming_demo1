package com.wantaihao.farming_demo1.repository;

import com.wantaihao.farming_demo1.domain.AnimalType;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public interface AnimalTypeRepository extends JpaRepository<AnimalType,Integer> {
     Page<AnimalType> findByAnimalTypeName(Pageable pageable);
     @Modifying
     @Transactional
     @Query(value = "INSERT INTO animal_type (animal_type.animal_type_name,animal_type.animal_type_from) VALUES(?1,?2)",nativeQuery = true)
     int addType(String animalTypeName,String animalTypeFrom);
     @Modifying
     @Transactional
     @Query(value = "DELETE FROM animal_type WHERE animal_type.animal_type_id=?1",nativeQuery = true)
     int delType(int animalTypeId);

     @Query(value = "SELECT * FROM animal_type  where animal_type_id=?1",nativeQuery = true)
     Map<String,Object> findById(int animalTypeId);
     @Modifying
     @Transactional
     @Query(value = "UPDATE animal_type SET animal_type_from=?2 , animal_type_name=?1 WHERE animal_type_id=?3",nativeQuery = true)
     int editType(String aniamlTypeName,String animalTypeFrom,int animalTypeId);
     @Modifying
     @Transactional
     @Query(value = "UPDATE animal_type SET animal_type_status=?2 WHERE animal_type_id=?1",nativeQuery = true)
     int changeTypeStatus(int animalTypeId,int aniamlTypeStatus);
     @Query(value = "SELECT custom_name FROM animal_custom WHERE custom_type=1",nativeQuery = true)
     List<String> findProvider();
}
