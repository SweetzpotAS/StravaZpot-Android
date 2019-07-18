package com.sweetzpot.stravazpot.club.api;

import com.sweetzpot.stravazpot.club.request.GetClubRequest;
import com.sweetzpot.stravazpot.club.request.JoinClubRequest;
import com.sweetzpot.stravazpot.club.request.LeaveClubRequest;
import com.sweetzpot.stravazpot.club.request.ListClubActivitiesRequest;
import com.sweetzpot.stravazpot.club.request.ListClubAdminsRequest;
import com.sweetzpot.stravazpot.club.request.ListClubAnnouncementsRequest;
import com.sweetzpot.stravazpot.club.request.ListClubGroupEventsRequest;
import com.sweetzpot.stravazpot.club.request.ListClubMembersRequest;
import com.sweetzpot.stravazpot.club.request.ListMyClubsRequest;
import com.sweetzpot.stravazpot.club.rest.ClubRest;
import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;

public class ClubAPI extends StravaAPI {

    public ClubAPI(StravaConfig config) {
        super(config);
    }

    public GetClubRequest getClub(long clubID) {
        return new GetClubRequest(clubID, getAPI(ClubRest.class), this);
    }

    public ListClubAnnouncementsRequest listClubAnnouncements(long clubID) {
        return new ListClubAnnouncementsRequest(clubID, getAPI(ClubRest.class), this);
    }

    public ListClubGroupEventsRequest listClubGroupEvents(Long clubID) {
        return new ListClubGroupEventsRequest(clubID, getAPI(ClubRest.class), this);
    }

    public ListMyClubsRequest listMyClubs() {
        return new ListMyClubsRequest(getAPI(ClubRest.class), this);
    }

    public ListClubMembersRequest listClubMembers(Long clubID) {
        return new ListClubMembersRequest(clubID, getAPI(ClubRest.class), this);
    }

    public ListClubAdminsRequest listClubAdmins(Long clubID) {
        return new ListClubAdminsRequest(clubID, getAPI(ClubRest.class), this);
    }

    public ListClubActivitiesRequest listClubActivities(Long clubID) {
        return new ListClubActivitiesRequest(clubID, getAPI(ClubRest.class), this);
    }

    public JoinClubRequest joinClub(Long clubID) {
        return new JoinClubRequest(clubID, getAPI(ClubRest.class), this);
    }

    public LeaveClubRequest leaveClub(Long clubID) {
        return new LeaveClubRequest(clubID, getAPI(ClubRest.class), this);
    }
}
