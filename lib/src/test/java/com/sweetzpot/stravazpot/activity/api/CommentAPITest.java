package com.sweetzpot.stravazpot.activity.api;

import com.sweetzpot.stravazpot.activity.model.Comment;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.model.ResourceState;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static com.sweetzpot.stravazpot.matchers.DateMatcher.isSameDate;
import static com.sweetzpot.stravazpot.util.DateUtil.makeDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommentAPITest extends StravaAPITest {

    @Test
    public void shouldListActivityComments() throws Exception {
        enqueueComments();
        CommentAPI commentAPI = givenACommentAPI();

        List<Comment> comments = commentAPI.listActivityComments(123L)
                                            .inPage(2)
                                            .perPage(10)
                                            .execute();

        assertRequestPathContains(
                "/activities/123/comments",
                "page=2",
                "per_page=10"
        );
        assertCommentsParsedCorrectly(comments);
    }

    private CommentAPI givenACommentAPI() {
        return new CommentAPI(givenAValidConfig());
    }

    private void assertCommentsParsedCorrectly(List<Comment> comments) {
        assertThat(comments.size(), is(1));
        Comment comment = comments.get(0);
        assertThat(comment.getID(), is(26L));
        assertThat(comment.getActivityID(), is(123L));
        assertThat(comment.getResourceState(), is(ResourceState.SUMMARY));
        assertThat(comment.getText(), is("Nice ride!!!"));
        assertThat(comment.getAthlete(), is(notNullValue()));
        assertThat(comment.getCreatedAt(), isSameDate(makeDate(6, Calendar.SEPTEMBER, 2013, 21, 7, 22)));
    }

    private void enqueueComments() {
        String commentsJSON = "[\n" +
                "  {\n" +
                "    \"id\": 26,\n" +
                "    \"activity_id\": 123,\n" +
                "    \"resource_state\": 2,\n" +
                "    \"text\": \"Nice ride!!!\",\n" +
                "    \"athlete\": {\n" +
                "      \"id\": 227615,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"firstname\": \"John\",\n" +
                "      \"lastname\": \"Applestrava\",\n" +
                "      \"profile_medium\": \"http://pics.com/227615/medium.jpg\",\n" +
                "      \"profile\": \"http://pics.com/227615//large.jpg\",\n" +
                "      \"city\": \"San Francisco\",\n" +
                "      \"state\": \"California\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"sex\": \"M\",\n" +
                "      \"friend\": \"accepted\",\n" +
                "      \"follower\": \"accepted\",\n" +
                "      \"premium\": true,\n" +
                "      \"created_at\": \"2009-08-26T13:42:05Z\",\n" +
                "      \"updated_at\": \"2013-01-11T18:51:00Z\"\n" +
                "    },\n" +
                "    \"created_at\": \"2013-09-06T21:07:22Z\"\n" +
                "  }\n" +
                "]";
        enqueueResponse(commentsJSON);
    }
}