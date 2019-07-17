package com.sweetzpot.stravazpot.athlete.api;

import com.sweetzpot.stravazpot.athlete.request.GetAthleteFollowersRequest;
import com.sweetzpot.stravazpot.athlete.request.GetAthleteFriendsRequest;
import com.sweetzpot.stravazpot.athlete.request.GetBothFollowingRequest;
import com.sweetzpot.stravazpot.athlete.request.GetMyFollowersRequest;
import com.sweetzpot.stravazpot.athlete.request.GetMyFriendsRequest;
import com.sweetzpot.stravazpot.athlete.rest.FriendRest;
import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;

public class FriendAPI extends StravaAPI {

    public FriendAPI(StravaConfig config) {
        super(config);
    }

    public GetMyFriendsRequest getMyFriends() {
        return new GetMyFriendsRequest(getAPI(FriendRest.class), this);
    }

    public GetAthleteFriendsRequest getAthleteFriends(long athleteID) {
        return new GetAthleteFriendsRequest(athleteID, getAPI(FriendRest.class), this);
    }

    public GetMyFollowersRequest getMyFollowers() {
        return new GetMyFollowersRequest(getAPI(FriendRest.class), this);
    }

    public GetAthleteFollowersRequest getAthleteFollowers(long athleteID) {
        return new GetAthleteFollowersRequest(athleteID, getAPI(FriendRest.class), this);
    }

    public GetBothFollowingRequest getBothFollowing(long athleteID) {
        return new GetBothFollowingRequest(athleteID, getAPI(FriendRest.class), this);
    }
}
