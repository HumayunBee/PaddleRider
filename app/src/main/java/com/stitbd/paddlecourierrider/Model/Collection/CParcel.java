package com.stitbd.paddlecourierrider.Model.Collection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CParcel {
    @SerializedName("parcel_id")
    @Expose
    private Integer parcelId;
    @SerializedName("parcel_invoice")
    @Expose
    private String parcelInvoice;
    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("customer_address")
    @Expose
    private String customerAddress;
    @SerializedName("customer_contact_number")
    @Expose
    private String customerContactNumber;
    @SerializedName("collect_amount")
    @Expose
    private Integer collectAmount;
    @SerializedName("district_name")
    @Expose
    private String districtName;
    @SerializedName("upazila_name")
    @Expose
    private String upazilaName;
    @SerializedName("area_name")
    @Expose
    private String areaName;
    @SerializedName("weight_package_name")
    @Expose
    private String weightPackageName;
    @SerializedName("merchant_id")
    @Expose
    private Integer merchantId;
    @SerializedName("merchant_name")
    @Expose
    private String merchantName;
    @SerializedName("merchant_address")
    @Expose
    private String merchantAddress;
    @SerializedName("merchant_contact_number")
    @Expose
    private String merchantContactNumber;
    @SerializedName("parcel_status")
    @Expose
    private String parcelStatus;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Integer getParcelId() {
        return parcelId;
    }

    public void setParcelId(Integer parcelId) {
        this.parcelId = parcelId;
    }

    public String getParcelInvoice() {
        return parcelInvoice;
    }

    public void setParcelInvoice(String parcelInvoice) {
        this.parcelInvoice = parcelInvoice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public Integer getCollectAmount() {
        return collectAmount;
    }

    public void setCollectAmount(Integer collectAmount) {
        this.collectAmount = collectAmount;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getUpazilaName() {
        return upazilaName;
    }

    public void setUpazilaName(String upazilaName) {
        this.upazilaName = upazilaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getWeightPackageName() {
        return weightPackageName;
    }

    public void setWeightPackageName(String weightPackageName) {
        this.weightPackageName = weightPackageName;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantContactNumber() {
        return merchantContactNumber;
    }

    public void setMerchantContactNumber(String merchantContactNumber) {
        this.merchantContactNumber = merchantContactNumber;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
