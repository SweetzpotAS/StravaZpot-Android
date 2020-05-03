package com.sweetzpot.stravazpot.authenticaton.model;

@Deprecated
/**
 * Deprecated because Token is now only a String value.
 */
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
