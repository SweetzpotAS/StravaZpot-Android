package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.KudosAPI;
import com.sweetzpot.stravazpot.activity.rest.KudosRest;
import com.sweetzpot.stravazpot.athlete.model.Athlete;

import java.util.List;

import retrofit2.Call;

public class ListActivityKudoersRequest {

    private final long activityID;
    private final KudosRest restService;
    private final KudosAPI api;
    private Integer page;
    private Integer perPage;

    public ListActivityKudoersRequest(long activityID, KudosRest restService, KudosAPI api) {
        this.activityID = activityID;
        this.restService = restService;
        this.api = api;
    }

    public ListActivityKudoersRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public ListActivityKudoersRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<Athlete> execute() {
        Call<List<Athlete>> call = restService.getActivityKudos(activityID, page, perPage);
        return api.execute(call);
    }

}
