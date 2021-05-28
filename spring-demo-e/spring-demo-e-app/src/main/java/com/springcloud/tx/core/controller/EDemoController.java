package com.springcloud.tx.core.controller;

import com.springcloud.tx.EDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EDemoController {

    private final EDemoClient eDemoClient;

    @Autowired
    public EDemoController(EDemoClient eDemoClient) {
        this.eDemoClient = eDemoClient;
    }

    @RequestMapping("/edemo/rpc")
    public String rpc(@RequestParam("value") String value) {
        return  eDemoClient.rpc(value);
    }

}
