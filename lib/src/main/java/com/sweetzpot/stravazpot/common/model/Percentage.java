package com.sweetzpot.stravazpot.common.model;

public class Percentage {
    private float value;

    public static Percentage of(float value) {
        return new Percentage(value);
    }

    public Percentage(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
