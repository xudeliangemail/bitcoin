package com.winterchen.service.user.impl;

import com.winterchen.dao.KlineMapper;
import com.winterchen.model.Kline;
import com.winterchen.service.user.KlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "KlineService")
public class KlineServiceImpl implements KlineService {

    @Autowired
    private KlineMapper klineMapper;//这里会报错，但是并不会影响


    @Override
    public List<Kline>  getKline() {

        List<Kline> list = klineMapper.selectAllKlineData();

//数据模型 time0 open1 close2 min3 max4 vol5 tag6 macd7 dif8 dea9
//['2015-10-19',18.56,18.25,18.19,18.56,55.00,0,-0.00,0.08,0.09]






        return  list;
    }
}
