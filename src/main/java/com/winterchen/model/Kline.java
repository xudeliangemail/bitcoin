package com.winterchen.model;

import java.util.Date;

public class Kline {
    private String symbol;

    private Float open;

    private Float high;

    private Float low;

    private Float end;

    private Float tradesize;

    private String time;

    private Date createTime;

    private Integer id;

    private String rate;

    private String timeformat;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public Float getOpen() {
        return open;
    }

    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getEnd() {
        return end;
    }

    public void setEnd(Float end) {
        this.end = end;
    }

    public Float getTradesize() {
        return tradesize;
    }

    public void setTradesize(Float tradesize) {
        this.tradesize = tradesize;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getTimeformat() {
        return timeformat;
    }

    public void setTimeformat(String timeformat) {
        this.timeformat = timeformat;
    }

    @Override
    public String toString() {
        return "Kline{" +
                "symbol='" + symbol + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", end=" + end +
                ", tradesize=" + tradesize +
                ", time='" + time + '\'' +
                ", createTime=" + createTime +
                ", id=" + id +
                ", rate='" + rate + '\'' +
                ", timeformat='" + timeformat + '\'' +
                '}';
    }
}