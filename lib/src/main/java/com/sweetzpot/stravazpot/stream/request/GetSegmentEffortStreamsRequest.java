package com.sweetzpot.stravazpot.stream.request;

import com.sweetzpot.stravazpot.stream.api.StreamAPI;
import com.sweetzpot.stravazpot.stream.model.Resolution;
import com.sweetzpot.stravazpot.stream.model.SeriesType;
import com.sweetzpot.stravazpot.stream.model.Stream;
import com.sweetzpot.stravazpot.stream.model.StreamType;
import com.sweetzpot.stravazpot.stream.rest.StreamRest;

import java.util.List;

import retrofit2.Call;

public class GetSegmentEffortStreamsRequest {

    private final long segmentEffortStreams;
    private final StreamRest restService;
    private final StreamAPI api;
    private StreamType[] types;
    private Resolution resolution;
    private SeriesType seriesType;

    public GetSegmentEffortStreamsRequest(long segmentEffortStreams, StreamRest restService, StreamAPI api) {
        this.segmentEffortStreams = segmentEffortStreams;
        this.restService = restService;
        this.api = api;
    }

    public GetSegmentEffortStreamsRequest forTypes(StreamType... types) {
        this.types = types;
        return this;
    }

    public GetSegmentEffortStreamsRequest withResolution(Resolution resolution) {
        this.resolution = resolution;
        return this;
    }

    public GetSegmentEffortStreamsRequest withSeriesType(SeriesType seriesType) {
        this.seriesType = seriesType;
        return this;
    }

    public List<Stream> execute() {
        Call<List<Stream>> call = restService.getSegmentEffortStreams(segmentEffortStreams,
                StreamType.getQueryString(types), resolution, seriesType);
        return api.execute(call);
    }

}
