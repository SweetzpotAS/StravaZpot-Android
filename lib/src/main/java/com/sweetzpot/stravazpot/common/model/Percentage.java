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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Percentage that = (Percentage) o;

        return Float.compare(that.value, value) == 0;

    }

    @Override
    public int hashCode() {
        return (value != +0.0f ? Float.floatToIntBits(value) : 0);
    }
}
