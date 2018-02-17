package com.munchkin.dto;

import java.util.Map;

public class MuchfitResponse {

    private Map<String, Object> data;
    private MuchfitError error;

    public MuchfitResponse() {
    }

    public MuchfitResponse(Map<String, Object> data) {
        this.data = data;
    }

    public MuchfitResponse(MuchfitError error) {
        this.error = error;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public MuchfitError getError() {
        return error;
    }

    public void setError(MuchfitError error) {
        this.error = error;
    }
}
