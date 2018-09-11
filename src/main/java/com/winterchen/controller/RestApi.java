package com.winterchen.controller;

import com.winterchen.model.Kline;
import com.winterchen.service.user.KlineService;
import javafx.beans.binding.StringBinding;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestApi {

    @Autowired
    private KlineService klineService;


    @RequestMapping(value = "/candlestick.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String getToPage() {
        System.out.println("xxxxxxxxxxxxxxxxxxx");
        //klineService.getKline();
        return "candlestick";
    }

    @ResponseBody
    @RequestMapping(value = "/getAllData", method = {RequestMethod.POST, RequestMethod.GET})
    public String getKlineData() {
        System.out.println("getdate");
        //klineService.getKline();
       // time0 open1 close2 min3 max4 vol5 tag6 macd7 dif8 dea9
        //return  "[['2015-10-16',18.4,18.58,18.33,18.79,67.00,1,0.04,0.11,0.09],['2015-10-19',18.56,18.25,18.19,18.56,55.00,0,-0.00,0.08,0.09]]";
        List<Kline> list = klineService.getKline();
        StringBuilder sb = new StringBuilder("");
        for (Kline kline :
                list) {
            sb.append(kline.toStringNew() + ',');
        }
        String result = "";
        if (StringUtils.isNotBlank(sb.toString())) {
            result = sb.toString().substring(0, sb.toString().length() - 1);
            result = "[" + result + ']';
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        List<Kline> list = new ArrayList<Kline>();
        Kline a = new Kline();
        a.setLow(Float.valueOf(1));
        a.setEnd(Float.valueOf(2));
        list.add(a);
        Kline b = new Kline();
        b.setLow(Float.valueOf(1));
        b.setEnd(Float.valueOf(2));
        System.out.println("args = [" + b.toStringNew() + "]");
       /* list.add(b);
        String[] strings = new String[list.size()];

        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i).toString());
        }
       list1.toArray(strings);

        String[] arr = list.toArray(new String[list.size()]);
        System.out.println("args = [" + strings + "]");

        String[] xxx =new String[]{"s1","s2","s3"};
        System.out.println("args = [" + xxx + "]");*/
    }
}

