package com.sweetzpot.stravazpot.athlete.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.Distance;

public class Stats {
    @SerializedName("biggest_ride_distance") private Distance biggestRideDistance;
    @SerializedName("biggest_climb_elevation_gain") private Distance biggestClimbElevationGain;
    @SerializedName("recent_ride_totals") private Totals recentRideTotals;
    @SerializedName("recent_run_totals") private Totals recentRunTotals;
    @SerializedName("recent_swim_totals") private Totals recentSwimTotals;
    @SerializedName("ytd_ride_totals") private Totals yearToDateRideTotals;
    @SerializedName("ytd_run_totals") private Totals yearToDateRunTotals;
    @SerializedName("ytd_swim_totals") private Totals yearToDateSwimTotals;
    @SerializedName("all_ride_totals") private Totals allRideTotals;
    @SerializedName("all_run_totals") private Totals allRunTotals;
    @SerializedName("all_swim_totals") private Totals allSwimTotals;

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
