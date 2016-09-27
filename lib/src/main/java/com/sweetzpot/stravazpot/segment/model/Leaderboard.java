package com.sweetzpot.stravazpot.segment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Leaderboard {
    @SerializedName("entry_count") private int entryCount;
    @SerializedName("entries") private List<LeaderboardEntry> entries;

    public int getEntryCount() {
        return entryCount;
    }

    public List<LeaderboardEntry> getEntries() {
        return entries;
    }
}
