package com.chuckiefan.architecturecomponentdemo.net.model.resp;

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/24 11:18
 * 内容 ：
 */
public class Rating implements IResp {

    private int max;
    private double average;
    private String stars;
    private int min;

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getStars() {
        return stars;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMin() {
        return min;
    }

}