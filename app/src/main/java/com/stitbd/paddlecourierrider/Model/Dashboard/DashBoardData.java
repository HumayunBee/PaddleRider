package com.stitbd.paddlecourierrider.Model.Dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DashBoardData {
    @SerializedName("todayPickupParcel")
    @Expose
    private Integer todayPickupParcel;
    @SerializedName("todayPickupComplete")
    @Expose
    private Integer todayPickupComplete;

    @SerializedName("todayPickupPending")
    @Expose
    private Integer todayPickupPending;

    @SerializedName("todayPickupCancel")
    @Expose
    private Integer todayPickupCancel;

    @SerializedName("todayDeliveryParcels")
    @Expose
    private Integer todayDeliveryParcels;

    @SerializedName("todayDeliveryComplete")
    @Expose
    private Integer todayDeliveryComplete;

    @SerializedName("todayDeliveryPending")
    @Expose
    private Integer todayDeliveryPending;

    @SerializedName("todayDeliveryCancel")
    @Expose
    private Integer todayDeliveryCancel;

    @SerializedName("totalPickupParcel")
    @Expose
    private Integer totalPickupParcel;

    @SerializedName("totalPickupComplete")
    @Expose
    private Double totalPickupComplete;

    @SerializedName("totalPickupPending")
    @Expose
    private Double totalPickupPending;

    @SerializedName("totalPickupCancel")
    @Expose
    private Double totalPickupCancel;

    @SerializedName("totalDeliveryParcels")
    @Expose
    private Double totalDeliveryParcels;

    @SerializedName("totalDeliveryComplete")
    @Expose
    private Double totalDeliveryComplete;

    @SerializedName("totalDeliveryPending")
    @Expose
    private Double totalDeliveryPending;

    @SerializedName("totalDeliveryCancel")
    @Expose
    private Double totalDeliveryCancel;

    @SerializedName("ecourierTotalCollectAmount")
    @Expose
    private Double ecourierTotalCollectAmount;

    @SerializedName("ecourierPaidToBranch")
    @Expose
    private Double ecourierPaidToBranch;

    @SerializedName("ecourierBalanceCollectAmount")
    @Expose
    private Double ecourierBalanceCollectAmount;

    public Integer getTodayPickupParcel() {
        return todayPickupParcel;
    }

    public void setTodayPickupParcel(Integer todayPickupParcel) {
        this.todayPickupParcel = todayPickupParcel;
    }

    public Integer getTodayPickupComplete() {
        return todayPickupComplete;
    }

    public void setTodayPickupComplete(Integer todayPickupComplete) {
        this.todayPickupComplete = todayPickupComplete;
    }

    public Integer getTodayPickupPending() {
        return todayPickupPending;
    }

    public void setTodayPickupPending(Integer todayPickupPending) {
        this.todayPickupPending = todayPickupPending;
    }

    public Integer getTodayPickupCancel() {
        return todayPickupCancel;
    }

    public void setTodayPickupCancel(Integer todayPickupCancel) {
        this.todayPickupCancel = todayPickupCancel;
    }

    public Integer getTodayDeliveryParcels() {
        return todayDeliveryParcels;
    }

    public void setTodayDeliveryParcels(Integer todayDeliveryParcels) {
        this.todayDeliveryParcels = todayDeliveryParcels;
    }

    public Integer getTodayDeliveryComplete() {
        return todayDeliveryComplete;
    }

    public void setTodayDeliveryComplete(Integer todayDeliveryComplete) {
        this.todayDeliveryComplete = todayDeliveryComplete;
    }

    public Integer getTodayDeliveryPending() {
        return todayDeliveryPending;
    }

    public void setTodayDeliveryPending(Integer todayDeliveryPending) {
        this.todayDeliveryPending = todayDeliveryPending;
    }

    public Integer getTodayDeliveryCancel() {
        return todayDeliveryCancel;
    }

    public void setTodayDeliveryCancel(Integer todayDeliveryCancel) {
        this.todayDeliveryCancel = todayDeliveryCancel;
    }

    public Integer getTotalPickupParcel() {
        return totalPickupParcel;
    }

    public void setTotalPickupParcel(Integer totalPickupParcel) {
        this.totalPickupParcel = totalPickupParcel;
    }

    public Double getTotalPickupComplete() {
        return totalPickupComplete;
    }

    public void setTotalPickupComplete(Double totalPickupComplete) {
        this.totalPickupComplete = totalPickupComplete;
    }

    public Double getTotalPickupPending() {
        return totalPickupPending;
    }

    public void setTotalPickupPending(Double totalPickupPending) {
        this.totalPickupPending = totalPickupPending;
    }

    public Double getTotalPickupCancel() {
        return totalPickupCancel;
    }

    public void setTotalPickupCancel(Double totalPickupCancel) {
        this.totalPickupCancel = totalPickupCancel;
    }

    public Double getTotalDeliveryParcels() {
        return totalDeliveryParcels;
    }

    public void setTotalDeliveryParcels(Double totalDeliveryParcels) {
        this.totalDeliveryParcels = totalDeliveryParcels;
    }

    public Double getTotalDeliveryComplete() {
        return totalDeliveryComplete;
    }

    public void setTotalDeliveryComplete(Double totalDeliveryComplete) {
        this.totalDeliveryComplete = totalDeliveryComplete;
    }

    public Double getTotalDeliveryPending() {
        return totalDeliveryPending;
    }

    public void setTotalDeliveryPending(Double totalDeliveryPending) {
        this.totalDeliveryPending = totalDeliveryPending;
    }

    public Double getTotalDeliveryCancel() {
        return totalDeliveryCancel;
    }

    public void setTotalDeliveryCancel(Double totalDeliveryCancel) {
        this.totalDeliveryCancel = totalDeliveryCancel;
    }

    public Double getEcourierTotalCollectAmount() {
        return ecourierTotalCollectAmount;
    }

    public void setEcourierTotalCollectAmount(Double ecourierTotalCollectAmount) {
        this.ecourierTotalCollectAmount = ecourierTotalCollectAmount;
    }

    public Double getEcourierPaidToBranch() {
        return ecourierPaidToBranch;
    }

    public void setEcourierPaidToBranch(Double ecourierPaidToBranch) {
        this.ecourierPaidToBranch = ecourierPaidToBranch;
    }

    public Double getEcourierBalanceCollectAmount() {
        return ecourierBalanceCollectAmount;
    }

    public void setEcourierBalanceCollectAmount(Double ecourierBalanceCollectAmount) {
        this.ecourierBalanceCollectAmount = ecourierBalanceCollectAmount;
    }

    public List<DashBoardHelperModel> getlist() {
        List<DashBoardHelperModel> helper = new ArrayList<>();
        helper.add(new DashBoardHelperModel("Today Pickup Parcel", Double.valueOf(todayPickupParcel)));
        helper.add(new DashBoardHelperModel("Today Pickup Done", Double.valueOf(todayPickupComplete)));
        helper.add(new DashBoardHelperModel("Today Pickup Pending", Double.valueOf(todayPickupPending)));
        helper.add(new DashBoardHelperModel("Today Pickup Cancle", Double.valueOf(todayPickupCancel)));
        helper.add(new DashBoardHelperModel("Today Delivery Parcel", Double.valueOf(todayDeliveryParcels)));
        helper.add(new DashBoardHelperModel("Today Delivery Done", Double.valueOf(todayDeliveryComplete)));
        helper.add(new DashBoardHelperModel("Today Delivery Pending", Double.valueOf(todayDeliveryPending)));
        helper.add(new DashBoardHelperModel("Today Delivery Cancle", Double.valueOf(todayDeliveryCancel)));
        helper.add(new DashBoardHelperModel("Total Pickup Parcel", Double.valueOf(totalPickupParcel)));
        helper.add(new DashBoardHelperModel("Total Pickup Done", totalPickupComplete));
        helper.add(new DashBoardHelperModel("Total Pickup Pending", totalPickupPending));
        helper.add(new DashBoardHelperModel("Total Pickup Cancel", totalPickupCancel));
        helper.add(new DashBoardHelperModel("Total Delivery Parcel", totalDeliveryParcels));
        helper.add(new DashBoardHelperModel("Total Delivery Done", totalDeliveryComplete));
        helper.add(new DashBoardHelperModel("Total Delivery Pending", totalDeliveryPending));
        helper.add(new DashBoardHelperModel("Total Delivery Cancel", totalDeliveryCancel));
        helper.add(new DashBoardHelperModel("Collection Amount", ecourierTotalCollectAmount));
        helper.add(new DashBoardHelperModel("Collection Paid To Branch", ecourierPaidToBranch));
        helper.add(new DashBoardHelperModel("Balance Amount", ecourierBalanceCollectAmount));

        return helper;
    }
}
