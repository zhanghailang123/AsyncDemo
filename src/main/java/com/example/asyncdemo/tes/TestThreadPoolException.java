package com.example.asyncdemo.tes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author hailang.zhang
 * @since 2023-07-07
 */
public class TestThreadPoolException {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<Integer> future = executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "执行异步线程中");

            System.out.println(1/0);
            return 11111;
        });

        executor.execute(() -> {

            System.out.println(1/0);
        });

//        try {
//            Integer integer = future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        CompletableFuture.runAsync(() -> {
            System.out.println("使用CompletableFuture 测试下异常");
            System.out.println(1/0);
        });
    }
}