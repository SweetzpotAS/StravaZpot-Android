package com.sweetzpot.stravazpot.segment.api;

import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Coordinates;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.common.model.Percentage;
import com.sweetzpot.stravazpot.common.model.Time;
import com.sweetzpot.stravazpot.segment.model.Bounds;
import com.sweetzpot.stravazpot.segment.model.Leaderboard;
import com.sweetzpot.stravazpot.segment.model.LeaderboardEntry;
import com.sweetzpot.stravazpot.segment.model.Segment;
import com.sweetzpot.stravazpot.segment.model.SegmentEffort;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static com.sweetzpot.stravazpot.common.model.Gender.FEMALE;
import static com.sweetzpot.stravazpot.common.model.ResourceState.DETAILED;
import static com.sweetzpot.stravazpot.matchers.DateMatcher.isSameDate;
import static com.sweetzpot.stravazpot.segment.model.AgeGroup.AGE_25_34;
import static com.sweetzpot.stravazpot.segment.model.DateRange.THIS_WEEK;
import static com.sweetzpot.stravazpot.segment.model.ExploreType.RUNNING;
import static com.sweetzpot.stravazpot.segment.model.WeightClass.KG_75_84;
import static com.sweetzpot.stravazpot.util.DateUtil.makeDate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SegmentAPITest extends StravaAPITest{

    @Test
    public void shouldRetrieveASegment() throws Exception {
        enqueueSegment();
        SegmentAPI segmentAPI = givenASegmentAPI();

        Segment segment = segmentAPI.getSegment(229781L)
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

        List<Segment> segments = segmentAPI.listStarredSegmentsByAthlete(123456L)
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

        Segment segment = segmentAPI.starSegment(229781L)
                .execute();

        assertRequestPathContains("/segments/229781/starred");
    }

    @Test
    public void shouldStarASegment() throws Exception {
        enqueueSegment();
        SegmentAPI segmentAPI = givenASegmentAPI();

        Segment segment = segmentAPI.starSegment(229781L)
                                    .execute();

        assertRequestBodyContains("starred=true");
    }

    @Test
    public void shouldUnstarASegment() throws Exception {
        enqueueSegment();
        SegmentAPI segmentAPI = givenASegmentAPI();

        Segment segment = segmentAPI.unstarSegment(229781L)
                .execute();

        assertRequestBodyContains("starred=false");
    }

    @Test
    public void shouldListSegmentEfforts() throws Exception {
        enqueueResponse("[]");
        SegmentAPI segmentAPI = givenASegmentAPI();

        List<SegmentEffort> efforts = segmentAPI.listSegmentEfforts(123456L)
                                                .forAthlete(98765L)
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

        Leaderboard leaderboard = segmentAPI.getLeaderboardForSegment(123456L)
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

    @Test
    public void shouldExploreSegments() throws Exception {
        enqueueExploreSegments();
        SegmentAPI segmentAPI = givenASegmentAPI();

        List<Segment> segments = segmentAPI.exploreSegmentsInRegion(Bounds.with(Coordinates.at(-42, 73), Coordinates.at(27, 128)))
                                            .forActivityType(RUNNING)
                                            .withMinimumClimbCategory(3)
                                            .withMaximumClimbCategory(8)
                                            .execute();

        assertRequestPathContains(
                "/segments/explore",
                "bounds=-42.0,73.0,27.0,128.0",
                "activity_type=running",
                "min_cat=3",
                "max_cat=8"
        );
    }

    private SegmentAPI givenASegmentAPI() {
        return new SegmentAPI(givenAValidConfig());
    }

    private void assertSegmentParsedCorrectly(Segment segment) {
        assertThat(segment.getID(), is(229781L));
        assertThat(segment.getResourceState(), is(DETAILED));
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
        assertThat(segment.getMap().getID(), is("s229781"));
        assertThat(segment.getMap().getPolyline(), is("}g|e...VJr@"));
        assertThat(segment.getMap().getResourceState(), is(DETAILED));
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
        assertThat(entry.getAthleteID(), is(123529L));
        assertThat(entry.getAthleteGender(), is(Gender.MALE));
        assertThat(entry.getAverageHeartRate(), is(190.5f));
        assertThat(entry.getAverageWatts(), is(460.8f));
        assertThat(entry.getDistance(), is(equalTo(Distance.meters(2659.89f))));
        assertThat(entry.getElapsedTime(), is(equalTo(Time.seconds(360))));
        assertThat(entry.getMovingTime(), is(equalTo(Time.seconds(360))));
        assertThat(entry.getStartDate(), isSameDate(makeDate(29, Calendar.MARCH, 2013, 13, 49, 35)));
        assertThat(entry.getStartDateLocal(), isSameDate(makeDate(29, Calendar.MARCH, 2013, 6, 49, 35)));
        assertThat(entry.getActivityID(), is(46320211L));
        assertThat(entry.getEffortID(), is(801006623L));
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

    private void enqueueExploreSegments() {
        String segmentsJSON = "{\n" +
                "  \"segments\": [\n" +
                "    {\n" +
                "      \"id\": 5462122,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Traditions Downhill\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": -1.2,\n" +
                "      \"start_latlng\": [\n" +
                "        30.599526,\n" +
                "        -96.385803\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.612589,\n" +
                "        -96.397798\n" +
                "      ],\n" +
                "      \"elev_difference\": 31.3,\n" +
                "      \"distance\": 2054,\n" +
                "      \"points\": \"_nwyDhjhkQi@v@w@zAkB|B}AvAgCfBuAx@_@\\\\eAnAYb@mAvAmAbBq@t@kAxAw@bAIPqCnDo@`BkAxDS`@e@h@[T]Ni@H]B_@Ck@IyA_@mAYq@CaEVmBFe@Dc@Pa@\\\\MRSf@GVoAtKKp@Sj@KR]d@o@j@OJc@Ns@Ha@Bc@E_@I\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 9583574,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Into the Mines of Moria\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": -0.7,\n" +
                "      \"start_latlng\": [\n" +
                "        30.613478,\n" +
                "        -96.344982\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.611537,\n" +
                "        -96.34709\n" +
                "      ],\n" +
                "      \"elev_difference\": 9.8,\n" +
                "      \"distance\": 298.7,\n" +
                "      \"points\": \"eezyDdk`kQh@d@zAz@pDpFVXf@d@JN\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5436847,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"F&B Road - pre stoplight glitch...\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": -0.3,\n" +
                "      \"start_latlng\": [\n" +
                "        30.621958,\n" +
                "        -96.358991\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.611386,\n" +
                "        -96.370663\n" +
                "      ],\n" +
                "      \"elev_difference\": 6.3,\n" +
                "      \"distance\": 1626.2,\n" +
                "      \"points\": \"ez{yDvbckQ~BfC`@f@d@b@~@bAZV`AdAnBxBf@r@vA~AzDbEfBpBfClC`CzCtDdEV\\\\d@d@vAdBXXz@fAjDrDvAjBd@d@^h@jArA^l@dBtB\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1190203,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Silver hill-hill pt2\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": 2.2,\n" +
                "      \"start_latlng\": [\n" +
                "        30.642852,\n" +
                "        -96.4535356\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.6414042,\n" +
                "        -96.4551745\n" +
                "      ],\n" +
                "      \"elev_difference\": 4.9,\n" +
                "      \"distance\": 224.6,\n" +
                "      \"points\": \"y|_zDrqukQ`HfI\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 12320594,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Windmeadows Dr. to Barron Rd.\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": 0.7,\n" +
                "      \"start_latlng\": [\n" +
                "        30.562544,\n" +
                "        -96.289809\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.560465,\n" +
                "        -96.287359\n" +
                "      ],\n" +
                "      \"elev_difference\": 3.3,\n" +
                "      \"distance\": 330,\n" +
                "      \"points\": \"{fpyDhrujQTOb@o@NOb@s@|AkBzDaFVW\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 8977750,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"graham up hill\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": 2.2,\n" +
                "      \"start_latlng\": [\n" +
                "        30.551135,\n" +
                "        -96.329607\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.553431,\n" +
                "        -96.32701\n" +
                "      ],\n" +
                "      \"elev_difference\": 8,\n" +
                "      \"distance\": 355.6,\n" +
                "      \"points\": \"q_nyD`k}jQyDkEqG{H\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3591056,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Roller Coaster Trail-1\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": -0.4,\n" +
                "      \"start_latlng\": [\n" +
                "        30.703297,\n" +
                "        -96.465861\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.704132,\n" +
                "        -96.460136\n" +
                "      ],\n" +
                "      \"elev_difference\": 7.1,\n" +
                "      \"distance\": 893.5,\n" +
                "      \"points\": \"qvkzDt~wkQEDBIJERFJXPGRWNg@Cg@@SRENON[A}@@a@Ki@a@w@ASFMVOP[@]Ma@k@s@CWLUXKRBAb@HLLDHP\\\\G@SQe@I[BWEY[c@gAk@{@q@KYC]k@y@LMB_@Q]UU[QUS?IGQOQQICECDCCCG?[\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 11587059,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"The downhill surge into Bryan\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": -0.5,\n" +
                "      \"start_latlng\": [\n" +
                "        30.698618,\n" +
                "        -96.40323\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.681176,\n" +
                "        -96.388355\n" +
                "      ],\n" +
                "      \"elev_difference\": 20.8,\n" +
                "      \"distance\": 2501.1,\n" +
                "      \"points\": \"iyjzDdwkkQxAkBxHgKbBwBxAaBbBsAvByA|A_B`EqExLgNl@k@pA}@tAe@jB]b@EjBCrDRtCCPChBe@v@[r@a@tAoAhKsLdDwDpCoDzBkC\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 10100990,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Copperfield South \",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": 0,\n" +
                "      \"start_latlng\": [\n" +
                "        30.661623,\n" +
                "        -96.302771\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.65077,\n" +
                "        -96.295786\n" +
                "      ],\n" +
                "      \"elev_difference\": 8.7,\n" +
                "      \"distance\": 1874.3,\n" +
                "      \"points\": \"crczDjcxjQ^Vz@h@JLLHnA`Ah@Z~@t@f@Xn@N\\\\FnB@RBNCl@Db@@n@F^JLBlCt@h@HpAd@hATtA\\\\LFL?l@LR@JE\\\\D`AINCl@UXUHOp@y@FMhAqA^i@r@yAh@gBRe@TgAHQd@_CFiA@kAL{APuA@e@DOF}@HmBHa@NeAJ_@Lw@L]@M^gAb@_BLY^e@Lc@AGD[TUTKPMNUBM\",\n" +
                "      \"starred\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 12038469,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"60 heading east\",\n" +
                "      \"climb_category\": 0,\n" +
                "      \"climb_category_desc\": \"NC\",\n" +
                "      \"avg_grade\": 0.2,\n" +
                "      \"start_latlng\": [\n" +
                "        30.539395,\n" +
                "        -96.448925\n" +
                "      ],\n" +
                "      \"end_latlng\": [\n" +
                "        30.605207,\n" +
                "        -96.360478\n" +
                "      ],\n" +
                "      \"elev_difference\": 33.4,\n" +
                "      \"distance\": 11332.2,\n" +
                "      \"points\": \"evkyDxttkQf@m@DQUgA]e@qFmGkOyOoAyAs^y_@qSqTsA{AeD{D_QqTsAeB}@sAcAkBgA_Cm@eBaA_EeVomA}@aD}@uBc@aAu@wAcAaBsCoD{\\\\ga@_FwF_KsKaG{Gob@ki@oGqHwHkIeJeKuRkVoU}XeDcEeGgIqDmFUu@IO{AoBqCmEgCgEqAgCU[a@a@oHiMaFcIgAuB{GiKy@mAeAiAqAaBuL{OuCaD_DwD\",\n" +
                "      \"starred\": false\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        enqueueResponse(segmentsJSON);
    }
}