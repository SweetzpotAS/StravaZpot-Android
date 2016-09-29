package com.sweetzpot.stravazpot.segment.model;

public enum DateRange {
    THIS_YEAR("this_year"),
    THIS_MONTH("this_month"),
    THIS_WEEK("this_week"),
    TODAY("today");

    private String rawValue;

    DateRange(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
