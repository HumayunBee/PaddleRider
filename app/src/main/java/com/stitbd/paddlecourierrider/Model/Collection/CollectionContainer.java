
package com.stitbd.paddlecourierrider.Model.Collection;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CollectionContainer {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcels")
    @Expose
    private List<CParcel> parcels = null;

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

    public List<CParcel> getParcels() {
        return parcels;
    }

    public void setParcels(List<CParcel> parcels) {
        this.parcels = parcels;
    }
}
