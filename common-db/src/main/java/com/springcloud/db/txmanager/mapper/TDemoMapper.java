package com.springcloud.db.txmanager.mapper;

import com.springcloud.db.txmanager.entities.TDemo;
import com.springcloud.db.txmanager.entities.TDemoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDemoMapper {
    int countByExample(TDemoExample example);

    int deleteByExample(TDemoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDemo record);

    int insertSelective(TDemo record);

    List<TDemo> selectByExample(TDemoExample example);

    TDemo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDemo record, @Param("example") TDemoExample example);

    int updateByExample(@Param("record") TDemo record, @Param("example") TDemoExample example);

    int updateByPrimaryKeySelective(TDemo record);

    int updateByPrimaryKey(TDemo record);
}