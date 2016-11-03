package com.cisco.iot.service;

/**
 * Created by yu on 16/3/31.
 */
public class ReturnObject {

    private boolean error;

    private String errorMsg;

    private Object data;

    private String status;

    public ReturnObject(){
        this.error = false;
        this.status = "OKOKOK";
    }

    public ReturnObject(boolean error, String errorMsg, Object data, String status){
        this.error = error;
        this.errorMsg = errorMsg;
        this.data = data;
        this.status = status;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
