package com.example.asyncdemo.bean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author hailang.zhang
 * @since 2023-07-05
 */
@Slf4j
public class HaiLangBean {

    public void init() throws InterruptedException {
        log.info("hailang Bean start, : {}", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        log.info("hailang Bean stop, : {}", Thread.currentThread().getName());
    }
}