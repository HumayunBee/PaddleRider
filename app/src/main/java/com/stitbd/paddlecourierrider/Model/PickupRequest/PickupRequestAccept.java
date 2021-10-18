
package com.stitbd.paddlecourierrider.Model.PickupRequest;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PickupRequestAccept{

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("error")
    @Expose
    private String error;

    @Expose
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
