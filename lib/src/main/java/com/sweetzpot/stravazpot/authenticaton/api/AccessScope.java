package com.sweetzpot.stravazpot.authenticaton.api;

public enum AccessScope {
    PUBLIC("read,activity:read"),
    WRITE("profile:write,activity:write"),
    VIEW_PRIVATE("read_all,profile:read_all,activity:read_all");

    private String rawValue;

    AccessScope(String rawValue) {
        this.rawValue = rawValue;
    }
    
    @Override
    public String toString() {
        return rawValue;
    }
}
