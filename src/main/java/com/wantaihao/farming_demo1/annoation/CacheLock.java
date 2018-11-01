package com.wantaihao.farming_demo1.annoation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/*
* 分布式锁
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {
    String prefix() default "";//redis锁前缀
    int expire() default 5;//轮询锁时间
    TimeUnit timeUnit() default  TimeUnit.SECONDS;//超时单位：秒
    String delimiter() default ":";//key分隔符

}
