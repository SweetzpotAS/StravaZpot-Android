package com.sweetzpot.stravazpot.route.api;

import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.route.model.Route;
import com.sweetzpot.stravazpot.route.model.RouteSubtype;
import com.sweetzpot.stravazpot.route.model.RouteType;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RouteAPITest extends StravaAPITest {

    @Test
    public void shouldRetrieveRoute() throws Exception {
        enqueueRoute();
        RouteAPI routeAPI = givenARouteAPI();

        Route route = routeAPI.getRoute(1263727L)
                                .execute();

        assertRequestSentTo("/routes/1263727");
        assertRouteParsedCorrectly(route);
    }

    @Test
    public void shouldListRoutes() throws Exception {
        enqueueResponse("[]");
        RouteAPI routeAPI = givenARouteAPI();

        List<Route> routes = routeAPI.listRoutes(123456L)
                                .execute();

        assertRequestSentTo("/athletes/123456/routes");
    }

    private RouteAPI givenARouteAPI() {
        return new RouteAPI(givenAValidConfig());
    }

    private void assertRouteParsedCorrectly(Route route) {
        assertThat(route.getAthlete(), is(notNullValue()));
        assertThat(route.getDescription(), is(""));
        assertThat(route.getDistance(), is(equalTo(Distance.meters(173625.6f))));
        assertThat(route.getElevationGain(), is(equalTo(Distance.meters(2964.6f))));
        assertThat(route.getID(), is(1263727L));
        assertThat(route.getMap().getID(), is("r1263727"));
        assertThat(route.getMap().getSummaryPolyline(), is("qyrFxswgV|"));
        assertThat(route.getMap().getResourceState(), is(ResourceState.DETAILED));
        assertThat(route.getName(), is("New Years Resolution - Santa Cruz Century Edition"));
        assertThat(route.isPrivate(), is(false));
        assertThat(route.getResourceState(), is(ResourceState.DETAILED));
        assertThat(route.isStarred(), is(false));
        assertThat(route.getTimestamp(), is(1419669292L));
        assertThat(route.getType(), is(RouteType.RIDE));
        assertThat(route.getSubtype(), is(RouteSubtype.MTB));
        assertThat(route.getSegments().size(), is(1));
        assertThat(route.getEstimatedMovingTime(), is(3432));
    }

    private void enqueueRoute() {
        String routeJSON = "{\n" +
                "  \"athlete\": {\n" +
                "    \"id\": 265720,\n" +
                "    \"resource_state\": 2\n" +
                "  },\n" +
                "  \"description\": \"\",\n" +
                "  \"distance\": 173625.6,\n" +
                "  \"elevation_gain\": 2964.6,\n" +
                "  \"id\": 1263727,\n" +
                "  \"map\": {\n" +
                "    \"id\": \"r1263727\",\n" +
                "    \"summary_polyline\": \"qyrFxswgV|\",\n" +
                "    \"resource_state\": 3\n" +
                "  },\n" +
                "  \"name\": \"New Years Resolution - Santa Cruz Century Edition\",\n" +
                "  \"private\": false,\n" +
                "  \"resource_state\": 3,\n" +
                "  \"starred\": false,\n" +
                "  \"timestamp\": 1419669292,\n" +
                "  \"type\": 1,\n" +
                "  \"estimated_moving_time\": 3432,\n" +
                "  \"sub_type\": 2,\n" +
                "  \"segments\": [\n" +
                "    {\n" +
                "      \"id\": 3799,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"name\": \"Highway 9 - HWY236 to Skyline\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        enqueueResponse(routeJSON);
    }
}