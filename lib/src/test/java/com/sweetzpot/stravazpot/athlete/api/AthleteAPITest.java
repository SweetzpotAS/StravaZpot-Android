package com.sweetzpot.stravazpot.athlete.api;

import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.athlete.model.AthleteType;
import com.sweetzpot.stravazpot.athlete.model.FriendStatus;
import com.sweetzpot.stravazpot.athlete.model.MeasurementPreference;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.api.StravaConfig;
import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.common.model.ResourceState;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.sweetzpot.stravazpot.matchers.DateMatcher.isSameDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AthleteAPITest extends StravaAPITest{

    private static final String ANY_TOKEN = "Bearer 83ebeabdec09f6670863766f792ead24d61fe3f9";

    @Test
    public void shouldRetrieveCurrentAthlete() throws Exception {
        enqueueAthlete();
        AthleteAPI athleteAPI = givenAnAthleteAPI();

        Athlete athlete = athleteAPI.retrieveCurrentAthlete()
                                    .execute();

        assertAthleteParsedCorrectly(athlete);
    }

    private void assertAthleteParsedCorrectly(Athlete athlete) {
        assertThat(athlete.getID(), is(227615L));
        assertThat(athlete.getResourceState(), is(ResourceState.DETAILED));
        assertThat(athlete.getFirstName(), is("John"));
        assertThat(athlete.getLastName(), is("Applestrava"));
        assertThat(athlete.getProfileMedium(), is("http://pics.com/227615/medium.jpg"));
        assertThat(athlete.getProfile(), is("http://pics.com/227615/large.jpg"));
        assertThat(athlete.getCity(), is("San Francisco"));
        assertThat(athlete.getState(), is("California"));
        assertThat(athlete.getCountry(), is("United States"));
        assertThat(athlete.getSex(), is(Gender.MALE));
        assertThat(athlete.getFriend(), is(FriendStatus.NOT_FRIENDS));
        assertThat(athlete.getFollower(), is(FriendStatus.NOT_FRIENDS));
        assertThat(athlete.isPremium(), is(true));
        assertThat(athlete.getCreatedAt(), isSameDate(makeDate(1, Calendar.JANUARY, 2008, 17, 44, 00)));
        assertThat(athlete.getUpdatedAt(), isSameDate(makeDate(4, Calendar.SEPTEMBER, 2013, 20, 00, 50)));
        assertThat(athlete.getFollowerCount(), is(273));
        assertThat(athlete.getFriendCount(), is(19));
        assertThat(athlete.getMutualFriendCount(), is(0));
        assertThat(athlete.getAthleteType(), is(AthleteType.CYCLIST));
        assertThat(athlete.getDatePreference(), is("%m/%d/%Y"));
        assertThat(athlete.getMeasurementPreference(), is(MeasurementPreference.FEET));
        assertThat(athlete.getEmail(), is("john@applestrava.com"));
        assertThat(athlete.getFtp(), is(280));
        assertThat(athlete.getWeight(), is(68.7f));
        assertThat(athlete.getClubs().size(), is(1));
        assertThat(athlete.getBikes().size(), is(2));
        assertThat(athlete.getShoes().size(), is(1));
    }

    private AthleteAPI givenAnAthleteAPI() {
        StravaConfig config = StravaConfig
                                .withToken(ANY_TOKEN)
                                .debug()
                                .baseURL(getBaseURL())
                                .build();

        return new AthleteAPI(config);
    }

    private void enqueueAthlete() {
        String athleteJSON = "{\n" +
                "  \"id\": 227615,\n" +
                "  \"resource_state\": 3,\n" +
                "  \"firstname\": \"John\",\n" +
                "  \"lastname\": \"Applestrava\",\n" +
                "  \"profile_medium\": \"http://pics.com/227615/medium.jpg\",\n" +
                "  \"profile\": \"http://pics.com/227615/large.jpg\",\n" +
                "  \"city\": \"San Francisco\",\n" +
                "  \"state\": \"California\",\n" +
                "  \"country\": \"United States\",\n" +
                "  \"sex\": \"M\",\n" +
                "  \"friend\": null,\n" +
                "  \"follower\": null,\n" +
                "  \"premium\": true,\n" +
                "  \"created_at\": \"2008-01-01T17:44:00Z\",\n" +
                "  \"updated_at\": \"2013-09-04T20:00:50Z\",\n" +
                "  \"follower_count\": 273,\n" +
                "  \"friend_count\": 19,\n" +
                "  \"mutual_friend_count\": 0,\n" +
                "  \"athlete_type\": 0,\n" +
                "  \"date_preference\": \"%m/%d/%Y\",\n" +
                "  \"measurement_preference\": \"feet\",\n" +
                "  \"email\": \"john@applestrava.com\",\n" +
                "  \"ftp\": 280,\n" +
                "  \"weight\": 68.7,\n" +
                "  \"clubs\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Team Strava Cycling\",\n" +
                "      \"profile_medium\": \"http://pics.com/clubs/1/medium.jpg\",\n" +
                "      \"profile\": \"http://pics.com/clubs/1/large.jpg\",\n" +
                "      \"cover_photo\": \"http://pics.com/clubs/1/cover/large.jpg\",\n" +
                "      \"cover_photo_small\": \"http://pics.com/clubs/1/cover/small.jpg\",\n" +
                "      \"sport_type\": \"cycling\",\n" +
                "      \"city\": \"San Francisco\",\n" +
                "      \"state\": \"California\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"private\": true,\n" +
                "      \"member_count\": 23,\n" +
                "      \"featured\": false,\n" +
                "      \"url\": \"strava-cycling\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"bikes\": [\n" +
                "    {\n" +
                "      \"id\": \"b105763\",\n" +
                "      \"primary\": false,\n" +
                "      \"name\": \"Cannondale TT\",\n" +
                "      \"distance\": 476612.9,\n" +
                "      \"resource_state\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"b105762\",\n" +
                "      \"primary\": true,\n" +
                "      \"name\": \"Masi\",\n" +
                "      \"distance\": 9000578.2,\n" +
                "      \"resource_state\": 2\n" +
                "    }\n" +
                "  ],\n" +
                "  \"shoes\": [\n" +
                "    {\n" +
                "      \"id\": \"g1\",\n" +
                "      \"primary\": true,\n" +
                "      \"name\": \"Running Shoes\",\n" +
                "      \"distance\": 67492.9,\n" +
                "      \"resource_state\": 2\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        enqueueResponse(athleteJSON);
    }

    public Date makeDate(int day, int month, int year, int hour, int minute, int second) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone("GMT"));
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month);
        instance.set(Calendar.DAY_OF_MONTH, day);
        instance.set(Calendar.HOUR_OF_DAY, hour);
        instance.set(Calendar.MINUTE, minute);
        instance.set(Calendar.SECOND, second);
        return instance.getTime();
    }
}