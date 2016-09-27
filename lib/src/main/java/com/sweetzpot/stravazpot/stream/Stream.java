package com.sweetzpot.stravazpot.stream;

import java.util.List;

public class Stream {
    private StreamType type;
    private List<Object> data;
    private String seriesType;
    private int originalSize;
    private Resolution resolution;

    public StreamType getType() {
        return type;
    }

    public List<Object> getData() {
        return data;
    }

    public String getSeriesType() {
        return seriesType;
    }

    public int getOriginalSize() {
        return originalSize;
    }

    public Resolution getResolution() {
        return resolution;
    }
}
