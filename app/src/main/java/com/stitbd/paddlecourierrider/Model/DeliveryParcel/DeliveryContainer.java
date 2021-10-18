package com.stitbd.paddlecourierrider.Model.DeliveryParcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeliveryContainer {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcels")
    @Expose
    private List<DeliveryParcel> parcels = null;

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

    public List<DeliveryParcel> getParcels() {
        return parcels;
    }

    public void setParcels(List<DeliveryParcel> parcels) {
        this.parcels = parcels;
    }
}
