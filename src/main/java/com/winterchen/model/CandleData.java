package com.winterchen.model;

import java.util.Objects;

public class CandleData {

    //数据模型 time0 open1 close2 min3 max4 vol5 tag6 macd7 dif8 dea9
//['2015-10-19',18.56,18.25,18.19,18.56,55.00,0,-0.00,0.08,0.09]
    private String  time;
    private float open;
    private float close;
    private float min;
    private float max;
    private float vol;
    private float tag;
    private float macd;
    private float dif;
    private float dea;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getVol() {
        return vol;
    }

    public void setVol(float vol) {
        this.vol = vol;
    }

    public float getTag() {
        return tag;
    }

    public void setTag(float tag) {
        this.tag = tag;
    }

    public float getMacd() {
        return macd;
    }

    public void setMacd(float macd) {
        this.macd = macd;
    }

    public float getDif() {
        return dif;
    }

    public void setDif(float dif) {
        this.dif = dif;
    }

    public float getDea() {
        return dea;
    }

    public void setDea(float dea) {
        this.dea = dea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandleData that = (CandleData) o;
        return Float.compare(that.open, open) == 0 &&
                Float.compare(that.close, close) == 0 &&
                Float.compare(that.min, min) == 0 &&
                Float.compare(that.max, max) == 0 &&
                Float.compare(that.vol, vol) == 0 &&
                Float.compare(that.tag, tag) == 0 &&
                Float.compare(that.macd, macd) == 0 &&
                Float.compare(that.dif, dif) == 0 &&
                Float.compare(that.dea, dea) == 0 &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, open, close, min, max, vol, tag, macd, dif, dea);
    }

    @Override
    public String toString() {
        return "CandleData{" +
                "time='" + time + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", min=" + min +
                ", max=" + max +
                ", vol=" + vol +
                ", tag=" + tag +
                ", macd=" + macd +
                ", dif=" + dif +
                ", dea=" + dea +
                '}';
    }
}
