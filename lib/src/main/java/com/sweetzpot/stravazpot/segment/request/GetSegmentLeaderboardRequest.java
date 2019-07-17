package com.sweetzpot.stravazpot.segment.request;

import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.segment.api.SegmentAPI;
import com.sweetzpot.stravazpot.segment.model.AgeGroup;
import com.sweetzpot.stravazpot.segment.model.DateRange;
import com.sweetzpot.stravazpot.segment.model.Leaderboard;
import com.sweetzpot.stravazpot.segment.model.WeightClass;
import com.sweetzpot.stravazpot.segment.rest.SegmentRest;

import retrofit2.Call;

public class GetSegmentLeaderboardRequest {

    private final long segmentID;
    private final SegmentRest restService;
    private final SegmentAPI api;
    private Gender gender;
    private AgeGroup ageGroup;
    private WeightClass weightClass;
    private Boolean following;
    private Long clubID;
    private DateRange dateRange;
    private Integer contextEntries;
    private Integer page;
    private Integer perPage;

    public GetSegmentLeaderboardRequest(long segmentID, SegmentRest restService, SegmentAPI api) {
        this.segmentID = segmentID;
        this.restService = restService;
        this.api = api;
    }

    public GetSegmentLeaderboardRequest withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public GetSegmentLeaderboardRequest inAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
        return this;
    }

    public GetSegmentLeaderboardRequest inWeightClass(WeightClass weightClass) {
        this.weightClass = weightClass;
        return this;
    }

    public GetSegmentLeaderboardRequest following(boolean following) {
        this.following = following;
        return this;
    }

    public GetSegmentLeaderboardRequest inClub(long clubID) {
        this.clubID = clubID;
        return this;
    }

    public GetSegmentLeaderboardRequest inDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
        return this;
    }

    public GetSegmentLeaderboardRequest withContextEntries(int contextEntries) {
        this.contextEntries = contextEntries;
        return this;
    }

    public GetSegmentLeaderboardRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public GetSegmentLeaderboardRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public Leaderboard execute() {
        Call<Leaderboard> call = restService.getSegmentLeaderboard(segmentID, gender, ageGroup,
                weightClass, following, clubID, dateRange, contextEntries, page, perPage);
        return api.execute(call);
    }
}
