package com.example.asyncdemo.process;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * @author hailang.zhang
 * @since 2023-07-05
 */
public class AsyncTaskExecutionListener implements ApplicationContextAware, PriorityOrdered, ApplicationListener<ContextRefreshedEvent> {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}