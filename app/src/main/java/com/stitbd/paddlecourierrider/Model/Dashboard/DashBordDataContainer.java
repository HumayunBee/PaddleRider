package com.stitbd.paddlecourierrider.Model.Dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashBordDataContainer {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("dashboard_count")
    @Expose
    private DashBoardData dashBoardData;

    public DashBoardData getDashBoardData() {
        return dashBoardData;
    }

    public void setDashBoardData(DashBoardData dashBoardData) {
        this.dashBoardData = dashBoardData;
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
}
