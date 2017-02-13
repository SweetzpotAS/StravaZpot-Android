package com.sweetzpot.stravazpot.upload.model;

public enum DataType {
    FIT("fit"),
    FIT_GZ("fit.gz"),
    TCX("tcx"),
    TCX_GZ("tcx.gz"),
    GPX("gpx"),
    GPX_GZ("gpx.gz");

    private String rawValue;

    DataType(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
