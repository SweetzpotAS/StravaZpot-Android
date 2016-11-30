package com.sweetzpot.stravazpot.common.model;

public class Temperature {

    public static Temperature celsiusDegrees(float celsiusDegrees) {
        return new Temperature(celsiusDegrees);
    }

    private float celsiusDegrees;

    private Temperature(float celsiusDegrees) {
        this.celsiusDegrees = celsiusDegrees;
    }

    public float getCelsiusDegrees() {
        return celsiusDegrees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Temperature that = (Temperature) o;

        return Float.compare(that.celsiusDegrees, celsiusDegrees) == 0;

    }

    @Override
    public int hashCode() {
        return (celsiusDegrees != +0.0f ? Float.floatToIntBits(celsiusDegrees) : 0);
    }
}
