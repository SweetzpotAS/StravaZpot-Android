package com.sweetzpot.stravazpot.authenticaton.api;

public enum ApprovalPrompt {
    FORCE("force"),
    AUTO("auto");

    private String rawValue;

    ApprovalPrompt(String rawValue) {
        this.rawValue = rawValue;
    }
    
    @Override
    public String toString() {
        return rawValue;
    }
}
