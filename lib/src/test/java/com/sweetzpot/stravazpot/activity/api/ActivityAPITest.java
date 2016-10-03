package com.sweetzpot.stravazpot.activity.api;

import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.activity.model.PhotoSource;
import com.sweetzpot.stravazpot.activity.model.PhotoSummary;
import com.sweetzpot.stravazpot.activity.model.WorkoutType;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Coordinates;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Speed;
import com.sweetzpot.stravazpot.common.model.Time;

import org.junit.Test;

import java.util.Calendar;

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

        Activity activity = activityAPI.getActivity(321934)
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

        Activity activity = activityAPI.updateActivity(321934)
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

        activityAPI.deleteActivity(321934)
                    .execute();

        assertRequestPathContains("/activities/321934");
    }

    private ActivityAPI givenAnActivityAPI() {
        return new ActivityAPI(givenAValidConfig());
    }

    private void assertActivityParsedCorrectly(Activity activity) {
        assertThat(activity.getID(), is(321934));
        assertThat(activity.getResourceState(), is(ResourceState.DETAILED));
        assertThat(activity.getExternalID(), is("2012-12-12_21-40-32-80-29011.fit"));
        assertThat(activity.getUploadID(), is(361720));
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
        assertThat(activity.getMaxSpeed(), is(equalTo(Speed.metersPerSecond(4.514f))));
        assertThat(activity.getCalories(), is(390.5f));
        assertThat(activity.hasKudoed(), is(false));
        assertThat(activity.getSegmentEfforts(), is(notNullValue()));
        assertThat(activity.getSplitsMetric(), is(notNullValue()));
        assertThat(activity.getSplitsStandard(), is(notNullValue()));
        assertThat(activity.getBestEfforts(), is(notNullValue()));
    }

    private void assertPhotoSummaryParsedCorrectly(PhotoSummary photos) {
        assertThat(photos.getCount(), is(2));
        assertThat(photos.getPrimaryPhoto().getUniqueID(), is("d64643ec9205"));
        assertThat(photos.getPrimaryPhoto().getUrls().keySet().size(), is(2));
        assertThat(photos.getPrimaryPhoto().getSource(), is(PhotoSource.STRAVA));
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
}