package com.sweetzpot.stravazpot.segment.api;

import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Coordinates;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.common.model.Percentage;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Time;
import com.sweetzpot.stravazpot.segment.model.Leaderboard;
import com.sweetzpot.stravazpot.segment.model.LeaderboardEntry;
import com.sweetzpot.stravazpot.segment.model.Segment;
import com.sweetzpot.stravazpot.segment.model.SegmentEffort;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static com.sweetzpot.stravazpot.common.model.Gender.FEMALE;
import static com.sweetzpot.stravazpot.matchers.DateMatcher.isSameDate;
import static com.sweetzpot.stravazpot.segment.model.AgeGroup.AGE_25_34;
import static com.sweetzpot.stravazpot.segment.model.DateRange.THIS_WEEK;
import static com.sweetzpot.stravazpot.segment.model.WeightClass.KG_75_84;
import static com.sweetzpot.stravazpot.util.DateUtil.makeDate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SegmentAPITest extends StravaAPITest{

    @Test
    public void shouldRetrieveASegment() throws Exception {
        enqueueSegment();
        SegmentAPI segmentAPI = givenASegmentAPI();

        Segment segment = segmentAPI.getSegment(229781)
                                    .execute();

        assertRequestSentTo("/segments/229781");
        assertSegmentParsedCorrectly(segment);
    }

    @Test
    public void shouldListUsersStarredSegments() throws Exception {
        enqueueResponse("[]");
        SegmentAPI segmentAPI = givenASegmentAPI();

        List<Segment> segments = segmentAPI.listMyStarredSegments()
                                            .inPage(2)
                                            .perPage(10)
                                            .execute();

        assertRequestPathContains(
                "/segments/starred",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldListAthleteStarredSegments() throws Exception {
        enqueueResponse("[]");
        SegmentAPI segmentAPI = givenASegmentAPI();

        List<Segment> segments = segmentAPI.listStarredSegmentsByAthlete(123456)
                                            .inPage(2)
                                            .perPage(10)
                                            .execute();

        assertRequestPathContains(
                "/athletes/123456/segments/starred",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldStarASegmentWithCorrectID() throws Exception {
        enqueueSegment();
        SegmentAPI segmentAPI = givenASegmentAPI();

        Segment segment = segmentAPI.starSegment(229781)
                .execute();

        assertRequestPathContains("/segments/229781/starred");
    }

    @Test
    public void shouldStarASegment() throws Exception {
        enqueueSegment();
        SegmentAPI segmentAPI = givenASegmentAPI();

        Segment segment = segmentAPI.starSegment(229781)
                                    .execute();

        assertRequestBodyContains("starred=true");
    }

    @Test
    public void shouldUnstarASegment() throws Exception {
        enqueueSegment();
        SegmentAPI segmentAPI = givenASegmentAPI();

        Segment segment = segmentAPI.unstarSegment(229781)
                .execute();

        assertRequestBodyContains("starred=false");
    }

    @Test
    public void shouldListSegmentEfforts() throws Exception {
        enqueueResponse("[]");
        SegmentAPI segmentAPI = givenASegmentAPI();

        List<SegmentEffort> efforts = segmentAPI.listSegmentEfforts(123456)
                                                .forAthlete(98765)
                                                .startingOn(makeDate(20, Calendar.JANUARY, 2015, 12, 33, 50))
                                                .endingOn(makeDate(12, Calendar.SEPTEMBER, 2016, 22, 0, 59))
                                                .inPage(2)
                                                .perPage(10)
                                                .execute();

        assertRequestPathContains(
                "/segments/123456/all_efforts",
                "athlete_id=98765",
                "start_date_local=2015-01-20T12:33:50Z",
                "end_date_local=2016-09-12T22:00:59Z",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldRetrieveSegmentLeaderboard() throws Exception {
        enqueueLeaderboard();
        SegmentAPI segmentAPI = givenASegmentAPI();

        Leaderboard leaderboard = segmentAPI.getLeaderboardForSegment(123456)
                                            .withGender(FEMALE)
                                            .inAgeGroup(AGE_25_34)
                                            .inWeightClass(KG_75_84)
                                            .following(true)
                                            .inClub(9876)
                                            .inDateRange(THIS_WEEK)
                                            .withContextEntries(3)
                                            .inPage(2)
                                            .perPage(10)
                                            .execute();

        assertRequestPathContains(
                "/segments/123456/leaderboard",
                "gender=F",
                "age_group=25_34",
                "weight_class=75_84",
                "following=true",
                "club_id=9876",
                "date_range=this_week",
                "context_entries=3",
                "page=2",
                "per_page=10"
        );
        assertLeaderboardParsedCorrectly(leaderboard);
    }

    private SegmentAPI givenASegmentAPI() {
        return new SegmentAPI(givenAValidConfig());
    }

    private void assertSegmentParsedCorrectly(Segment segment) {
        assertThat(segment.getID(), is(229781));
        assertThat(segment.getResourceState(), is(ResourceState.DETAILED));
        assertThat(segment.getName(), is("Hawk Hill"));
        assertThat(segment.getActivityType(), is(ActivityType.RIDE));
        assertThat(segment.getDistance(), is(equalTo(Distance.meters(2684.82f))));
        assertThat(segment.getAverageGrade(), is(equalTo(Percentage.of(5.7f))));
        assertThat(segment.getMaximumGrade(), is(equalTo(Percentage.of(14.2f))));
        assertThat(segment.getElevationHigh(), is(equalTo(Distance.meters(245.3f))));
        assertThat(segment.getElevationLow(), is(equalTo(Distance.meters(92.4f))));
        assertThat(segment.getStartCoordinates(), is(equalTo(Coordinates.at(37.8331119f, -122.4834356f))));
        assertThat(segment.getEndCoordinates(), is(equalTo(Coordinates.at(37.8280722f, -122.4981393f))));
        assertThat(segment.getClimbCategory(), is(1));
        assertThat(segment.getCity(), is("San Francisco"));
        assertThat(segment.getState(), is("CA"));
        assertThat(segment.getCountry(), is("United States"));
        assertThat(segment.isPrivate(), is(false));
        assertThat(segment.isStarred(), is(false));
        assertThat(segment.getCreatedAt(), isSameDate(makeDate(1, Calendar.JANUARY, 2008, 17, 44, 0)));
        assertThat(segment.getUpdatedAt(), isSameDate(makeDate(4, Calendar.SEPTEMBER, 2013, 20, 0, 50)));
        assertThat(segment.getTotalElevationGain(), is(equalTo(Distance.meters(155.7f))));
        assertThat(segment.getMap(), is(notNullValue()));
        assertThat(segment.getEffortCount(), is(51335));
        assertThat(segment.getAthleteCount(), is(7036));
        assertThat(segment.isHazardous(), is(false));
        assertThat(segment.getStarCount(), is(0));
    }

    private void enqueueSegment() {
        String segmentJSON = "{\n" +
                "  \"id\": 229781,\n" +
                "  \"resource_state\": 3,\n" +
                "  \"name\": \"Hawk Hill\",\n" +
                "  \"activity_type\": \"Ride\",\n" +
                "  \"distance\": 2684.82,\n" +
                "  \"average_grade\": 5.7,\n" +
                "  \"maximum_grade\": 14.2,\n" +
                "  \"elevation_high\": 245.3,\n" +
                "  \"elevation_low\": 92.4,\n" +
                "  \"start_latlng\": [\n" +
                "    37.8331119,\n" +
                "    -122.4834356\n" +
                "  ],\n" +
                "  \"end_latlng\": [\n" +
                "    37.8280722,\n" +
                "    -122.4981393\n" +
                "  ],\n" +
                "  \"climb_category\": 1,\n" +
                "  \"city\": \"San Francisco\",\n" +
                "  \"state\": \"CA\",\n" +
                "  \"country\": \"United States\",\n" +
                "  \"private\": false,\n" +
                "  \"starred\": false,\n" +
                "  \"created_at\": \"2008-01-01T17:44:00Z\",\n" +
                "  \"updated_at\": \"2013-09-04T20:00:50Z\",\n" +
                "  \"total_elevation_gain\": 155.7,\n" +
                "  \"map\": {\n" +
                "    \"id\": \"s229781\",\n" +
                "    \"polyline\": \"}g|e...VJr@\",\n" +
                "    \"resource_state\": 3\n" +
                "  },\n" +
                "  \"effort_count\": 51335,\n" +
                "  \"athlete_count\": 7036,\n" +
                "  \"hazardous\": false,\n" +
                "  \"star_count\": 0\n" +
                "}";
        enqueueResponse(segmentJSON);
    }

    private void assertLeaderboardParsedCorrectly(Leaderboard leaderboard) {
        assertThat(leaderboard.getEntryCount(), is(7037));
        assertThat(leaderboard.getEntries().size(), is(2));
        LeaderboardEntry entry = leaderboard.getEntries().get(0);
        assertThat(entry.getAthleteName(), is("Jim Whimpey"));
        assertThat(entry.getAthleteID(), is(123529));
        assertThat(entry.getAthleteGender(), is(Gender.MALE));
        assertThat(entry.getAverageHeartRate(), is(190.5f));
        assertThat(entry.getAverageWatts(), is(460.8f));
        assertThat(entry.getDistance(), is(equalTo(Distance.meters(2659.89f))));
        assertThat(entry.getElapsedTime(), is(equalTo(Time.seconds(360))));
        assertThat(entry.getMovingTime(), is(equalTo(Time.seconds(360))));
        assertThat(entry.getStartDate(), isSameDate(makeDate(29, Calendar.MARCH, 2013, 13, 49, 35)));
        assertThat(entry.getStartDateLocal(), isSameDate(makeDate(29, Calendar.MARCH, 2013, 6, 49, 35)));
        assertThat(entry.getActivityID(), is(46320211));
        assertThat(entry.getEffortID(), is(801006623));
        assertThat(entry.getRank(), is(1));
        assertThat(entry.getAthleteProfile(), is("http://pics.com/227615/large.jpg"));
    }

    private void enqueueLeaderboard() {
        String leaderboardJSON = "{\n" +
                "  \"entry_count\": 7037,\n" +
                "  \"entries\": [\n" +
                "    {\n" +
                "      \"athlete_name\": \"Jim Whimpey\",\n" +
                "      \"athlete_id\": 123529,\n" +
                "      \"athlete_gender\": \"M\",\n" +
                "      \"average_hr\": 190.5,\n" +
                "      \"average_watts\": 460.8,\n" +
                "      \"distance\": 2659.89,\n" +
                "      \"elapsed_time\": 360,\n" +
                "      \"moving_time\": 360,\n" +
                "      \"start_date\": \"2013-03-29T13:49:35Z\",\n" +
                "      \"start_date_local\": \"2013-03-29T06:49:35Z\",\n" +
                "      \"activity_id\": 46320211,\n" +
                "      \"effort_id\": 801006623,\n" +
                "      \"rank\": 1,\n" +
                "      \"athlete_profile\": \"http://pics.com/227615/large.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"athlete_name\": \"Chris Zappala\",\n" +
                "      \"athlete_id\": 11673,\n" +
                "      \"athlete_gender\": \"M\",\n" +
                "      \"average_hr\": null,\n" +
                "      \"average_watts\": 368.3,\n" +
                "      \"distance\": 2705.7,\n" +
                "      \"elapsed_time\": 374,\n" +
                "      \"moving_time\": 374,\n" +
                "      \"start_date\": \"2012-02-23T14:50:16Z\",\n" +
                "      \"start_date_local\": \"2012-02-23T06:50:16Z\",\n" +
                "      \"activity_id\": 4431903,\n" +
                "      \"effort_id\": 83383918,\n" +
                "      \"rank\": 2,\n" +
                "      \"athlete_profile\": \"http://pics.com/227615/large.jpg\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        enqueueResponse(leaderboardJSON);
    }
}