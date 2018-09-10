package com.winterchen.controller;

import com.winterchen.service.user.KlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestApi {

    @Autowired
    private KlineService klineService;


    @RequestMapping(value = "/candlestick.html" ,method = {RequestMethod.POST, RequestMethod.GET} )
    public String getToPage() {
        System.out.println("xxxxxxxxxxxxxxxxxxx");
        //klineService.getKline();
        return  "candlestick";
    }

    @ResponseBody
    @RequestMapping(value = "/getAllData" ,method = {RequestMethod.POST, RequestMethod.GET} )
    public String getKlineData() {
        System.out.println("getdate");
        //klineService.getKline();
        return  "[['2015-10-16',18.4,18.58,18.33,18.79,67.00,1,0.04,0.11,0.09],['2015-10-19',18.56,18.25,18.19,18.56,55.00,0,-0.00,0.08,0.09]]";
       // return  "success";
    }
}

