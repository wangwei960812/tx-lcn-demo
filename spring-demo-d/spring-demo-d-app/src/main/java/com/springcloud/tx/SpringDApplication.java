package com.springcloud.tx;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
@MapperScan(basePackages = {"com.springcloud.db.txmanager.mapper"})
public class SpringDApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDApplication.class, args);
    }
}
