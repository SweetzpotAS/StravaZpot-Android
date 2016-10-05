package com.sweetzpot.stravazpot.common.model;

public class Time {
    private int seconds;

    public static Time seconds(int seconds) {
        return new Time(seconds);
    }

    public Time(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return seconds == time.seconds;
    }

    @Override
    public int hashCode() {
        return seconds;
    }

    @Override
    public String toString() {
        return String.valueOf(seconds);
    }
}
