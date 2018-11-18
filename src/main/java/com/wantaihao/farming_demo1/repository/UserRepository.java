package com.wantaihao.farming_demo1.repository;

import com.wantaihao.farming_demo1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    /*查询用户信息*/
    User findByUserName(String userName);
}
