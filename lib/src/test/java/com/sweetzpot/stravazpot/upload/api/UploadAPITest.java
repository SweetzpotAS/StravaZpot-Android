package com.sweetzpot.stravazpot.upload.api;

import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.upload.model.UploadStatus;

import org.junit.Test;

import java.io.File;

import static com.sweetzpot.stravazpot.upload.model.DataType.FIT;
import static com.sweetzpot.stravazpot.upload.model.UploadActivityType.RIDE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UploadAPITest extends StravaAPITest {

    @Test
    public void shouldUploadAFile() throws Exception {
        enqueueUploadStatus();
        UploadAPI uploadAPI = givenAnUploadAPI();

        UploadStatus uploadStatus = uploadAPI.uploadFile(new File("./test_resources/test.fit"))
                                            .withDataType(FIT)
                                            .withActivityType(RIDE)
                                            .withName("A complete ride around the city")
                                            .withDescription("No description")
                                            .isPrivate(false)
                                            .hasTrainer(false)
                                            .isCommute(false)
                                            .withExternalID("test.fit")
                                            .execute();

        assertUploadStatusParsedCorrectly(uploadStatus);
    }

    @Test
    public void shouldCheckUploadStatus() throws Exception {
        enqueueUploadStatus();
        UploadAPI uploadAPI = givenAnUploadAPI();

        UploadStatus uploadStatus = uploadAPI.checkUploadStatus(16486788L).execute();

        assertRequestPathContains("uploads/16486788");
    }

    private UploadAPI givenAnUploadAPI() {
        return new UploadAPI(givenAValidConfig());
    }

    private void enqueueUploadStatus() {
        String uploadStatusJSON = "{\n" +
                "  \"id\": 16486788,\n" +
                "  \"external_id\": \"test.fit\",\n" +
                "  \"error\": null,\n" +
                "  \"status\": \"Your activity is still being processed.\",\n" +
                "  \"activity_id\": null\n" +
                "}";

        enqueueResponse(uploadStatusJSON);
    }

    private void assertUploadStatusParsedCorrectly(UploadStatus uploadStatus) {
        assertThat(uploadStatus.getID(), is(16486788L));
        assertThat(uploadStatus.getExternalID(), is(equalTo("test.fit")));
        assertThat(uploadStatus.getError(), is(nullValue()));
        assertThat(uploadStatus.getStatus(), is(equalTo("Your activity is still being processed.")));
        assertThat(uploadStatus.getActivityID(), is(nullValue()));
    }
}