package com.sweetzpot.stravazpot.upload.request;

import com.sweetzpot.stravazpot.upload.api.UploadAPI;
import com.sweetzpot.stravazpot.upload.model.DataType;
import com.sweetzpot.stravazpot.upload.model.UploadActivityType;
import com.sweetzpot.stravazpot.upload.model.UploadStatus;
import com.sweetzpot.stravazpot.upload.rest.UploadRest;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

public class UploadFileRequest {

    private final File file;
    private final UploadRest restService;
    private final UploadAPI uploadAPI;
    private UploadActivityType activityType;
    private String name;
    private String description;
    private boolean isPrivate;
    private boolean hasTrainer;
    private boolean isCommute;
    private DataType dataType;
    private String externalID;

    public UploadFileRequest(File file, UploadRest restService, UploadAPI uploadAPI) {
        this.file = file;
        this.restService = restService;
        this.uploadAPI = uploadAPI;
    }

    public UploadFileRequest withDataType(DataType dataType) {
        this.dataType = dataType;
        return this;
    }

    public UploadFileRequest withActivityType(UploadActivityType activityType) {
        this.activityType = activityType;
        return this;
    }

    public UploadFileRequest withName(String name) {
        this.name = name;
        return this;
    }

    public UploadFileRequest withDescription(String description) {
        this.description = description;
        return this;
    }

    public UploadFileRequest isPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
        return this;
    }

    public UploadFileRequest hasTrainer(boolean hasTrainer) {
        this.hasTrainer = hasTrainer;
        return this;
    }

    public UploadFileRequest isCommute(boolean isCommute) {
        this.isCommute = isCommute;
        return this;
    }

    public UploadFileRequest withExternalID(String externalID) {
        this.externalID = externalID;
        return this;
    }

    public UploadStatus execute() {
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        Call<UploadStatus> call = restService.upload(
                requestBodyFromString(activityType.toString()),
                requestBodyFromString(name),
                requestBodyFromString(description),
                booleanToInt(isPrivate),
                booleanToInt(hasTrainer),
                booleanToInt(isCommute),
                requestBodyFromString(dataType.toString()),
                requestBodyFromString(externalID),
                body);
        return uploadAPI.execute(call);
    }

    private RequestBody requestBodyFromString(String str) {
        return RequestBody.create(MultipartBody.FORM, str);
    }

    private Integer booleanToInt(boolean b) {
        return b ? 1 : 0;
    }
}
