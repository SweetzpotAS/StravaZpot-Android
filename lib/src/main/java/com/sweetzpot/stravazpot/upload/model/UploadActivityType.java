package com.sweetzpot.stravazpot.upload.model;

public enum UploadActivityType {
    RIDE("ride"),
    RUN("run"),
    SWIM("swim"),
    HIKE("hike"),
    WALK("walk"),
    NORDIC_SKI("nordicski"),
    ALPINE_SKI("alpineski"),
    BACKCOUNTRY_SKI("backcountryski"),
    ICE_SKATE("iceskate"),
    INLINE_SKATE("inlineskate"),
    KITE_SURF("kitesurf"),
    ROLLER_SKI("rollerski"),
    WINDSURF("windsurf"),
    WORKOUT("workout"),
    SNOWBOARD("snowboard"),
    SNOWSHOE("snowshoe"),
    EBIKE_RIDE("ebikeride"),
    VIRTUAL_RIDE("virtualride");

    private String rawValue;

    UploadActivityType(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
