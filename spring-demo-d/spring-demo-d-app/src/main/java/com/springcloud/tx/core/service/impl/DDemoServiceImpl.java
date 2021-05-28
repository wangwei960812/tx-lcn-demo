package com.springcloud.tx.core.service.impl;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.codingapi.txlcn.tc.core.DTXLocalContext;
import com.springcloud.db.txmanager.entities.TDemo;
import com.springcloud.db.txmanager.mapper.TDemoMapper;
import com.springcloud.tx.api.DDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class DDemoServiceImpl implements DDemoClient {

    private final TDemoMapper demoMapper;

    @Autowired
    public DDemoServiceImpl(TDemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
//    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @LcnTransaction
    @Transactional
    public String rpc(String value) {
        TDemo demo = new TDemo();
        demo.setCreateTime(new Date());
        demo.setDemoField(value);
        demo.setAppName(Transactions.APPLICATION_ID_WHEN_RUNNING);  // 应用名称
        demo.setGroupId(DTXLocalContext.getOrNew().getGroupId());   // DTXLocal
        demo.setUnitId(DTXLocalContext.getOrNew().getUnitId());
        demoMapper.insert(demo);
        return "ok-d";
    }
}
