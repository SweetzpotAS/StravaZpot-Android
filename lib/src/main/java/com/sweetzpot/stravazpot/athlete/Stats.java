package com.sweetzpot.stravazpot.athlete;

import com.sweetzpot.stravazpot.common.Distance;

public class Stats {
    private Distance biggestRideDistance;
    private Distance biggestClimbElevationGain;
    private Totals recentRideTotals;
    private Totals recentRunTotals;
    private Totals recentSwimTotals;
    private Totals yearToDateRideTotals;
    private Totals yearToDateRunTotals;
    private Totals yearToDateSwimTotals;
    private Totals allRideTotals;
    private Totals allRunTotals;
    private Totals allSwimTotals;

    public Distance getBiggestRideDistance() {
        return biggestRideDistance;
    }

    public Distance getBiggestClimbElevationGain() {
        return biggestClimbElevationGain;
    }

    public Totals getRecentRideTotals() {
        return recentRideTotals;
    }

    public Totals getRecentRunTotals() {
        return recentRunTotals;
    }

    public Totals getRecentSwimTotals() {
        return recentSwimTotals;
    }

    public Totals getYearToDateRideTotals() {
        return yearToDateRideTotals;
    }

    public Totals getYearToDateRunTotals() {
        return yearToDateRunTotals;
    }

    public Totals getYearToDateSwimTotals() {
        return yearToDateSwimTotals;
    }

    public Totals getAllRideTotals() {
        return allRideTotals;
    }

    public Totals getAllRunTotals() {
        return allRunTotals;
    }

    public Totals getAllSwimTotals() {
        return allSwimTotals;
    }
}
