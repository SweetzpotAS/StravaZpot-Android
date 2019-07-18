package com.sweetzpot.stravazpot.stream.api;

import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.stream.model.SeriesType;
import com.sweetzpot.stravazpot.stream.model.Stream;

import org.junit.Test;

import java.util.List;

import static com.sweetzpot.stravazpot.stream.model.Resolution.LOW;
import static com.sweetzpot.stravazpot.stream.model.StreamType.DISTANCE;
import static com.sweetzpot.stravazpot.stream.model.StreamType.LATLNG;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamAPITest extends StravaAPITest{

    @Test
    public void shouldRetrieveActivityStreams() throws Exception {
        enqueueStreams();
        StreamAPI streamAPI = givenAStreamAPI();

        List<Stream> streams = streamAPI.getActivityStreams(123456L)
                                        .forTypes(LATLNG, DISTANCE)
                                        .withResolution(LOW)
                                        .withSeriesType(SeriesType.DISTANCE)
                                        .execute();

        assertRequestPathContains(
                "/activities/123456/streams/latlng,distance",
                "resolution=low",
                "series_type=distance"
        );
        assertStreamParsedCorrectly(streams);
    }

    @Test
    public void shouldRetrieveSegmentEffortStreams() throws Exception {
        enqueueStreams();
        StreamAPI streamAPI = givenAStreamAPI();

        List<Stream> streams = streamAPI.getSegmentEffortStreams(123456789L)
                .forTypes(LATLNG, DISTANCE)
                .withResolution(LOW)
                .withSeriesType(SeriesType.DISTANCE)
                .execute();

        assertRequestPathContains(
                "/segment_efforts/123456789/streams/latlng,distance",
                "resolution=low",
                "series_type=distance"
        );
    }

    @Test
    public void shouldRetrieveSegmentStreams() throws Exception {
        enqueueStreams();
        StreamAPI streamAPI = givenAStreamAPI();

        List<Stream> streams = streamAPI.getSegmentStreams(123456L)
                .forTypes(LATLNG, DISTANCE)
                .withResolution(LOW)
                .withSeriesType(SeriesType.DISTANCE)
                .execute();

        assertRequestPathContains(
                "/segments/123456/streams/latlng,distance",
                "resolution=low",
                "series_type=distance"
        );
    }

    @Test
    public void shouldRetrieveRouteStreams() throws Exception {
        enqueueStreams();
        StreamAPI streamAPI = givenAStreamAPI();

        List<Stream> streams = streamAPI.getRouteStreams(123456L)
                                        .execute();

        assertRequestPathContains(
                "/routes/123456/streams"
        );
    }

    private StreamAPI givenAStreamAPI() {
        return new StreamAPI(givenAValidConfig());
    }

    private void assertStreamParsedCorrectly(List<Stream> streams) {
        assertThat(streams.size(), is(2));
        Stream stream = streams.get(0);
        assertThat(stream.getType(), is(LATLNG));
        assertThat(stream.getData(), is(notNullValue()));
        assertThat(stream.getSeriesType(), is(SeriesType.DISTANCE));
        assertThat(stream.getResolution(), is(LOW));
    }

    private void enqueueStreams() {
        String streamsJSON = "[\n" +
                "  {\n" +
                "    \"type\": \"latlng\",\n" +
                "    \"data\": [\n" +
                "      [ 38.603734, -122.864112 ],\n" +
                "      [ 38.608798, -122.867714 ],\n" +
                "      [ 38.611205, -122.870848 ],\n" +
                "      [ 38.603579, -122.863891 ]\n" +
                "    ],\n" +
                "    \"series_type\": \"distance\",\n" +
                "    \"original_size\": 512,\n" +
                "    \"resolution\": \"low\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"distance\",\n" +
                "    \"data\": [\n" +
                "      0.0,\n" +
                "      1305.8,\n" +
                "      128136.6,\n" +
                "      129444.1\n" +
                "    ],\n" +
                "    \"series_type\": \"distance\",\n" +
                "    \"original_size\": 512,\n" +
                "    \"resolution\": \"low\"\n" +
                "  }\n" +
                "]";
        enqueueResponse(streamsJSON);
    }
}