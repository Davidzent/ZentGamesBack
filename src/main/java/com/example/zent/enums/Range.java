package com.example.zent.enums;

public enum Range {
    SCORES(5,0),
    PAGESIZE(100,10);

    public final int max;
    public final int min;

    private Range(int max,int min){
        this.max = max;
        this.min = min;
    }

}
