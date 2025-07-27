package com.dip.Spring_Student_CRUD_API.rest;

public class StudentErrorResponse {

    private int status;
    private  String mseesage;
    private long timestamp;

    public StudentErrorResponse() {

    }

    public StudentErrorResponse(int status, String mseesage, long timestamp) {
        this.status = status;
        this.mseesage = mseesage;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMseesage() {
        return mseesage;
    }

    public void setMseesage(String mseesage) {
        this.mseesage = mseesage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
