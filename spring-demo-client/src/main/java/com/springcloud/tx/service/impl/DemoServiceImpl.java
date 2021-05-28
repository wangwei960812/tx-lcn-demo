package com.springcloud.tx.service.impl;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.core.DTXLocalContext;
import com.springcloud.db.txmanager.entities.TDemo;
import com.springcloud.db.txmanager.mapper.TDemoMapper;
import com.springcloud.tx.EDemoClient;
import com.springcloud.tx.api.DDemoClient;
import com.springcloud.tx.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class DemoServiceImpl implements DemoService {

    private final TDemoMapper tDemoMapper;

    private final DDemoClient dDemoClient;

    private final EDemoClient eDemoClient;

    @Autowired
    public DemoServiceImpl(TDemoMapper tDemoMapper, DDemoClient dDemoClient, EDemoClient eDemoClient) {
        this.tDemoMapper = tDemoMapper;
        this.dDemoClient = dDemoClient;
        this.eDemoClient = eDemoClient;
    }

    @Override
    @LcnTransaction
    @Transactional
    public String execute(String value) {

        // ServiceD
        String dResp = dDemoClient.rpc(value);

        // ServiceE
//        String eResp = eDemoClient.rpc(value);

        // local transaction
        TDemo demo = new TDemo();
        demo.setDemoField(value);
        demo.setAppName(Transactions.APPLICATION_ID_WHEN_RUNNING); // 应用名称
        demo.setCreateTime(new Date());
        demo.setGroupId(DTXLocalContext.getOrNew().getGroupId());  // DTXLocal
        demo.setUnitId(DTXLocalContext.getOrNew().getUnitId());
        tDemoMapper.insert(demo);

        // 手动异常，DTX B回滚
        int i = 1 / 0;
//        return dResp + " > " + eResp + " > " + "ok-client";
        return dResp + " > " + "ok-client";
    }
}
