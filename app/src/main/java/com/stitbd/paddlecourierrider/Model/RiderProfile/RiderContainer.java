
package com.stitbd.paddlecourierrider.Model.RiderProfile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RiderContainer{

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("rider")
    @Expose
    private Rider rider;
    @SerializedName("token")
    @Expose
    private String token;

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

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
