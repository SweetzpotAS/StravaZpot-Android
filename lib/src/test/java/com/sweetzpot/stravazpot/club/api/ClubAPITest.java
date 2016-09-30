package com.sweetzpot.stravazpot.club.api;

import com.sweetzpot.stravazpot.club.model.Club;
import com.sweetzpot.stravazpot.club.model.ClubType;
import com.sweetzpot.stravazpot.club.model.Membership;
import com.sweetzpot.stravazpot.club.model.SportType;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.ResourceState;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClubAPITest extends StravaAPITest {

    @Test
    public void shouldRetrieveAClub() throws Exception {
        enqueueClub();
        ClubAPI clubAPI = givenAClubAPI();

        Club club = clubAPI.getClub(1)
                        .execute();

        assertRequestPathContains("/clubs/1");
        assertClubParsedCorrectly(club);
    }

    private ClubAPI givenAClubAPI() {
        return new ClubAPI(givenAValidConfig());
    }

    private void assertClubParsedCorrectly(Club club) {
        assertThat(club.getID(), is(1));
        assertThat(club.getResourceState(), is(ResourceState.DETAILED));
        assertThat(club.getName(), is("Team Strava Cycling"));
        assertThat(club.getProfileMedium(), is("http://pics.com/clubs/1/medium.jpg"));
        assertThat(club.getProfile(), is("http://pics.com/clubs/1/large.jpg"));
        assertThat(club.getCoverPhoto(), is("http://pics.com/clubs/1/cover/large.jpg"));
        assertThat(club.getCoverPhotoSmall(), is("http://pics.com/clubs/1/cover/small.jpg"));
        assertThat(club.getDescription(), is("From the people who brought you strava.com"));
        assertThat(club.getClubType(), is(ClubType.COMPANY));
        assertThat(club.getSportType(), is(SportType.CYCLING));
        assertThat(club.getCity(), is("San Francisco"));
        assertThat(club.getState(), is("California"));
        assertThat(club.getCountry(), is("United States"));
        assertThat(club.isPrivate(), is(true));
        assertThat(club.getMemberCount(), is(71));
        assertThat(club.isFeatured(), is(false));
        assertThat(club.isVerified(), is(false));
        assertThat(club.getMembership(), is(Membership.MEMBER));
        assertThat(club.isAdmin(), is(true));
        assertThat(club.isOwner(), is(false));
        assertThat(club.getFollowingCount(), is(1));
        assertThat(club.getUrl(), is("strava-cycling"));
    }

    private void enqueueClub() {
        String clubJSON = "{\n" +
                "  \"id\": 1,\n" +
                "  \"resource_state\": 3,\n" +
                "  \"name\": \"Team Strava Cycling\",\n" +
                "  \"profile_medium\": \"http://pics.com/clubs/1/medium.jpg\",\n" +
                "  \"profile\": \"http://pics.com/clubs/1/large.jpg\",\n" +
                "  \"cover_photo\": \"http://pics.com/clubs/1/cover/large.jpg\",\n" +
                "  \"cover_photo_small\": \"http://pics.com/clubs/1/cover/small.jpg\",\n" +
                "  \"description\": \"From the people who brought you strava.com\",\n" +
                "  \"club_type\": \"company\",\n" +
                "  \"sport_type\": \"cycling\",\n" +
                "  \"city\": \"San Francisco\",\n" +
                "  \"state\": \"California\",\n" +
                "  \"country\": \"United States\",\n" +
                "  \"private\": true,\n" +
                "  \"member_count\": 71,\n" +
                "  \"featured\": false,\n" +
                "  \"verified\": false,\n" +
                "  \"membership\": \"member\",\n" +
                "  \"admin\": true,\n" +
                "  \"owner\": false,\n" +
                "  \"following_count\": 1,\n" +
                "  \"url\": \"strava-cycling\"\n" +
                "}";
        enqueueResponse(clubJSON);
    }
}