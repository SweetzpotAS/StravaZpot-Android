package com.sweetzpot.stravazpot.authenticaton.model;

public class Token {
    private String value;

    public Token(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Bearer " + value;
    }
}
