package com.wantaihao.farming_demo1;

import com.wantaihao.farming_demo1.interceptor.CacheKeyGenerator;
import com.wantaihao.farming_demo1.interceptor.LockKeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FarmingDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(FarmingDemo1Application.class, args);
    }
    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LockKeyGenerator();
    }
}
