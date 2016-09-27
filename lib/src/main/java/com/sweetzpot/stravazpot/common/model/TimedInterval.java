package com.sweetzpot.stravazpot.common.model;

import com.google.gson.annotations.SerializedName;

public class TimedInterval<T> {
    @SerializedName("min") private T min;
    @SerializedName("max") private T max;
    @SerializedName("time") private long time;

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    public long getTime() {
        return time;
    }
}
