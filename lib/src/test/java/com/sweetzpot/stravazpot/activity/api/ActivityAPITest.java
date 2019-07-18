package com.sweetzpot.stravazpot.activity.api;

import com.sweetzpot.stravazpot.activity.model.Achievement;
import com.sweetzpot.stravazpot.activity.model.AchievementType;
import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.activity.model.ActivityLap;
import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.activity.model.ActivityZone;
import com.sweetzpot.stravazpot.activity.model.PhotoSource;
import com.sweetzpot.stravazpot.activity.model.PhotoSummary;
import com.sweetzpot.stravazpot.activity.model.Split;
import com.sweetzpot.stravazpot.activity.model.WorkoutType;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Coordinates;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Speed;
import com.sweetzpot.stravazpot.common.model.Temperature;
import com.sweetzpot.stravazpot.common.model.Time;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static com.sweetzpot.stravazpot.matchers.DateMatcher.isSameDate;
import static com.sweetzpot.stravazpot.util.DateUtil.makeDate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ActivityAPITest extends StravaAPITest {

    @Test
    public void shouldCreateAnActivity() throws Exception {
        enqueueActivity();
        ActivityAPI activityAPI = givenAnActivityAPI();

        Activity activity = activityAPI.createActivity("Morning run")
                                        .ofType(ActivityType.RUN)
                                        .startingOn(makeDate(3, Calendar.OCTOBER, 2016, 9, 5, 43))
                                        .withElapsedTime(Time.seconds(943))
                                        .withDescription("A tiring session")
                                        .withDistance(Distance.meters(2789))
                                        .isPrivate(false)
                                        .withTrainer(true)
                                        .withCommute(false)
                                        .execute();

        assertRequestBodyContains(
                "name=Morning%20run",
                "type=Run",
                "start_date_local=2016-10-03T09%3A05%3A43Z",
                "elapsed_time=943",
                "description=A%20tiring%20session",
                "distance=2789",
                "private=0",
                "trainer=1",
                "commute=0"
        );
    }

    @Test
    public void shouldRetrieveAnActivity() throws Exception {
        enqueueActivity();
        ActivityAPI activityAPI = givenAnActivityAPI();

        Activity activity = activityAPI.getActivity(321934L)
                                        .includeAllEfforts(true)
                                        .execute();

        assertRequestPathContains(
                "/activities/321934",
                "include_all_efforts=true"
        );
        assertActivityParsedCorrectly(activity);
    }

    @Test
    public void shoudlUpdateAnActivity() throws Exception {
        enqueueActivity();
        ActivityAPI activityAPI = givenAnActivityAPI();

        Activity activity = activityAPI.updateActivity(321934L)
                                        .changeName("Afternoon ride")
                                        .changeType(ActivityType.RIDE)
                                        .changePrivate(true)
                                        .changeCommute(true)
                                        .changeTrainer(true)
                                        .changeGearID("b321934")
                                        .changeDescription("A relaxing ride")
                                        .execute();

        assertRequestBodyContains(
                "name=Afternoon%20ride",
                "type=Ride",
                "private=true",
                "commute=true",
                "trainer=true",
                "gear_id=b321934",
                "description=A%20relaxing%20ride"
        );
    }

    @Test
    public void shouldDeleteAnActivity() throws Exception {
        enqueueResponse(204, "");
        ActivityAPI activityAPI = givenAnActivityAPI();

        activityAPI.deleteActivity(321934L)
                    .execute();

        assertRequestPathContains("/activities/321934");
    }

    @Test
    public void shouldListUsersActivities() throws Exception {
        enqueueResponse("[]");
        ActivityAPI activityAPI = givenAnActivityAPI();

        List<Activity> activities = activityAPI.listMyActivities()
                                                .before(Time.seconds(123456789))
                                                .after(Time.seconds(130000000))
                                                .inPage(2)
                                                .perPage(10)
                                                .execute();

        assertRequestPathContains(
                "/athlete/activities",
                "before=123456789",
                "after=130000000",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldListFriendsActivities() throws Exception {
        enqueueResponse("[]");
        ActivityAPI activityAPI = givenAnActivityAPI();

        List<Activity> activities = activityAPI.listFriendActivities()
                                                .before(Time.seconds(123456789))
                                                .inPage(2)
                                                .perPage(10)
                                                .execute();

        assertRequestPathContains(
                "/activities/following",
                "before=123456789",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldListRelatedActivities() throws Exception {
        enqueueResponse("[]");
        ActivityAPI activityAPI = givenAnActivityAPI();

        List<Activity> activities = activityAPI.listRelatedActivities(321934L)
                                                .inPage(2)
                                                .perPage(10)
                                                .execute();

        assertRequestPathContains(
                "/activities/321934/related",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldListActivityZones() throws Exception {
        enqueueActivityZones();
        ActivityAPI activityAPI = givenAnActivityAPI();

        List<ActivityZone> activityZones = activityAPI.listActivityZones(321934L)
                                                        .execute();

        assertRequestPathContains("/activities/321934/zones");
        assertActivityZonesParsedCorrectly(activityZones);
    }

    @Test
    public void shouldListActivityLaps() throws Exception {
        enqueueActivityLaps();
        ActivityAPI activityAPI = givenAnActivityAPI();

        List<ActivityLap> laps = activityAPI.listActivityLaps(321934L)
                                            .execute();

        assertRequestPathContains("/activities/321934/laps");
        assertActivityLapsParsedCorrectly(laps);
    }

    private ActivityAPI givenAnActivityAPI() {
        return new ActivityAPI(givenAValidConfig());
    }

    private void assertActivityParsedCorrectly(Activity activity) {
        assertThat(activity.getID(), is(321934L));
        assertThat(activity.getResourceState(), is(ResourceState.DETAILED));
        assertThat(activity.getExternalID(), is("2012-12-12_21-40-32-80-29011.fit"));
        assertThat(activity.getUploadID(), is(361720L));
        assertThat(activity.getAthlete(), is(notNullValue()));
        assertThat(activity.getName(), is("Evening Ride"));
        assertThat(activity.getDescription(), is("the best ride ever"));
        assertThat(activity.getDistance(), is(equalTo(Distance.meters(4475.4f))));
        assertThat(activity.getMovingTime(), is(equalTo(Time.seconds(1303))));
        assertThat(activity.getElapsedTime(), is(equalTo(Time.seconds(1333))));
        assertThat(activity.getTotalElevationGain(), is(equalTo(Distance.meters(154.5f))));
        assertThat(activity.getElevationHigh(), is(equalTo(Distance.meters(331.4f))));
        assertThat(activity.getElevationLow(), is(equalTo(Distance.meters(276.1f))));
        assertThat(activity.getType(), is(ActivityType.RUN));
        assertThat(activity.getStartDate(), isSameDate(makeDate(13, Calendar.DECEMBER, 2012, 3, 43, 19)));
        assertThat(activity.getStartDateLocal(), isSameDate(makeDate(12, Calendar.DECEMBER, 2012, 19, 43, 19)));
        assertThat(activity.getTimezone(), is("(GMT-08:00) America/Los_Angeles"));
        assertThat(activity.getStartCoordinates(), is(equalTo(Coordinates.at(37.8f, -122.27f))));
        assertThat(activity.getEndCoordinates(), is(equalTo(Coordinates.at(37.8f, -122.27f))));
        assertThat(activity.getAchievementCount(), is(6));
        assertThat(activity.getKudosCount(), is(1));
        assertThat(activity.getCommentCount(), is(1));
        assertThat(activity.getAthleteCount(), is(1));
        assertThat(activity.getPhotoCount(), is(0));
        assertThat(activity.getTotalPhotoCount(), is(0));
        assertThat(activity.getPhotos(), is(notNullValue()));
        assertPhotoSummaryParsedCorrectly(activity.getPhotos());
        assertThat(activity.getMap(), is(notNullValue()));
        assertThat(activity.isTrainer(), is(false));
        assertThat(activity.isCommute(), is(false));
        assertThat(activity.isManual(), is(false));
        assertThat(activity.isPrivate(), is(false));
        assertThat(activity.isFlagged(), is(false));
        assertThat(activity.getWorkoutType(), is(WorkoutType.RUN_LONGRUN));
        assertThat(activity.getGear(), is(notNullValue()));
        assertThat(activity.getAverageSpeed(), is(equalTo(Speed.metersPerSecond(3.4f))));
        assertThat(activity.getAverageTemperature(), is(equalTo(Temperature.celsiusDegrees(36.2f))));
        assertThat(activity.getMaxSpeed(), is(equalTo(Speed.metersPerSecond(4.514f))));
        assertThat(activity.getCalories(), is(390.5f));
        assertThat(activity.hasKudoed(), is(false));
        assertThat(activity.getSegmentEfforts(), is(notNullValue()));
        assertAchievementsParsedCorrectly(activity.getSegmentEfforts().get(0).getAchievements().get(0));
        assertThat(activity.getSplitsMetric().size(), is(2));
        assertSplitParsedCorrectly(activity.getSplitsMetric().get(0));
        assertThat(activity.getSplitsStandard(), is(notNullValue()));
        assertThat(activity.getBestEfforts(), is(notNullValue()));
    }

    private void assertPhotoSummaryParsedCorrectly(PhotoSummary photos) {
        assertThat(photos.getCount(), is(2));
        assertThat(photos.getPrimaryPhoto().getUniqueID(), is("d64643ec9205"));
        assertThat(photos.getPrimaryPhoto().getUrls().keySet().size(), is(2));
        assertThat(photos.getPrimaryPhoto().getSource(), is(PhotoSource.STRAVA));
    }

    private void assertSplitParsedCorrectly(Split split) {
        assertThat(split.getDistance(), is(equalTo(Distance.meters(1002.5f))));
        assertThat(split.getElapsedTime(), is(equalTo(Time.seconds(276))));
        assertThat(split.getElevationDifference(), is(equalTo(Distance.meters(0))));
        assertThat(split.getMovingTime(), is(equalTo(Time.seconds(276))));
        assertThat(split.getSplit(), is(1));
    }

    private void assertAchievementsParsedCorrectly(Achievement achievement) {
        assertThat(achievement.getTypeID(), is(AchievementType.OVERALL));
        assertThat(achievement.getType(), is("overall"));
        assertThat(achievement.getRank(), is(2));
    }

    private void enqueueActivity() {
        String activityJSON = "{\n" +
                "  \"id\": 321934,\n" +
                "  \"resource_state\": 3,\n" +
                "  \"external_id\": \"2012-12-12_21-40-32-80-29011.fit\",\n" +
                "  \"upload_id\": 361720,\n" +
                "  \"athlete\": {\n" +
                "    \"id\": 227615,\n" +
                "    \"resource_state\": 1\n" +
                "  },\n" +
                "  \"name\": \"Evening Ride\",\n" +
                "  \"description\": \"the best ride ever\",\n" +
                "  \"distance\": 4475.4,\n" +
                "  \"moving_time\": 1303,\n" +
                "  \"elapsed_time\": 1333,\n" +
                "  \"total_elevation_gain\": 154.5,\n" +
                "  \"elev_high\": 331.4,\n" +
                "  \"elev_low\": 276.1,\n" +
                "  \"type\": \"Run\",\n" +
                "  \"start_date\": \"2012-12-13T03:43:19Z\",\n" +
                "  \"start_date_local\": \"2012-12-12T19:43:19Z\",\n" +
                "  \"timezone\": \"(GMT-08:00) America/Los_Angeles\",\n" +
                "  \"start_latlng\": [\n" +
                "    37.8,\n" +
                "    -122.27\n" +
                "  ],\n" +
                "  \"end_latlng\": [\n" +
                "    37.8,\n" +
                "    -122.27\n" +
                "  ],\n" +
                "  \"achievement_count\": 6,\n" +
                "  \"kudos_count\": 1,\n" +
                "  \"comment_count\": 1,\n" +
                "  \"athlete_count\": 1,\n" +
                "  \"photo_count\": 0,\n" +
                "  \"total_photo_count\": 0,\n" +
                "  \"photos\": {\n" +
                "    \"count\": 2,\n" +
                "    \"primary\": {\n" +
                "      \"id\": null,\n" +
                "      \"source\": 1,\n" +
                "      \"unique_id\": \"d64643ec9205\",\n" +
                "      \"urls\": {\n" +
                "        \"100\": \"http://pics.com/28b9d28f-128x71.jpg\",\n" +
                "        \"600\": \"http://pics.com/28b9d28f-768x431.jpg\"\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"map\": {\n" +
                "    \"id\": \"a32193479\",\n" +
                "    \"polyline\": \"kiteFpCBCD]\",\n" +
                "    \"summary_polyline\": \"{cteFjcaBkCx@gEz@\",\n" +
                "    \"resource_state\": 3\n" +
                "  },\n" +
                "  \"trainer\": false,\n" +
                "  \"commute\": false,\n" +
                "  \"manual\": false,\n" +
                "  \"private\": false,\n" +
                "  \"flagged\": false,\n" +
                "  \"workout_type\": 2,\n" +
                "  \"gear\": {\n" +
                "    \"id\": \"g138727\",\n" +
                "    \"primary\": true,\n" +
                "    \"name\": \"Nike Air\",\n" +
                "    \"distance\": 88983.1,\n" +
                "    \"resource_state\": 2\n" +
                "  },\n" +
                "  \"average_speed\": 3.4,\n" +
                "  \"average_temp\": 36.2,\n" +
                "  \"max_speed\": 4.514,\n" +
                "  \"calories\": 390.5,\n" +
                "  \"has_kudoed\": false,\n" +
                "  \"segment_efforts\": [\n" +
                "    {\n" +
                "      \"id\": 543755075,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Dash for the Ferry\",\n" +
                "      \"segment\": {\n" +
                "        \"id\": 2417854,\n" +
                "        \"resource_state\": 2,\n" +
                "        \"name\": \"Dash for the Ferry\",\n" +
                "        \"activity_type\": \"Run\",\n" +
                "        \"distance\": 1055.11,\n" +
                "        \"average_grade\": -0.1,\n" +
                "        \"maximum_grade\": 2.7,\n" +
                "        \"elevation_high\": 4.7,\n" +
                "        \"elevation_low\": 2.7,\n" +
                "        \"start_latlng\": [\n" +
                "          37.7905785,\n" +
                "          -122.27015622\n" +
                "        ],\n" +
                "        \"end_latlng\": [\n" +
                "          37.79536649,\n" +
                "          -122.2796434\n" +
                "        ],\n" +
                "        \"climb_category\": 0,\n" +
                "        \"city\": \"Oakland\",\n" +
                "        \"state\": \"CA\",\n" +
                "        \"country\": \"United States\",\n" +
                "        \"private\": false\n" +
                "      },\n" +
                "      \"activity\": {\n" +
                "        \"id\": 32193479,\n" +
                "        \"resource_state\": 1\n" +
                "      },\n" +
                "      \"athlete\": {\n" +
                "        \"id\": 3776,\n" +
                "        \"resource_state\": 1\n" +
                "      },\n" +
                "      \"kom_rank\": 2,\n" +
                "      \"pr_rank\": 1,\n" +
                "      \"elapsed_time\": 304,\n" +
                "      \"moving_time\": 304,\n" +
                "      \"start_date\": \"2012-12-13T03:48:14Z\",\n" +
                "      \"start_date_local\": \"2012-12-12T19:48:14Z\",\n" +
                "      \"distance\": 1052.33,\n" +
                "      \"start_index\": 5348,\n" +
                "      \"end_index\": 6485,\n" +
                "      \"hidden\": false,\n" +
                "      \"achievements\": [\n" +
                "        {\n" +
                "          \"type_id\": 2,\n" +
                "          \"type\": \"overall\",\n" +
                "          \"rank\": 2\n" +
                "        },\n" +
                "        {\n" +
                "          \"type_id\": 3,\n" +
                "          \"type\": \"pr\",\n" +
                "          \"rank\": 1\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"splits_metric\": [\n" +
                "    {\n" +
                "      \"distance\": 1002.5,\n" +
                "      \"elapsed_time\": 276,\n" +
                "      \"elevation_difference\": 0,\n" +
                "      \"moving_time\": 276,\n" +
                "      \"split\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"distance\": 475.7,\n" +
                "      \"elapsed_time\": 139,\n" +
                "      \"elevation_difference\": 0,\n" +
                "      \"moving_time\": 139,\n" +
                "      \"split\": 5\n" +
                "    }\n" +
                "  ],\n" +
                "  \"splits_standard\": [\n" +
                "    {\n" +
                "      \"distance\": 1255.9,\n" +
                "      \"elapsed_time\": 382,\n" +
                "      \"elevation_difference\": 3.2,\n" +
                "      \"moving_time\": 382,\n" +
                "      \"split\": 3\n" +
                "    }\n" +
                "  ],\n" +
                "  \"best_efforts\": [\n" +
                "    {\n" +
                "      \"id\": 273063933,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"400m\",\n" +
                "      \"segment\": null,\n" +
                "      \"activity\": {\n" +
                "        \"id\": 32193479\n" +
                "      },\n" +
                "      \"athlete\": {\n" +
                "        \"id\": 3776\n" +
                "      },\n" +
                "      \"kom_rank\": null,\n" +
                "      \"pr_rank\": null,\n" +
                "      \"elapsed_time\": 105,\n" +
                "      \"moving_time\": 106,\n" +
                "      \"start_date\": \"2012-12-13T03:43:19Z\",\n" +
                "      \"start_date_local\": \"2012-12-12T19:43:19Z\",\n" +
                "      \"distance\": 400,\n" +
                "      \"achievements\": [\n" +
                "\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 273063935,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"1/2 mile\",\n" +
                "      \"segment\": null,\n" +
                "      \"activity\": {\n" +
                "        \"id\": 32193479\n" +
                "      },\n" +
                "      \"athlete\": {\n" +
                "        \"id\": 3776\n" +
                "      },\n" +
                "      \"kom_rank\": null,\n" +
                "      \"pr_rank\": null,\n" +
                "      \"elapsed_time\": 219,\n" +
                "      \"moving_time\": 220,\n" +
                "      \"start_date\": \"2012-12-13T03:43:19Z\",\n" +
                "      \"start_date_local\": \"2012-12-12T19:43:19Z\",\n" +
                "      \"distance\": 805,\n" +
                "      \"achievements\": [\n" +
                "\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        enqueueResponse(activityJSON);
    }

    private void assertActivityZonesParsedCorrectly(List<ActivityZone> activityZones) {
        assertThat(activityZones.size(), is(2));
        ActivityZone zone = activityZones.get(0);
        assertThat(zone.getScore(), is(215));
        assertThat(zone.getDistributionBuckets().size(), is(5));
        assertThat((double) (zone.getDistributionBuckets().get(0).getMin()), is(0.0));
        assertThat((double) (zone.getDistributionBuckets().get(0).getMax()), is(115.0));
        assertThat(zone.getDistributionBuckets().get(0).getTime(), is(1735L));
        assertThat(zone.getType(), is("heartrate"));
        assertThat(zone.getResourceState(), is(ResourceState.DETAILED));
        assertThat(zone.isSensorBased(), is(true));
        assertThat(zone.getPoints(), is(119));
        assertThat(zone.hasCustomZones(), is(false));
        assertThat(zone.getMax(), is(196));
    }

    private void enqueueActivityZones() {
        String activityZonesJSON = "[\n" +
                "  {\n" +
                "    \"score\": 215,\n" +
                "    \"distribution_buckets\": [\n" +
                "      { \"min\": 0,   \"max\":115,  \"time\": 1735 },\n" +
                "      { \"min\": 115, \"max\": 152, \"time\": 5966 },\n" +
                "      { \"min\": 152, \"max\": 171, \"time\": 4077 },\n" +
                "      { \"min\": 171, \"max\": 190, \"time\": 4238 },\n" +
                "      { \"min\": 190, \"max\": -1,  \"time\": 36 }\n" +
                "    ],\n" +
                "    \"type\": \"heartrate\",\n" +
                "    \"resource_state\": 3,\n" +
                "    \"sensor_based\": true,\n" +
                "    \"points\": 119,\n" +
                "    \"custom_zones\": false,\n" +
                "    \"max\": 196\n" +
                "  },\n" +
                "  {\n" +
                "    \"distribution_buckets\": [\n" +
                "      { \"min\": 0,   \"max\": 0,   \"time\": 3043 },\n" +
                "      { \"min\": 0,   \"max\": 50,  \"time\": 999 },\n" +
                "      { \"min\": 50,  \"max\": 100, \"time\": 489 },\n" +
                "      { \"min\": 100, \"max\": 150, \"time\": 737 },\n" +
                "      { \"min\": 150, \"max\": 200, \"time\": 1299 },\n" +
                "      { \"min\": 200, \"max\": 250, \"time\": 1478 },\n" +
                "      { \"min\": 250, \"max\": 300, \"time\": 1523 },\n" +
                "      { \"min\": 300, \"max\": 350, \"time\": 2154 },\n" +
                "      { \"min\": 350, \"max\": 400, \"time\": 2226 },\n" +
                "      { \"min\": 400, \"max\": 450, \"time\": 1181 },\n" +
                "      { \"min\": 450, \"max\": -1,  \"time\": 923 }\n" +
                "    ],\n" +
                "    \"type\": \"power\",\n" +
                "    \"resource_state\": 3,\n" +
                "    \"sensor_based\": true\n" +
                "  }\n" +
                "]";

        enqueueResponse(activityZonesJSON);
    }

    private void assertActivityLapsParsedCorrectly(List<ActivityLap> laps) {
        assertThat(laps.size(), is(1));
        ActivityLap lap = laps.get(0);
        assertThat(lap.getID(), is(401614652L));
        assertThat(lap.getResourceState(), is(ResourceState.SUMMARY));
        assertThat(lap.getName(), is("Lap 1"));
        assertThat(lap.getActivity(), is(notNullValue()));
        assertThat(lap.getAthlete(), is(notNullValue()));
        assertThat(lap.getElapsedTime(), is(equalTo(Time.seconds(7092))));
        assertThat(lap.getMovingTime(), is(equalTo(Time.seconds(6870))));
        assertThat(lap.getStartDate(), isSameDate(makeDate(2, Calendar.NOVEMBER, 2013, 17, 39, 37)));
        assertThat(lap.getStartDateLocal(), isSameDate(makeDate(2, Calendar.NOVEMBER, 2013, 10, 39, 37)));
        assertThat(lap.getDistance(), is(equalTo(Distance.meters(42121.5f))));
        assertThat(lap.getStartIndex(), is(0));
        assertThat(lap.getEndIndex(), is(6826));
        assertThat(lap.getTotalElevationGain(), is(equalTo(Distance.meters(766.0f))));
        assertThat(lap.getMaxSpeed(), is(equalTo(Speed.metersPerSecond(16.8f))));
        assertThat(lap.getAverageSpeed(), is(equalTo(Speed.metersPerSecond(5.9f))));
        assertThat(lap.getAverageCadence(), is(64.7f));
        assertThat(lap.getAverageWatts(), is(156.2f));
        assertThat(lap.isDeviceWatts(), is(false));
        assertThat(lap.hasHeartRate(), is(true));
        assertThat(lap.getAverageHeartRate(), is(141.1f));
        assertThat(lap.getMaxHeartRate(), is(176.0f));
        assertThat(lap.getLapIndex(), is(1));
    }

    private void enqueueActivityLaps() {
        String activityLapsJSON = "[\n" +
                "  {\n" +
                "    \"id\": 401614652,\n" +
                "    \"resource_state\": 2,\n" +
                "    \"name\": \"Lap 1\",\n" +
                "    \"activity\": {\n" +
                "      \"id\": 123\n" +
                "    },\n" +
                "    \"athlete\": {\n" +
                "      \"id\": 227615\n" +
                "    },\n" +
                "    \"elapsed_time\": 7092,\n" +
                "    \"moving_time\": 6870,\n" +
                "    \"start_date\": \"2013-11-02T17:39:37Z\",\n" +
                "    \"start_date_local\": \"2013-11-02T10:39:37Z\",\n" +
                "    \"distance\": 42121.5,\n" +
                "    \"start_index\": 0,\n" +
                "    \"end_index\": 6826,\n" +
                "    \"total_elevation_gain\": 766.0,\n" +
                "    \"average_speed\": 5.9,\n" +
                "    \"max_speed\": 16.8,\n" +
                "    \"average_cadence\": 64.7,\n" +
                "    \"average_watts\": 156.2,\n" +
                "    \"device_watts\": false,\n" +
                "    \"has_heartrate\": true,\n" +
                "    \"average_heartrate\": 141.1,\n" +
                "    \"max_heartrate\": 176.0,\n" +
                "    \"lap_index\": 1\n" +
                "  }\n" +
                "]";

        enqueueResponse(activityLapsJSON);
    }
}