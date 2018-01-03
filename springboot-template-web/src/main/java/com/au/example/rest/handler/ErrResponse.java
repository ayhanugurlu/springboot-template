package com.au.example.rest.handler;


public class ErrResponse {

    private long traceID;

    private String message;


    public ErrResponse(long traceID,String message) {
        this.traceID = traceID;
        this.message = message;
    }

    public long getTraceID() {
        return traceID;
    }

    public void setTraceID(long traceID) {
        this.traceID = traceID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}