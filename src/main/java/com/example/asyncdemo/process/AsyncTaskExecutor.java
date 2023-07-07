package com.example.asyncdemo.process;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hailang.zhang
 * @since 2023-07-05
 */
public class AsyncTaskExecutor {
    //需要一个专门用来异步加载的线程池
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final AtomicReference<ThreadPoolExecutor> THREAD_POOL_EXECUTOR_ATOMIC_REFERENCE = new AtomicReference<ThreadPoolExecutor>();
    private static final List<Future> FUTURES = new ArrayList<Future>();

    public static Future submitTask(Runnable runnable) {
        if (THREAD_POOL_EXECUTOR_ATOMIC_REFERENCE.get() == null) {
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
            boolean success = THREAD_POOL_EXECUTOR_ATOMIC_REFERENCE.compareAndSet(null, executor);
            if (!success) {
                executor.shutdown();
            }
        }
        Future future = THREAD_POOL_EXECUTOR_ATOMIC_REFERENCE.get().submit(runnable);
        FUTURES.add(future);
        return future;
    }

    public static void ensureAsyncTasksFinish() {
        for (Future future : FUTURES) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        FUTURES.clear();

        if (THREAD_POOL_EXECUTOR_ATOMIC_REFERENCE.get() != null) {
            THREAD_POOL_EXECUTOR_ATOMIC_REFERENCE.get().shutdown();
            THREAD_POOL_EXECUTOR_ATOMIC_REFERENCE.set(null);
        }
    }
}