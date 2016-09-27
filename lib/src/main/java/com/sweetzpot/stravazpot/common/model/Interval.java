package com.sweetzpot.stravazpot.common.model;

import com.google.gson.annotations.SerializedName;

public class Interval<T> {
    @SerializedName("min") private T min;
    @SerializedName("max") private T max;

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }
}
