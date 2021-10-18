package com.stitbd.paddlecourierrider.Model.PaidAmount;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaidAmountContainers {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcels")
    @Expose
    private List<PaidAmountModel> parcels = null;

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

    public List<PaidAmountModel> getParcels() {
        return parcels;
    }

    public void setParcels(List<PaidAmountModel> parcels) {
        this.parcels = parcels;
    }
}
