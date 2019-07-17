package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.CommentAPI;
import com.sweetzpot.stravazpot.activity.model.Comment;
import com.sweetzpot.stravazpot.activity.rest.CommentsRest;

import java.util.List;

import retrofit2.Call;

public class ListActivityCommentsRequest {

    private final long activityID;
    private final CommentsRest restService;
    private final CommentAPI api;
    private Integer page;
    private Integer perPage;

    public ListActivityCommentsRequest(long activityID, CommentsRest restService, CommentAPI api) {
        this.activityID = activityID;
        this.restService = restService;
        this.api = api;
    }

    public ListActivityCommentsRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public ListActivityCommentsRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<Comment> execute() {
        Call<List<Comment>> call = restService.getActivityComments(activityID, page, perPage);
        return api.execute(call);
    }
}
