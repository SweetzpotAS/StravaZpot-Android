package com.sweetzpot.stravazpot.club.api;

import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.club.model.Announcement;
import com.sweetzpot.stravazpot.club.model.Club;
import com.sweetzpot.stravazpot.club.model.ClubType;
import com.sweetzpot.stravazpot.club.model.Event;
import com.sweetzpot.stravazpot.club.model.JoinResult;
import com.sweetzpot.stravazpot.club.model.LeaveResult;
import com.sweetzpot.stravazpot.club.model.Membership;
import com.sweetzpot.stravazpot.club.model.SkillLevel;
import com.sweetzpot.stravazpot.club.model.SportType;
import com.sweetzpot.stravazpot.club.model.Terrain;
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

public class ClubAPITest extends StravaAPITest {

    @Test
    public void shouldRetrieveAClub() throws Exception {
        enqueueClub();
        ClubAPI clubAPI = givenAClubAPI();

        Club club = clubAPI.getClub(1L)
                        .execute();

        assertRequestPathContains("/clubs/1");
        assertClubParsedCorrectly(club);
    }

    @Test
    public void shouldListClubAnnouncements() throws Exception {
        enqueueAnnouncements();
        ClubAPI clubAPI = givenAClubAPI();

        List<Announcement> announcements = clubAPI.listClubAnnouncements(109984L)
                                                    .execute();

        assertRequestPathContains("/clubs/109984/announcements");
        assertAnnouncementsParsedCorrectly(announcements);
    }

    @Test
    public void shouldListClubGroupEvents() throws Exception {
        enqueueGroupEvents();
        ClubAPI clubAPI = givenAClubAPI();

        List<Event> events = clubAPI.listClubGroupEvents(1L)
                                    .execute();

        assertRequestPathContains("/clubs/1/group_events");
        assertEventsParsedCorrectly(events);
    }

    @Test
    public void shoudlListUsersClubs() throws Exception {
        enqueueResponse("[]");
        ClubAPI clubAPI = givenAClubAPI();

        List<Club> clubs = clubAPI.listMyClubs()
                                    .execute();

        assertRequestPathContains("/athlete/clubs");
    }

