package com.example.asyncdemo.bean;

import com.example.asyncdemo.process.AsyncTaskExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author hailang.zhang
 * @since 2023-07-05
 */
@Slf4j
public class ZyBean {

    public void init() throws Exception {
        AsyncTaskExecutor.submitTask(() -> {
            log.info("zyBean start, :{}", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("zyBean stop, :{}", Thread.currentThread().getName());
        });
    }
}