package com.winterchen.dao;

import com.winterchen.model.Kline;

import java.util.List;
import java.util.Map;

public interface KlineMapper {
    int insert(Kline record);

    int insertSelective(Kline record);

    List<Kline> selectAllKlineData();

    List<Kline>  selectExistRecord(Map map);

    String  selectExistMaxRecord(Map<String,String> map);
}