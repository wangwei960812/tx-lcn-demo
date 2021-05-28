package com.springcloud.tx.service.impl;

import com.springcloud.tx.EDemoClient;
import com.springcloud.tx.service.abs.BaseService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EDemoClientImpl  extends BaseService implements EDemoClient {

    private final static String E_URL = "http://127.0.0.1:8005";

    @Override
    public String rpc(String value) {
        Map<String, Object> params = new HashMap<>();
        params.put("value",value);
        ResponseEntity<String> exchange = restTemplate.exchange(E_URL + "/edemo/rpc?value={value}", HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), String.class, params);
        return exchange.getBody();    }
}
