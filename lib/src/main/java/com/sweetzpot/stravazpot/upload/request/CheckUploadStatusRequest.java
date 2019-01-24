package com.sweetzpot.stravazpot.upload.request;

import com.sweetzpot.stravazpot.upload.api.UploadAPI;
import com.sweetzpot.stravazpot.upload.model.UploadStatus;
import com.sweetzpot.stravazpot.upload.rest.UploadRest;

import retrofit2.Call;

public class CheckUploadStatusRequest {

    private final long id;
    private final UploadRest uploadRest;
    private final UploadAPI uploadAPI;

    public CheckUploadStatusRequest(long id, UploadRest uploadRest, UploadAPI uploadAPI) {
        this.id = id;
        this.uploadRest = uploadRest;
        this.uploadAPI = uploadAPI;
    }

    public UploadStatus execute() {
        Call<UploadStatus> call = uploadRest.checkUploadStatus(id);
        return uploadAPI.execute(call);
    }
}
