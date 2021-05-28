package com.springcloud.tx.core.service.impl;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.codingapi.txlcn.tc.core.DTXLocalContext;
import com.springcloud.db.txmanager.entities.TDemo;
import com.springcloud.db.txmanager.mapper.TDemoMapper;
import com.springcloud.tx.EDemoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class EDemoServiceImpl implements EDemoClient {

    private final TDemoMapper demoMapper;

    private ConcurrentHashMap<String, Long> ids = new ConcurrentHashMap<>();

    @Autowired
    public EDemoServiceImpl(TDemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
//    @TccTransaction(propagation = DTXPropagation.SUPPORTS)
    @LcnTransaction
    @Transactional
    public String rpc(String value) {
        TDemo demo = new TDemo();
        demo.setDemoField(value);
        demo.setCreateTime(new Date());
        demo.setAppName(Transactions.APPLICATION_ID_WHEN_RUNNING);
        demo.setGroupId(DTXLocalContext.getOrNew().getGroupId());
        demo.setUnitId(DTXLocalContext.getOrNew().getUnitId());
        demoMapper.insert(demo);
//        ids.put(DTXLocalContext.getOrNew().getGroupId(), demo.getId());
        return "ok-e";
    }

    public void confirmRpc(String value) {
        log.info("tcc-confirm-" + DTXLocalContext.getOrNew().getGroupId());
        ids.remove(DTXLocalContext.getOrNew().getGroupId());
    }

    public void cancelRpc(String value) {
        log.info("tcc-cancel-" + DTXLocalContext.getOrNew().getGroupId());
        Long kid = ids.get(DTXLocalContext.getOrNew().getGroupId());
        demoMapper.deleteByPrimaryKey(kid);
    }
}