    @Test
    public void shouldListClubMembers() throws Exception {
        enqueueResponse("[]");
        ClubAPI clubAPI = givenAClubAPI();

        List<Athlete> athletes = clubAPI.listClubMembers(123456L)
                                        .inPage(2)
                                        .perPage(10)
                                        .execute();

        assertRequestPathContains(
                "/clubs/123456/members",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldListClubAdmins() throws Exception {
        enqueueResponse("[]");
        ClubAPI clubAPI = givenAClubAPI();

        List<Athlete> athletes = clubAPI.listClubAdmins(123456L)
                .inPage(2)
                .perPage(10)
                .execute();

        assertRequestPathContains(
                "/clubs/123456/admins",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldListClubActivities() throws Exception {
        enqueueResponse("[]");
        ClubAPI clubAPI = givenAClubAPI();

        List<Activity> activities = clubAPI.listClubActivities(123456L)
                                            .before(12598723)
                                            .inPage(2)
                                            .perPage(10)
                                            .execute();

        assertRequestPathContains(
                "/clubs/123456/activities",
                "before=12598723",
                "page=2",
                "per_page=10"
        );
    }

    @Test
    public void shouldJoinAClub() throws Exception {
        enqueueJoinResult();
        ClubAPI clubAPI = givenAClubAPI();

        JoinResult joinResult = clubAPI.joinClub(123456L)
                                        .execute();

        assertRequestPathContains("/clubs/123456/join");
        assertJoinResultParsedCorrectly(joinResult);
    }

    @Test
    public void shouldLeaveAClub() throws Exception {
        enqueueLeaveResult();
        ClubAPI clubAPI = givenAClubAPI();

        LeaveResult leaveResult = clubAPI.leaveClub(123456L)
                                            .execute();

        assertRequestPathContains("/clubs/123456/leave");
        assertLeaveResultParsedCorrectly(leaveResult);
    }

    private ClubAPI givenAClubAPI() {
        return new ClubAPI(givenAValidConfig());
    }

    private void assertClubParsedCorrectly(Club club) {
        assertThat(club.getID(), is(1L));
        assertThat(club.getResourceState(), is(ResourceState.DETAILED));
        assertThat(club.getName(), is("Team Strava Cycling"));
        assertThat(club.getProfileMedium(), is("http://pics.com/clubs/1/medium.jpg"));
        assertThat(club.getProfile(), is("http://pics.com/clubs/1/large.jpg"));
        assertThat(club.getCoverPhoto(), is("http://pics.com/clubs/1/cover/large.jpg"));
        assertThat(club.getCoverPhotoSmall(), is("http://pics.com/clubs/1/cover/small.jpg"));
        assertThat(club.getDescription(), is("From the people who brought you strava.com"));
        assertThat(club.getClubType(), is(ClubType.COMPANY));
        assertThat(club.getSportType(), is(SportType.CYCLING));
        assertThat(club.getCity(), is("San Francisco"));
        assertThat(club.getState(), is("California"));
        assertThat(club.getCountry(), is("United States"));
        assertThat(club.isPrivate(), is(true));
        assertThat(club.getMemberCount(), is(71));
        assertThat(club.isFeatured(), is(false));
        assertThat(club.isVerified(), is(false));
        assertThat(club.getMembership(), is(Membership.MEMBER));
        assertThat(club.isAdmin(), is(true));
        assertThat(club.isOwner(), is(false));
        assertThat(club.getFollowingCount(), is(1));
        assertThat(club.getUrl(), is("strava-cycling"));
    }

    private void enqueueClub() {
        String clubJSON = "{\n" +
                "  \"id\": 1,\n" +
                "  \"resource_state\": 3,\n" +
                "  \"name\": \"Team Strava Cycling\",\n" +
                "  \"profile_medium\": \"http://pics.com/clubs/1/medium.jpg\",\n" +
                "  \"profile\": \"http://pics.com/clubs/1/large.jpg\",\n" +
                "  \"cover_photo\": \"http://pics.com/clubs/1/cover/large.jpg\",\n" +
                "  \"cover_photo_small\": \"http://pics.com/clubs/1/cover/small.jpg\",\n" +
                "  \"description\": \"From the people who brought you strava.com\",\n" +
                "  \"club_type\": \"company\",\n" +
                "  \"sport_type\": \"cycling\",\n" +
                "  \"city\": \"San Francisco\",\n" +
                "  \"state\": \"California\",\n" +
                "  \"country\": \"United States\",\n" +
                "  \"private\": true,\n" +
                "  \"member_count\": 71,\n" +
                "  \"featured\": false,\n" +
                "  \"verified\": false,\n" +
                "  \"membership\": \"member\",\n" +
                "  \"admin\": true,\n" +
                "  \"owner\": false,\n" +
                "  \"following_count\": 1,\n" +
                "  \"url\": \"strava-cycling\"\n" +
                "}";
        enqueueResponse(clubJSON);
    }

    private void assertAnnouncementsParsedCorrectly(List<Announcement> announcements) {
        assertThat(announcements.size(), is(1));
        Announcement announcement = announcements.get(0);
        assertThat(announcement.getID(), is(1219827L));
        assertThat(announcement.getResourceState(), is(ResourceState.SUMMARY));
        assertThat(announcement.getClubID(), is(109984L));
        assertThat(announcement.getAthlete(), is(notNullValue()));
        assertThat(announcement.getCreatedAt(), isSameDate(makeDate(1, Calendar.APRIL, 2015, 21, 14, 2)));
        assertThat(announcement.getMessage(), is("hello club"));
    }

    private void enqueueAnnouncements() {
        String announcementsJSON = "[\n" +
                "  {\n" +
                "    \"id\": 1219827,\n" +
                "    \"resource_state\": 2,\n" +
                "    \"club_id\": 109984,\n" +
                "    \"athlete\": {\n" +
                "      \"id\": 227615,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"firstname\": \"John\",\n" +
                "      \"lastname\": \"Applestrava\",\n" +
                "      \"profile_medium\": \"http://pics.com/227615/medium.jpg\",\n" +
                "      \"profile\": \"http://pics.com/227615/large.jpg\",\n" +
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
                "    \"created_at\": \"2015-04-01T21:14:02Z\",\n" +
                "    \"message\": \"hello club\"\n" +
                "  }\n" +
                "]";
        enqueueResponse(announcementsJSON);
    }

    private void assertEventsParsedCorrectly(List<Event> events) {
        assertThat(events.size(), is(1));
        Event event = events.get(0);
        assertThat(event.getID(), is(1234567L));
        assertThat(event.getResourceState(), is(ResourceState.SUMMARY));
        assertThat(event.getTitle(), is("Test Group Event"));
        assertThat(event.getDescription(), is("Very fun group ride"));
        assertThat(event.getClubID(), is(1L));
        assertThat(event.getOrganizingAthlete(), is(notNullValue()));
        assertThat(event.getActivityType(), is(ActivityType.RIDE));
        assertThat(event.getCreatedAt(), isSameDate(makeDate(26, Calendar.AUGUST, 2009, 13, 42, 5)));
        assertThat(event.getRouteID(), is(123456L));
        assertThat(event.isWomenOnly(), is(false));
        assertThat(event.isPrivate(), is(true));
        assertThat(event.getSkillLevel(), is(SkillLevel.CASUAL));
        assertThat(event.getTerrain(), is(Terrain.MOSTLY_FLAT));
        assertThat(event.getUpcomingOccurrences().size(), is(5));
        assertThat(event.getAddress(), is("1 Happening St. Reno, NV"));
    }

    private void enqueueGroupEvents() {
        String groupEventsJSON = "[\n" +
                "  {\n" +
                "    \"id\": 1234567,\n" +
                "    \"resource_state\": 2,\n" +
                "    \"title\": \"Test Group Event\",\n" +
                "    \"description\": \"Very fun group ride\",\n" +
                "    \"club_id\": 1,\n" +
                "    \"organizing_athlete\": {\n" +
                "      \"id\": 227615,\n" +
                "      \"resource_state\": 2,\n" +
                "      \"firstname\": \"John\",\n" +
                "      \"lastname\": \"Applestrava\",\n" +
                "      \"profile_medium\": \"http://pics.com/227615/medium.jpg\",\n" +
                "      \"profile\": \"http://pics.com/227615/large.jpg\",\n" +
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
                "    \"activity_type\": \"Ride\",\n" +
                "    \"created_at\": \"2009-08-26T13:42:05Z\",\n" +
                "    \"route_id\": 123456,\n" +
                "    \"women_only\": false,\n" +
                "    \"private\": true,\n" +
                "    \"skill_levels\": 1,\n" +
                "    \"terrain\": 0,\n" +
                "    \"upcoming_occurrences\": [\n" +
                "      \"2015-04-19T18:47:59Z\",\n" +
                "      \"2015-04-20T18:47:59Z\",\n" +
                "      \"2015-04-21T18:47:59Z\",\n" +
                "      \"2015-04-22T18:47:59Z\",\n" +
                "      \"2015-04-23T18:47:59Z\"\n" +
                "    ],\n" +
                "    \"address\": \"1 Happening St. Reno, NV\"\n" +
                "  }\n" +
                "]";
        enqueueResponse(groupEventsJSON);
    }

    private void assertJoinResultParsedCorrectly(JoinResult joinResult) {
        assertThat(joinResult.isSuccess(), is(true));
        assertThat(joinResult.isActive(), is(true));
        assertThat(joinResult.getMembership(), is(Membership.MEMBER));
    }

    private void enqueueJoinResult() {
        String joinJSON = "{\n" +
                "  \"success\": true,\n" +
                "  \"active\": true,\n" +
                "  \"membership\": \"member\"\n" +
                "}";
        enqueueResponse(joinJSON);
    }

    private void assertLeaveResultParsedCorrectly(LeaveResult leaveResult) {
        assertThat(leaveResult.isSuccess(), is(true));
        assertThat(leaveResult.isActive(), is(false));
    }

    private void enqueueLeaveResult() {
        String leaveJSON = "{\n" +
                "  \"success\": true,\n" +
                "  \"active\": false\n" +
                "}";
        enqueueResponse(leaveJSON);
    }
}