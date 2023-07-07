package com.example.asyncdemo;

import com.example.asyncdemo.bean.HaiLangBean;
import com.example.asyncdemo.bean.ZyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AsyncDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncDemoApplication.class, args);
    }

    @Bean(initMethod = "init")
    public HaiLangBean getLangBean() {
        return new HaiLangBean();
    }

    @Bean(initMethod = "init")
    public ZyBean getZyBean() {
        return new ZyBean();
    }
}
