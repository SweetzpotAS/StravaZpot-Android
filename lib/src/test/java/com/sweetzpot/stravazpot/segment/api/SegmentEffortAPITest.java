package com.sweetzpot.stravazpot.segment.api;

import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Time;
import com.sweetzpot.stravazpot.segment.model.SegmentEffort;

import org.junit.Test;

import java.util.Calendar;

import static com.sweetzpot.stravazpot.matchers.DateMatcher.isSameDate;
import static com.sweetzpot.stravazpot.util.DateUtil.makeDate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SegmentEffortAPITest extends StravaAPITest {

    @Test
    public void shouldRetrieveSegmentEffort() throws Exception {
        enqueueSegmentEffort();
        SegmentEffortAPI segmentEffortAPI = givenASegmentEfforAPI();

        SegmentEffort segmentEffort = segmentEffortAPI.getSegmentEffort(269990681L)
                                                        .execute();

        assertRequestPathContains(
                "/segment_efforts/269990681"
        );
        assertSegmentEffortParsedCorrectly(segmentEffort);
    }

    private SegmentEffortAPI givenASegmentEfforAPI() {
        return new SegmentEffortAPI(givenAValidConfig());
    }

    private void assertSegmentEffortParsedCorrectly(SegmentEffort effort) {
        assertThat(effort.getID(), is(269990681L));
        assertThat(effort.getResourceState(), is(ResourceState.DETAILED));
        assertThat(effort.getName(), is("Geysers Road Climb"));
        assertThat(effort.getActivity(), is(notNullValue()));
        assertThat(effort.getAthlete(), is(notNullValue()));
        assertThat(effort.getElapsedTime(), is(equalTo(Time.seconds(1137))));
        assertThat(effort.getMovingTime(), is(equalTo(Time.seconds(1137))));
        assertThat(effort.getStartDate(), isSameDate(makeDate(30, Calendar.MARCH, 2013, 18, 43, 50)));
        assertThat(effort.getStartDateLocal(), isSameDate(makeDate(30, Calendar.MARCH, 2013, 11, 43, 50)));
        assertThat(effort.getDistance(), is(equalTo(Distance.meters(6001.7f))));
        assertThat(effort.getStartIndex(), is(5348));
        assertThat(effort.getEndIndex(), is(6485));
        assertThat(effort.getAverageCadence(), is(79.1f));
        assertThat(effort.getAverageWatts(), is(357.2f));
        assertThat(effort.isDeviceWatts(), is(false));
        assertThat(effort.getAverageHeartRate(), is(177.8f));
        assertThat(effort.getMaxHeartRate(), is(192.0f));
        assertThat(effort.getSegment(), is(notNullValue()));
        assertThat(effort.getPrRank(), is(2));
        assertThat(effort.getKomRank(), is(0));
        assertThat(effort.isHidden(), is(false));
    }

    private void enqueueSegmentEffort() {
        String segmentEffortJSON = "{\n" +
                "  \"id\": 269990681,\n" +
                "  \"resource_state\": 3,\n" +
                "  \"name\": \"Geysers Road Climb\",\n" +
                "  \"activity\": {\n" +
                "    \"id\": 14296826,\n" +
                "    \"resource_state\": 1\n" +
                "  },\n" +
                "  \"athlete\": {\n" +
                "    \"id\": 227615,\n" +
                "    \"resource_state\": 1\n" +
                "  },\n" +
                "  \"elapsed_time\": 1137,\n" +
                "  \"moving_time\": 1137,\n" +
                "  \"start_date\": \"2013-03-30T18:43:50Z\",\n" +
                "  \"start_date_local\": \"2013-03-30T11:43:50Z\",\n" +
                "  \"distance\": 6001.7,\n" +
                "  \"start_index\": 5348,\n" +
                "  \"end_index\": 6485,\n" +
                "  \"average_cadence\": 79.1,\n" +
                "  \"average_watts\": 357.2,\n" +
                "  \"device_watts\": false,\n" +
                "  \"average_heartrate\": 177.8,\n" +
                "  \"max_heartrate\": 192.0,\n" +
                "  \"segment\": {\n" +
                "    \"id\": 1818385,\n" +
                "    \"resource_state\": 2,\n" +
                "    \"name\": \"Geysers Road Climb\",\n" +
                "    \"activity_type\": \"Ride\",\n" +
                "    \"distance\": 6001.74,\n" +
                "    \"average_grade\": 6.2,\n" +
                "    \"maximum_grade\": 23.5,\n" +
                "    \"elevation_high\": 745.6,\n" +
                "    \"elevation_low\": 371.0,\n" +
                "    \"start_latlng\": [\n" +
                "      38.81038486,\n" +
                "      -122.85571538\n" +
                "    ],\n" +
                "    \"end_latlng\": [\n" +
                "      38.79168709,\n" +
                "      -122.82848568\n" +
                "    ],\n" +
                "    \"climb_category\": 3,\n" +
                "    \"city\": \"Cloverdale\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"country\": \"United States\",\n" +
                "    \"private\": false\n" +
                "  },\n" +
                "  \"kom_rank\": null,\n" +
                "  \"pr_rank\": 2\n" +
                "}";
        enqueueResponse(segmentEffortJSON);
    }
}