package com.wantaihao.farming_demo1;

import com.wantaihao.farming_demo1.domain.AnimalInventory;
import com.wantaihao.farming_demo1.repository.AnimalInventoryRepository;
import com.wantaihao.farming_demo1.vo.AnimalInventoryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)

public class Test {
    @Autowired
    private AnimalInventoryRepository repository;
    @org.junit.Test
    public void info(){
        AnimalInventory animalInventory=repository.findOne(3);
        AnimalInventoryVO vo=new AnimalInventoryVO(animalInventory);
        String msg=vo.getInfo();
        log.info("{} msg",msg);
    }
}
