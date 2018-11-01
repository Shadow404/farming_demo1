package com.wantaihao.farming_demo1.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

public interface CacheKeyGenerator {
    String getLockKey(ProceedingJoinPoint pjp);
}
