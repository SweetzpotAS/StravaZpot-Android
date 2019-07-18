package com.sweetzpot.stravazpot.athlete.api;

import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.athlete.model.AthleteType;
import com.sweetzpot.stravazpot.athlete.model.FriendStatus;
import com.sweetzpot.stravazpot.athlete.model.MeasurementPreference;
import com.sweetzpot.stravazpot.athlete.model.Stats;
import com.sweetzpot.stravazpot.athlete.model.Totals;
import com.sweetzpot.stravazpot.athlete.model.Zones;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Time;
import com.sweetzpot.stravazpot.segment.model.SegmentEffort;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static com.sweetzpot.stravazpot.matchers.DateMatcher.isSameDate;
import static com.sweetzpot.stravazpot.util.DateUtil.makeDate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class AthleteAPITest extends StravaAPITest{

    @Test
    public void shouldRetrieveCurrentAthlete() throws Exception {
        enqueueAthlete();
        AthleteAPI athleteAPI = givenAnAthleteAPI();

        Athlete athlete = athleteAPI.retrieveCurrentAthlete()
                                    .execute();

        assertRequestSentTo("/athlete");
        assertAthleteParsedCorrectly(athlete);
    }

    @Test
    public void shouldRetrieveAthlete() throws Exception {
        enqueueAthlete();
        AthleteAPI athleteAPI = givenAnAthleteAPI();

        Athlete athlete = athleteAPI.retrieveAthlete(227615L)
                                    .execute();

        assertRequestSentTo("/athletes/227615");
        assertAthleteParsedCorrectly(athlete);
    }

    @Test
    public void shouldUpdateAthlete() throws Exception {
        enqueueAthlete();
        AthleteAPI athleteAPI = givenAnAthleteAPI();

        athleteAPI.updateAthlete()
                    .newCity("Albuquerque")
                    .newState("New Mexico")
                    .newCountry("USA")
                    .newSex(Gender.FEMALE)
                    .newWeight(91.2f)
                    .execute();

        assertRequestBodyContains(
                "city=Albuquerque",
                "state=New%20Mexico",
                "country=USA",
                "sex=F",
                "weight=91.2"
                );
    }

    @Test
    public void shouldRetrieveAthleteZones() throws Exception {
        enqueueZones();
        AthleteAPI athleteAPI = givenAnAthleteAPI();

        Zones zones = athleteAPI.getAthleteZones()
                                .execute();

        assertRequestSentTo("/athlete/zones");
        assertZonesParsedCorrectly(zones);
    }

    @Test
    public void shouldRetrieveAthleteTotalsAndStats() throws Exception {
        enqueueTotalsAndStats();
        AthleteAPI athleteAPI = givenAnAthleteAPI();

        Stats stats = athleteAPI.getAthleteTotalsAndStats(227615L)
                                .execute();

        assertRequestSentTo("/athletes/227615/stats");
        assertStatsParsedCorrectly(stats);
    }

    @Test
    public void shouldListAthleteKOMS() throws Exception {
        enqueueResponse("[]");
        AthleteAPI athleteAPI = givenAnAthleteAPI();

        List<SegmentEffort> koms = athleteAPI.listAthleteKOMS(227615L)
                                            .inPage(2)
                                            .perPage(10)
                                            .execute();

        assertRequestPathContains(
                "/athletes/227615/koms",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldNotCrashWithEmptyStats() throws Exception {
        enqueueEmptyTotalsAndStats();
        AthleteAPI athleteAPI = givenAnAthleteAPI();

        Stats stats = athleteAPI.getAthleteTotalsAndStats(227615L)
                                .execute();

        assertThat(stats, is(notNullValue()));
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
        return new AthleteAPI(givenAValidConfig());
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

    private void assertZonesParsedCorrectly(Zones zones) {
        assertThat(zones.getHeartRate().hasCustomZones(), is(false));
        assertThat(zones.getHeartRate().getZones().size(), is(5));
        assertThat(zones.getPower().getZones().size(), is(7));
        assertThat(zones.getPower().getZones().get(0).getMin(), is(0f));
        assertThat(zones.getPower().getZones().get(0).getMax(), is(180f));
    }

    private void enqueueZones() {
        String zonesJSON = "{\n" +
                "  \"heart_rate\": {\n" +
                "    \"custom_zones\": false,\n" +
                "    \"zones\": [\n" +
                "      { \"min\": 0, \"max\": 115 },\n" +
                "      { \"min\": 115, \"max\": 152 },\n" +
                "      { \"min\": 152, \"max\": 171 },\n" +
                "      { \"min\": 171, \"max\": 190 },\n" +
                "      { \"min\": 190,  \"max\": -1 }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"power\": {\n" +
                "      \"zones\": [\n" +
                "        { \"min\": 0, \"max\": 180 },\n" +
                "        { \"min\": 181, \"max\": 246 },\n" +
                "        { \"min\": 247, \"max\": 295 },\n" +
                "        { \"min\": 296, \"max\": 344 },\n" +
                "        { \"min\": 345, \"max\": 393 },\n" +
                "        { \"min\": 394, \"max\": 492 },\n" +
                "        { \"min\": 493,  \"max\": -1 }\n" +
                "      ]\n" +
                "    }\n" +
                "}";

        enqueueResponse(zonesJSON);
    }

    private void assertStatsParsedCorrectly(Stats stats) {
        assertThat(stats.getBiggestRideDistance(), is(equalTo(Distance.meters(175454.0f))));
        assertThat(stats.getBiggestClimbElevationGain(), is(equalTo(Distance.meters(1882.6999999999998f))));
        assertThat(stats.getAllRideTotals(), is(notNullValue()));
        assertThat(stats.getAllRunTotals(), is(notNullValue()));
        assertThat(stats.getAllSwimTotals(), is(notNullValue()));
        assertThat(stats.getRecentRideTotals(), is(notNullValue()));
        assertThat(stats.getRecentRunTotals(), is(notNullValue()));
        assertThat(stats.getRecentSwimTotals(), is(notNullValue()));
        assertThat(stats.getYearToDateRideTotals(), is(notNullValue()));
        assertThat(stats.getYearToDateRunTotals(), is(notNullValue()));
        assertThat(stats.getYearToDateSwimTotals(), is(notNullValue()));
        Totals totals = stats.getRecentRideTotals();
        assertThat(totals.getCount(), is(3));
        assertThat(totals.getDistance(), is(Distance.meters(12054.900146484375f)));
        assertThat(totals.getMovingTime(), is(Time.seconds(2190)));
        assertThat(totals.getElapsedTime(), is(Time.seconds(2331)));
        assertThat(totals.getElevationGain(), is(Distance.meters(36)));
        assertThat(totals.getAchievementCount(), is(0));
    }

    private void enqueueTotalsAndStats() {
        String statsJSON = "{\n" +
                "  \"biggest_ride_distance\": 175454.0,\n" +
                "  \"biggest_climb_elevation_gain\": 1882.6999999999998,\n" +
                "  \"recent_ride_totals\": {\n" +
                "    \"count\": 3,\n" +
                "    \"distance\": 12054.900146484375,\n" +
                "    \"moving_time\": 2190,\n" +
                "    \"elapsed_time\": 2331,\n" +
                "    \"elevation_gain\": 36.0,\n" +
                "    \"achievement_count\": 0\n" +
                "  },\n" +
                "  \"recent_run_totals\": {\n" +
                "    \"count\": 23,\n" +
                "    \"distance\": 195948.40002441406,\n" +
                "    \"moving_time\": 65513,\n" +
                "    \"elapsed_time\": 75232,\n" +
                "    \"elevation_gain\": 2934.3999996185303,\n" +
                "    \"achievement_count\": 46\n" +
                "  },\n" +
                "  \"recent_swim_totals\": {\n" +
                "    \"count\": 2,\n" +
                "    \"distance\": 1117.2000122070312,\n" +
                "    \"moving_time\": 1744,\n" +
                "    \"elapsed_time\": 1942,\n" +
                "    \"elevation_gain\": 0.0,\n" +
                "    \"achievement_count\": 0\n" +
                "  },\n" +
                "  \"ytd_ride_totals\": {\n" +
                "    \"count\": 134,\n" +
                "    \"distance\": 4927252,\n" +
                "    \"moving_time\": 659982,\n" +
                "    \"elapsed_time\": 892644,\n" +
                "    \"elevation_gain\": 49940\n" +
                "  },\n" +
                "  \"ytd_run_totals\": {\n" +
                "    \"count\": 111,\n" +
                "    \"distance\": 917100,\n" +
                "    \"moving_time\": 272501,\n" +
                "    \"elapsed_time\": 328059,\n" +
                "    \"elevation_gain\": 7558\n" +
                "  },\n" +
                "  \"ytd_swim_totals\": {\n" +
                "    \"count\": 8,\n" +
                "    \"distance\": 10372,\n" +
                "    \"moving_time\": 8784,\n" +
                "    \"elapsed_time\": 11123,\n" +
                "    \"elevation_gain\": 0\n" +
                "  },\n" +
                "  \"all_ride_totals\": {\n" +
                "    \"count\": 375,\n" +
                "    \"distance\": 15760015,\n" +
                "    \"moving_time\": 2155741,\n" +
                "    \"elapsed_time\": 2684286,\n" +
                "    \"elevation_gain\": 189238\n" +
                "  },\n" +
                "  \"all_run_totals\": {\n" +
                "    \"count\": 272,\n" +
                "    \"distance\": 2269557,\n" +
                "    \"moving_time\": 673678,\n" +
                "    \"elapsed_time\": 812095,\n" +
                "    \"elevation_gain\": 23780\n" +
                "  },\n" +
                "  \"all_swim_totals\": {\n" +
                "    \"count\": 8,\n" +
                "    \"distance\": 10372,\n" +
                "    \"moving_time\": 8784,\n" +
                "    \"elapsed_time\": 11123,\n" +
                "    \"elevation_gain\": 0\n" +
                "  }\n" +
                "}";

        enqueueResponse(statsJSON);
    }

    private void enqueueEmptyTotalsAndStats() {
        String totalsJSON = "{\n" +
                "\"biggest_ride_distance\": null,\n" +
                "\"biggest_climb_elevation_gain\": null,\n" +
                "\"recent_ride_totals\": {\n" +
                "\"count\": 0,\n" +
                "\"distance\": 0,\n" +
                "\"moving_time\": 0,\n" +
                "\"elapsed_time\": 0,\n" +
                "\"elevation_gain\": 0,\n" +
                "\"achievement_count\": 0\n" +
                "},\n" +
                "\"recent_run_totals\": {\n" +
                "\"count\": 1,\n" +
                "\"distance\": 7366.60009765625,\n" +
                "\"moving_time\": 2788,\n" +
                "\"elapsed_time\": 2828,\n" +
                "\"elevation_gain\": 52.69230651855469,\n" +
                "\"achievement_count\": 0\n" +
                "},\n" +
                "\"recent_swim_totals\": {\n" +
                "\"count\": 0,\n" +
                "\"distance\": 0,\n" +
                "\"moving_time\": 0,\n" +
                "\"elapsed_time\": 0,\n" +
                "\"elevation_gain\": 0,\n" +
                "\"achievement_count\": 0\n" +
                "},\n" +
                "\"ytd_ride_totals\": {\n" +
                "\"count\": 0,\n" +
                "\"distance\": 0,\n" +
                "\"moving_time\": 0,\n" +
                "\"elapsed_time\": 0,\n" +
                "\"elevation_gain\": 0\n" +
                "},\n" +
                "\"ytd_run_totals\": {\n" +
                "\"count\": 1,\n" +
                "\"distance\": 7367,\n" +
                "\"moving_time\": 2788,\n" +
                "\"elapsed_time\": 2828,\n" +
                "\"elevation_gain\": 53\n" +
                "},\n" +
                "\"ytd_swim_totals\": {\n" +
                "\"count\": 0,\n" +
                "\"distance\": 0,\n" +
                "\"moving_time\": 0,\n" +
                "\"elapsed_time\": 0,\n" +
                "\"elevation_gain\": 0\n" +
                "},\n" +
                "\"all_ride_totals\": {\n" +
                "\"count\": 0,\n" +
                "\"distance\": 0,\n" +
                "\"moving_time\": 0,\n" +
                "\"elapsed_time\": 0,\n" +
                "\"elevation_gain\": 0\n" +
                "},\n" +
                "\"all_run_totals\": {\n" +
                "\"count\": 1,\n" +
                "\"distance\": 7367,\n" +
                "\"moving_time\": 2788,\n" +
                "\"elapsed_time\": 2828,\n" +
                "\"elevation_gain\": 53\n" +
                "},\n" +
                "\"all_swim_totals\": {\n" +
                "\"count\": 0,\n" +
                "\"distance\": 0,\n" +
                "\"moving_time\": 0,\n" +
                "\"elapsed_time\": 0,\n" +
                "\"elevation_gain\": 0\n" +
                "}\n" +
                "}";
        enqueueResponse(totalsJSON);
    }
}