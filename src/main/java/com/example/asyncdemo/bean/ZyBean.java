package com.example.asyncdemo.bean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author hailang.zhang
 * @since 2023-07-05
 */
@Slf4j
public class ZyBean {

    public void init() throws Exception {
        log.info("zyBean start, :{}", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        log.info("zyBean stop, :{}", Thread.currentThread().getName());
    }
}