package com.sweetzpot.stravazpot.gear.api;

import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.gear.model.FrameType;
import com.sweetzpot.stravazpot.gear.model.Gear;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GearAPITest extends StravaAPITest{

    @Test
    public void shouldRetrieveGear() throws Exception {
        enqueueGear();
        GearAPI gearAPI = givenAGearAPI();

        Gear gear = gearAPI.getGear("b105763")
                            .execute();

        assertRequestPathContains("/gear/b105763");
        assertGearParsedCorrectly(gear);
    }

    private GearAPI givenAGearAPI() {
        return new GearAPI(givenAValidConfig());
    }

    private void assertGearParsedCorrectly(Gear gear) {
        assertThat(gear.getID(), is("b105763"));
        assertThat(gear.isPrimary(), is(false));
        assertThat(gear.getName(), is("Cannondale TT"));
        assertThat(gear.getDistance(), is(Distance.meters(476612.8f)));
        assertThat(gear.getResourceState(), is(ResourceState.DETAILED));
        assertThat(gear.getBrandName(), is("Cannondale"));
        assertThat(gear.getModelName(), is("Slice"));
        assertThat(gear.getFrameType(), is(FrameType.TIME_TRIAL));
        assertThat(gear.getDescription(), is("Best bike EVER!!"));
    }

    private void enqueueGear() {
        String gearJSON = "{\n" +
                "  \"id\": \"b105763\",\n" +
                "  \"primary\": false,\n" +
                "  \"name\": \"Cannondale TT\",\n" +
                "  \"distance\": 476612.8,\n" +
                "  \"resource_state\": 3,\n" +
                "  \"brand_name\": \"Cannondale\",\n" +
                "  \"model_name\": \"Slice\",\n" +
                "  \"frame_type\": 4,\n" +
                "  \"description\": \"Best bike EVER!!\"\n" +
                "}";
        enqueueResponse(gearJSON);
    }


}