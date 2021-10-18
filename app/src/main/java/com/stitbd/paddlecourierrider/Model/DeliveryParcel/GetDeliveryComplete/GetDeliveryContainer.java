package com.stitbd.paddlecourierrider.Model.DeliveryParcel.GetDeliveryComplete;

import com.stitbd.paddlecourierrider.Model.PickUpParcel.Parcel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDeliveryContainer {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcel")
    @Expose
    private Parcel parcel;

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

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }
}
