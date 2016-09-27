package com.sweetzpot.stravazpot.stream.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stream {
    @SerializedName("type") private StreamType type;
    @SerializedName("data") private List<Object> data;
    @SerializedName("series_type") private SeriesType seriesType;
    @SerializedName("original_size") private int originalSize;
    @SerializedName("resolution") private Resolution resolution;

    public StreamType getType() {
        return type;
    }

    public List<Object> getData() {
        return data;
    }

    public SeriesType getSeriesType() {
        return seriesType;
    }

    public int getOriginalSize() {
        return originalSize;
    }

    public Resolution getResolution() {
        return resolution;
    }
}
