package com.sweetzpot.stravazpot.authenticaton.api;

public enum AccessScope {
    PUBLIC("public"),
    WRITE("write"),
    VIEW_PRIVATE("view_private"),
    VIEW_PRIVATE_WRITE("view_private,write");

    private String rawValue;

    AccessScope(String rawValue) {
        this.rawValue = rawValue;
    }
    
    @Override
    public String toString() {
        return rawValue;
    }
}
