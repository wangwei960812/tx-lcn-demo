package com.springcloud.tx;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDistributedTransaction
@MapperScan(basePackages = {"com.springcloud.db.txmanager.mapper"})
public class SpringDemoClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDemoClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
