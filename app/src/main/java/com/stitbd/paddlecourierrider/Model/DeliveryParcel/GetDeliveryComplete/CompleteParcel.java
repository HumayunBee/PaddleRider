package com.stitbd.paddlecourierrider.Model.DeliveryParcel.GetDeliveryComplete;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompleteParcel {
    @SerializedName("parcel_id")
    @Expose
    private Integer parcelId;
    @SerializedName("parcel_status")
    @Expose
    private String parcelStatus;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("parcel_invoice")
    @Expose
    private String parcelInvoice;
    @SerializedName("merchant_order_id")
    @Expose
    private Object merchantOrderId;
    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("customer_address")
    @Expose
    private String customerAddress;
    @SerializedName("customer_contact_number")
    @Expose
    private String customerContactNumber;
    @SerializedName("total_collect_amount")
    @Expose
    private Integer totalCollectAmount;
    @SerializedName("product_details")
    @Expose
    private String productDetails;
    @SerializedName("area_name")
    @Expose
    private String areaName;
    @SerializedName("area_post_code")
    @Expose
    private String areaPostCode;
    @SerializedName("upazila_name")
    @Expose
    private String upazilaName;
    @SerializedName("district_name")
    @Expose
    private String districtName;
    @SerializedName("merchant_id")
    @Expose
    private Integer merchantId;
    @SerializedName("merchant_name")
    @Expose
    private String merchantName;
    @SerializedName("merchant_email")
    @Expose
    private String merchantEmail;
    @SerializedName("merchant_company_name")
    @Expose
    private String merchantCompanyName;
    @SerializedName("merchant_address")
    @Expose
    private String merchantAddress;
    @SerializedName("merchant_contact_number")
    @Expose
    private String merchantContactNumber;
    @SerializedName("weight_package_name")
    @Expose
    private String weightPackageName;
    @SerializedName("delivery_branch_name")
    @Expose
    private String deliveryBranchName;
    @SerializedName("delivery_branch_address")
    @Expose
    private String deliveryBranchAddress;

    public Integer getParcelId() {
        return parcelId;
    }

    public void setParcelId(Integer parcelId) {
        this.parcelId = parcelId;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParcelInvoice() {
        return parcelInvoice;
    }

    public void setParcelInvoice(String parcelInvoice) {
        this.parcelInvoice = parcelInvoice;
    }

    public Object getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(Object merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
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

    public Integer getTotalCollectAmount() {
        return totalCollectAmount;
    }

    public void setTotalCollectAmount(Integer totalCollectAmount) {
        this.totalCollectAmount = totalCollectAmount;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaPostCode() {
        return areaPostCode;
    }

    public void setAreaPostCode(String areaPostCode) {
        this.areaPostCode = areaPostCode;
    }

    public String getUpazilaName() {
        return upazilaName;
    }

    public void setUpazilaName(String upazilaName) {
        this.upazilaName = upazilaName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
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

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public String getMerchantCompanyName() {
        return merchantCompanyName;
    }

    public void setMerchantCompanyName(String merchantCompanyName) {
        this.merchantCompanyName = merchantCompanyName;
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

    public String getWeightPackageName() {
        return weightPackageName;
    }

    public void setWeightPackageName(String weightPackageName) {
        this.weightPackageName = weightPackageName;
    }

    public String getDeliveryBranchName() {
        return deliveryBranchName;
    }

    public void setDeliveryBranchName(String deliveryBranchName) {
        this.deliveryBranchName = deliveryBranchName;
    }

    public String getDeliveryBranchAddress() {
        return deliveryBranchAddress;
    }

    public void setDeliveryBranchAddress(String deliveryBranchAddress) {
        this.deliveryBranchAddress = deliveryBranchAddress;
    }

}
