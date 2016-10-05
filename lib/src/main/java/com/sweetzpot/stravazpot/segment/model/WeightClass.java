package com.sweetzpot.stravazpot.segment.model;

public enum WeightClass {
    POUNDS_0_124("0_124"),
    POUNDS_125_149("125_149"),
    POUNDS_150_164("150_164"),
    POUNDS_165_179("165_179"),
    POUNDS_180_199("180_199"),
    POUNDS_200_PLUS("200_plus"),
    KG_0_54("0_54"),
    KG_55_64("55_64"),
    KG_65_74("65_74"),
    KG_75_84("75_84"),
    KG_85_94("85_94"),
    KG_95_PLUS("95_plus");

    private String rawValue;

    WeightClass(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
