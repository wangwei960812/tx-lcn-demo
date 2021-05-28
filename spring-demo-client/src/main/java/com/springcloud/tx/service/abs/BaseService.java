package com.springcloud.tx.service.abs;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class BaseService {

    @Resource
    protected RestTemplate restTemplate;

    public BaseService() {
    }
}
