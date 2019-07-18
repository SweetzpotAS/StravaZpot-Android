package com.sweetzpot.stravazpot.activity.api;

import com.sweetzpot.stravazpot.activity.model.Photo;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.Coordinates;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static com.sweetzpot.stravazpot.matchers.DateMatcher.isSameDate;
import static com.sweetzpot.stravazpot.util.DateUtil.makeDate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhotoAPITest extends StravaAPITest {

    @Test
    public void shouldRetrieveActivityPhotos() throws Exception {
        enqueuePhotos();
        PhotoAPI photoAPI = givenAPhotoAPI();

        List<Photo> photos = photoAPI.listAcivityPhotos(81121657L)
                                        .execute();

        assertRequestPathContains(
                "/activities/81121657/photos",
                "photo_sources=true"
        );
        assertPhotosParsedCorrectly(photos);
    }

    private PhotoAPI givenAPhotoAPI() {
        return new PhotoAPI(givenAValidConfig());
    }

    private void assertPhotosParsedCorrectly(List<Photo> photos) {
        assertThat(photos.size(), is(2));
        Photo photo = photos.get(0);
        assertThat(photo.getID(), is(10701863L));
        assertThat(photo.getActivityID(), is(81121657L));
        assertThat(photo.getRef(), is("http://instagram.com/p/eAvA-tir85/"));
        assertThat(photo.getUid(), is("540638730806542137_2865686"));
        assertThat(photo.getType(), is("InstagramPhoto"));
        assertThat(photo.getUploadedAt(), isSameDate(makeDate(8, Calendar.SEPTEMBER, 2013, 19, 39, 40)));
        assertThat(photo.getCreatedAt(), isSameDate(makeDate(8, Calendar.SEPTEMBER, 2013, 22, 5, 14)));
        assertThat(photo.getLocation(), is(equalTo(Coordinates.at(-122.489833333f, 37.839333333f))));
    }

    private void enqueuePhotos() {
        String photosJSON = "[\n" +
                "  {\n" +
                "    \"id\": 10701863,\n" +
                "    \"activity_id\": 81121657,\n" +
                "    \"resource_state\": 2,\n" +
                "    \"ref\": \"http://instagram.com/p/eAvA-tir85/\",\n" +
                "    \"uid\": \"540638730806542137_2865686\",\n" +
                "    \"caption\": \"City on a cottonbal\",\n" +
                "    \"type\": \"InstagramPhoto\",\n" +
                "    \"uploaded_at\": \"2013-09-08T19:39:40Z\",\n" +
                "    \"created_at\": \"2013-09-08T22:05:14Z\",\n" +
                "    \"location\": [\n" +
                "      -122.489833333,\n" +
                "      37.839333333\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 10701864,\n" +
                "    \"activity_id\": 81121657,\n" +
                "    \"resource_state\": 2,\n" +
                "    \"ref\": \"http://instagram.com/p/eAujwACr7w/\",\n" +
                "    \"uid\": \"540636722145967856_2865686\",\n" +
                "    \"caption\": \"Daytime Ninja\",\n" +
                "    \"type\": \"InstagramPhoto\",\n" +
                "    \"uploaded_at\": \"2013-09-08T19:35:41Z\",\n" +
                "    \"created_at\": \"2013-09-08T22:05:14Z\",\n" +
                "    \"location\": [\n" +
                "      -122.487666667,\n" +
                "      37.836\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        enqueueResponse(photosJSON);
    }
}