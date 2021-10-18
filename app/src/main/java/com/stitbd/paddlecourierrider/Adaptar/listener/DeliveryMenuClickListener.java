package com.stitbd.paddlecourierrider.Adaptar.listener;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;

import com.stitbd.paddlecourierrider.Adaptar.DeliveryParcelListAdaptar.DeliveryAdaptar;
import com.stitbd.paddlecourierrider.Adaptar.DeliveryParcelListAdaptar.RequestDeliveryAdaptar;
import com.stitbd.paddlecourierrider.Model.DeliveryParcel.DeliveryParcel;
import com.stitbd.paddlecourierrider.Model.PickupRequest.PickupRequestAccept;
import com.stitbd.paddlecourierrider.Network.Api;
import com.stitbd.paddlecourierrider.Network.RetrofitClient;
import com.stitbd.paddlecourierrider.R;
import com.stitbd.paddlecourierrider.Util.DeliveryAlertDialog;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeliveryMenuClickListener implements View.OnClickListener {
    int spinnerPosition = 0;
    DeliveryAdaptar percelListAdapter;
    DeliveryAlertDialog myAlertDialog;
    DeliveryAdaptar.OnItemClickListener listenerd;
    DeliveryAdaptar.Viewholders viewHolders;
    DeliveryParcel percel;
    ProgressDialog progressDialog;
    Api api;


    Context context;

    public DeliveryMenuClickListener(DeliveryAdaptar percelListAdapter, DeliveryAdaptar.OnItemClickListener listenerd,
                                     DeliveryAdaptar.Viewholders viewHolders, DeliveryParcel percel) {
        this.percelListAdapter = percelListAdapter;
        this.listenerd = listenerd;
        this.viewHolders = viewHolders;
        this.percel = percel;
        this.context = viewHolders.itemView.getContext();


        api = RetrofitClient.get(viewHolders.itemView.getContext()).create(Api.class);
        progressDialog = new ProgressDialog(viewHolders.itemView.getContext());
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);
        myAlertDialog = new DeliveryAlertDialog(viewHolders.itemView.getContext());
    }


    @Override
    public void onClick(View v) {

        Log.e("delivery", percel.getParcelStatus());

        PopupMenu popupMenu = new PopupMenu(viewHolders.itemView.getContext(), viewHolders.getoption());
        popupMenu.getMenuInflater().inflate(R.menu.parcel_pickup_menu, popupMenu.getMenu());


        if (percel.getParcelStatus().equals("Delivery Run Start")) {
            popupMenu.getMenu().findItem(R.id.m_request_complete).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_accept).setVisible(true);
            popupMenu.getMenu().findItem(R.id.m_request_reject).setVisible(true);
            popupMenu.getMenu().findItem(R.id.m_request_reschedule).setVisible(false);

        } else if (percel.getParcelStatus().equals("Delivery Run Rider Accept")) {
            popupMenu.getMenu().findItem(R.id.m_request_accept).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_reject).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_reschedule).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_complete).setVisible(true);
            // Log.e("request", "hghhhg");
        }


        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.m_request_accept:
                        progressDialog.show();
                        api.getdeliveryaccept(String.valueOf(percel.getParcelId())).enqueue(new Callback<PickupRequestAccept>() {
                            @Override
                            public void onResponse(Call<PickupRequestAccept> call, Response<PickupRequestAccept> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    progressDialog.dismiss();
                                    Toast.makeText(viewHolders.itemView.getContext(), "Request Accept", Toast.LENGTH_SHORT).show();
                                    listenerd.onItemClick(5);
                                } else {
                                    progressDialog.dismiss();
//                                    try {
//                                        Log.e("deli", String.valueOf(response.errorBody().string()));
//                                    } catch (IOException e) {
//                                        e.printStackTrace();
//                                    }
                                }

                            }

                            @Override
                            public void onFailure(Call<PickupRequestAccept> call, Throwable t) {

                            }
                        });
                    case R.id.m_request_reject:
                        progressDialog.show();
                        api.getdeliveryreject(String.valueOf(percel.getParcelId())).enqueue(new Callback<PickupRequestAccept>() {
                            @Override
                            public void onResponse(Call<PickupRequestAccept> call, Response<PickupRequestAccept> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    progressDialog.dismiss();
                                    Toast.makeText(viewHolders.itemView.getContext(), "Request Reject", Toast.LENGTH_SHORT).show();
                                    listenerd.onItemClick(5);
                                } else {
                                    progressDialog.dismiss();
                                }
                            }

                            @Override
                            public void onFailure(Call<PickupRequestAccept> call, Throwable t) {

                            }
                        });
                        //  Toast.makeText(viewHolders.itemView.getContext(), "accept", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.m_request_complete:
                        myAlertDialog.showConfirmDialog("Complete Request", "Confirm", "");
                        myAlertDialog.button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                sendDatatoServerBYConfirm(percel, spinnerPosition);


                            }
                        });


                        myAlertDialog.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (i == 1) {
                                    myAlertDialog.LnConfirmAmount.setVisibility(View.VISIBLE);
                                    myAlertDialog.LnCode.setVisibility(View.VISIBLE);
                                    myAlertDialog.LnDate.setVisibility(View.GONE);
                                    myAlertDialog.LnNote.setVisibility(View.GONE);
                                    myAlertDialog.ConfirmAmount.setText(String.valueOf(percel.getCollectAmount()));
                                    myAlertDialog.ConfirmAmount.setEnabled(false);

                                    myAlertDialog.SendOtp.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            myAlertDialog.sendOtp(String.valueOf(percel.getParcelId().toString()));
                                        }
                                    });
                                    spinnerPosition = 1;
                                    //Toast.makeText(viewHolders.itemView.getContext(), "okkkkkkkkk", Toast.LENGTH_SHORT).show();
                                } else if (i == 2) {
                                    myAlertDialog.LnConfirmAmount.setVisibility(View.VISIBLE);
                                    myAlertDialog.LnCode.setVisibility(View.VISIBLE);
                                    myAlertDialog.LnNote.setVisibility(View.VISIBLE);
                                    myAlertDialog.LnDate.setVisibility(View.GONE);
                                    myAlertDialog.ConfirmAmount.setText("");
                                    myAlertDialog.ConfirmAmount.setEnabled(true);
                                } else if (i == 3) {
                                    myAlertDialog.LnDate.setVisibility(View.VISIBLE);
                                    myAlertDialog.LnNote.setVisibility(View.VISIBLE);
                                    myAlertDialog.LnConfirmAmount.setVisibility(View.GONE);
                                    myAlertDialog.LnCode.setVisibility(View.GONE);


                                } else if (i == 4) {
                                    myAlertDialog.LnNote.setVisibility(View.VISIBLE);
                                    myAlertDialog.LnConfirmAmount.setVisibility(View.GONE);
                                    myAlertDialog.LnCode.setVisibility(View.GONE);
                                    myAlertDialog.LnDate.setVisibility(View.GONE);
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                        myAlertDialog.show();
                       // Toast.makeText(viewHolders.itemView.getContext(), "reject", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }

            }
        });
        popupMenu.show();
    }

    public void sendDatatoServerBYConfirm(DeliveryParcel parcel, int position) {
        Log.e("tesst", "inner senddataServer");
        int ppsitions = myAlertDialog.spinner.getSelectedItemPosition();
        if (ppsitions == 0) {
            Toast.makeText(context, "Please Select Delivery Type", Toast.LENGTH_SHORT).show();
        } else if (ppsitions == 1) {

            if (!TextUtils.isEmpty(myAlertDialog.EnterCode.getText().toString())) {
                myAlertDialog.cancel();
                progressDialog.show();
                api.confirmDelivery(
                        String.valueOf(parcel.getParcelId()),
                        "21",
                        String.valueOf(parcel.getCollectAmount()),
                        myAlertDialog.EnterCode.getText().toString(),
                        "",
                        ""

                ).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        progressDialog.dismiss();
                        if (response.isSuccessful() && response.body() != null) {
                            Toast.makeText(context, "Successfully submitted", Toast.LENGTH_SHORT).show();
                            listenerd.onItemClick(5);
                            Log.e("tesst", response.body().getAsString().toString());
                            myAlertDialog.cancel();
                        } else {

                            try {
                                Log.e("tesst", response.errorBody().string());
                                Toast.makeText(context,"Code or Collection Amount doesn't Match", Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                myAlertDialog.EnterCode.setError("Enter your OTP Code");
                myAlertDialog.EnterCode.requestFocus();
            }

        } else if (ppsitions == 2) {
            if (!TextUtils.isEmpty(myAlertDialog.EnterCode.getText().toString())) {
                if (!TextUtils.isEmpty(myAlertDialog.ConfirmAmount.getText().toString())) {
                    myAlertDialog.cancel();
                    progressDialog.show();
                    api.confirmDelivery(
                            String.valueOf(parcel.getParcelId()),
                            "22",
                            String.valueOf(parcel.getCollectAmount()),
                            myAlertDialog.EnterCode.getText().toString(),
                            "",
                            myAlertDialog.ENote.getText().toString()

                    ).enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            progressDialog.dismiss();
                            if (response.isSuccessful() && response.body() != null) {
                                Toast.makeText(context, "Successfully submitted", Toast.LENGTH_SHORT).show();
                                Log.e("tesst", response.body().getAsString().toString());
                                myAlertDialog.cancel();
                                listenerd.onItemClick(5);
                            } else {
                                try {
                                    Toast.makeText(context, "Parcel Code not Matching", Toast.LENGTH_SHORT).show();
                                    Log.e("tesst", response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    myAlertDialog.ConfirmAmount.setError("Enter Amount");
                    myAlertDialog.ConfirmAmount.requestFocus();
                }
            } else {
                myAlertDialog.EnterCode.setError("Enter your OTP Code");
                myAlertDialog.EnterCode.requestFocus();
            }

        } else if (ppsitions == 3) {
            if (!TextUtils.isEmpty(myAlertDialog.Edate.getText().toString())) {
                myAlertDialog.cancel();
                progressDialog.show();

                api.confirmDelivery(
                        String.valueOf(parcel.getParcelId()),
                        "23",
                        myAlertDialog.ConfirmAmount.getText().toString(),
                        " ",
                        myAlertDialog.Edate.getText().toString(),
                        myAlertDialog.ENote.getText().toString()

                ).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        progressDialog.dismiss();
                        if (response.isSuccessful() && response.body() != null) {
                            Toast.makeText(context, "Successfully submitted", Toast.LENGTH_SHORT).show();
                            // Log.e("tesst", response.body().getAsString().toString());
                            myAlertDialog.cancel();
                            listenerd.onItemClick(5);
                        } else {
                            try {
                                Log.e("tesst", response.errorBody().string());
                                Toast.makeText(context, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                myAlertDialog.Edate.setError("Select Date!");
                myAlertDialog.Edate.requestFocus();
            }


        } else if (ppsitions == 4) {
            if (!TextUtils.isEmpty(myAlertDialog.ENote.getText().toString())) {

                myAlertDialog.cancel();
                progressDialog.show();
                api.confirmDelivery(
                        String.valueOf(parcel.getParcelId()),
                        "24",
                        "",
                        " ",
                        " ",
                        myAlertDialog.ENote.getText().toString()

                ).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        progressDialog.dismiss();
                        if (response.isSuccessful() && response.body() != null) {
                            Toast.makeText(context, "Successfully submitted", Toast.LENGTH_SHORT).show();
                            //Log.e("tesst",response.body().getAsString().toString());
                            myAlertDialog.cancel();
                            listenerd.onItemClick(5);
                        } else {
                            try {
                                Log.e("tesst", response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                myAlertDialog.ENote.setError("Enter Note Please");
                myAlertDialog.ENote.requestFocus();
            }

        }


    }
}
