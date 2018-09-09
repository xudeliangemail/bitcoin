package com.winterchen.thread;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.money.util.DateUtil;
import com.money.util.HttpUtil;
import com.winterchen.dao.KlineMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@EnableScheduling
public class DealThreadUpdateTask {

    @Autowired
    private KlineMapper klineMapper;//这里会报错，但是并不会影响

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Scheduled(fixedDelayString = "2000")
    public void getTask() {



        String  sql =" insert into kline (symbol, open, high, low, end, tradeSize, time,rate,timeformat)values(?,?,?,?,?,?,?,?,?)";
        //ETH,ETC,
        String names = "ETH,ETC,LTC,EOS,BCH,QTUM,NEO,XUC";
        String[] rates = "1min/3min/5min/15min/30min/1day/3day/1week/1hour/2hour/4hour/6hour/12hour".split("/");
        names = names.toLowerCase();
        String[] nameStrs = names.split(",");

        for (String coinName : nameStrs) {
            for (String rate : rates) {
                String url = "https://www.okex.com/api/v1/kline.do?symbol=" + coinName + "_btc&type=" + rate;
                System.out.println(url);
                String data ="";
                for(int x=0;x<3;x++){
                    data = HttpUtil.doGetByShadowsock(url);
                    if(StringUtils.isBlank(data)||data.length()<21){
                        try {
                            Thread.currentThread().sleep(2000);
                        }catch (Exception e){

                        }
                        continue;
                    }else{
                        break;
                    }
                }
                if(StringUtils.isBlank(data)||data.length()<21){
                    continue;
                }

                List<Object[]> batchArgs=new ArrayList<Object[]>();
                JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();


                //计算当前数据库最大的值是多少
                Map<String,String> map = new HashMap<String,String>();
                map.put("rate",rate);
                map.put("symbol",coinName+"_btc");
                String max_time = klineMapper.selectExistMaxRecord(map);
                   for (int i = 0; i < jsonArray.size(); i++) {


                    String temp = jsonArray.get(i).toString();
                    String[] elements = temp.substring(1, temp.length() - 1).split(",");

                       if(StringUtils.isNotBlank(max_time)){
                           if(Long.valueOf(max_time.replace("\"", ""))<Long.valueOf((elements[0].replace("\"", "")))){
                               continue;
                           }
                       }
                    float num_open=Float.parseFloat(elements[1].trim().replace("\"", ""));
                    float num_high=Float.parseFloat(elements[2].trim().replace("\"", ""));
                    float num_low=Float.parseFloat(elements[3].trim().replace("\"", ""));
                    float num_end=Float.parseFloat(elements[4].trim().replace("\"", ""));
                    float num_tradesize=Float.parseFloat(elements[5].trim().replace("\"", ""));
                    batchArgs.add(new Object[]{coinName+"_btc",num_open,num_high,num_low,num_end,num_tradesize,elements[0].replace("\"", ""),rate,DateUtil.timeStamp2Date(elements[0],null)});

                }
                jdbcTemplate.batchUpdate(sql,batchArgs);
               /* for (int i = 0; i < jsonArray.size(); i++) {
                   // System.out.println("任务1,从配置文件加载任务信息，当前时间：" + jsonArray.get(i).toString());
                    String temp = jsonArray.get(i).toString();
                    String[] elements = temp.substring(1, temp.length() - 1).split(",");
                    //System.out.println(elements[1]);
                    Kline kline = new Kline();
                    kline.setTime(elements[0].replace("\"", ""));
                    kline.setOpen(Float.parseFloat(elements[1].trim().replace("\"", "")));
                    kline.setHigh(Float.parseFloat(elements[2].trim().replace("\"", "")));
                    kline.setLow(Float.parseFloat(elements[3].trim().replace("\"", "")));
                    kline.setEnd(Float.parseFloat(elements[4].trim().replace("\"", "")));
                    kline.setTradesize(Float.parseFloat(elements[5].trim().replace("\"", "")));
                    kline.setSymbol(coinName+"_btc");
                    kline.setRate(rate);
                    kline.setTimeformat(DateUtil.timeStamp2Date(elements[0],null));
                    Map<String,String> map = new HashMap<String,String>();
                    map.put("time",elements[0]);
                    map.put("rate",rate);
                    map.put("symbol",coinName+"_btc");
                    System.out.println(map.toString());
                    List<Kline>  list =  klineMapper.selectExistRecord(map);
                    if(list.size()==0){
                        System.out.println(kline.toString());
                        klineMapper.insertSelective(kline);
                    }
                }*/
                try {
                    Thread.currentThread().sleep(2000);
                }catch (Exception e){

                }
            }

        }
    }
}