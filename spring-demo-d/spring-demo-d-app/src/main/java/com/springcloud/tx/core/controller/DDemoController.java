package com.springcloud.tx.core.controller;

import com.springcloud.tx.api.DDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DDemoController {

    private final DDemoClient dDemoClient;

    @Autowired
    public DDemoController(DDemoClient dDemoClient) {
        this.dDemoClient = dDemoClient;
    }

    @RequestMapping("/ddemo/rpc")
    public String rpc(@RequestParam("value") String value) {
        return  dDemoClient.rpc(value);
    }

}
