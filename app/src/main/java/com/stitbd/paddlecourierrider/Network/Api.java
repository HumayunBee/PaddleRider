package com.stitbd.paddlecourierrider.Network;

import com.stitbd.paddlecourierrider.Model.Collection.CollectionContainer;
import com.stitbd.paddlecourierrider.Model.Dashboard.DashBordDataContainer;
import com.stitbd.paddlecourierrider.Model.DeliveryParcel.DeliveryContainer;
import com.stitbd.paddlecourierrider.Model.PaidAmount.PaidAmountContainers;
import com.stitbd.paddlecourierrider.Model.PickUpParcel.PickupParcel;
import com.stitbd.paddlecourierrider.Model.PickupRequest.PickupRequestAccept;
import com.stitbd.paddlecourierrider.Model.Return.ReturnListContainer;
import com.stitbd.paddlecourierrider.Model.RiderProfile.RiderContainer;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("api/rider/login")
    Call<JsonObject> login(@Field("email") String email, @Field("password") String password);

    @POST("api/rider/getPickupParcelList")
    Call<PickupParcel> getparcel();

    @POST("api/rider/getDeliveryParcelList")
    Call<DeliveryContainer> getDeliveryparcel();

    @POST("api/rider/getReturnParcelList")
    Call<ReturnListContainer> getReturnparcellist();

    @POST("api/rider/collectionParcelList")
    Call<CollectionContainer> getCollectionparcel();

    @POST("api/rider/paidAmountParcelList")
    Call<PaidAmountContainers> getPaidparcel();



    @FormUrlEncoded
    @POST("api/rider/parcelPickupRequestAccept")
    Call<PickupRequestAccept> getrequestacc(@Field("parcel_id") String parcel_id);

    @FormUrlEncoded
    @POST("api/rider/parcelPickupRequestReject")
    Call<PickupRequestAccept> getrequestreject(@Field("parcel_id") String parcel_id);

    @FormUrlEncoded
    @POST("api/rider/parcelPickupComplete")
    Call<PickupRequestAccept> getpickcomplete(@Field("parcel_id") String parcel_id);

    @FormUrlEncoded
    @POST("api/rider/parcelPickupReschedule")
    Call<PickupRequestAccept> getreschedule(@Field("parcel_id") String parcel_id);



    @FormUrlEncoded
    @POST("api/rider/parcelDeliveryRequestAccept")
    Call<PickupRequestAccept> getdeliveryaccept(@Field("parcel_id") String parcel_id);

    @FormUrlEncoded
    @POST("api/rider/parcelDeliveryRequestReject")
    Call<PickupRequestAccept> getdeliveryreject(@Field("parcel_id") String parcel_id);

    @FormUrlEncoded
    @POST("api/rider/parcelReturnRequestAccept")
    Call<PickupRequestAccept> getreturnaccept(@Field("parcel_id") String parcel_id);

    @FormUrlEncoded
    @POST("api/rider/parcelReturnRequestReject")
    Call<PickupRequestAccept> getreturnreject(@Field("parcel_id") String parcel_id);


    @FormUrlEncoded
    @POST("api/rider/parcelDeliveryOtpSendCustomer")
    Call<JsonObject> getDeliveryOTP(@Field("parcel_id") String parcel_id);

    @FormUrlEncoded
    @POST("api/rider/parcelDeliveryComplete")
    Call<JsonObject> confirmDelivery(
            @Field("parcel_id") String parcel_id,
            @Field("delivery_type") String delivery_type,
            @Field("customer_collect_amount") String customer_collect_amount,
            @Field("parcel_code") String parcel_code,
            @Field("reschedule_date") String reschedule_date,
            @Field("parcel_note") String parcel_note


    );


    @POST("api/rider")
    Call<RiderContainer> getprofile();



    @POST("api/rider/dashboard")
    Call<DashBordDataContainer> getDashboarddata();







}
