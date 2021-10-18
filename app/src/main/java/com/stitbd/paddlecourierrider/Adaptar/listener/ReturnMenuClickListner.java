package com.stitbd.paddlecourierrider.Adaptar.listener;

import android.app.ProgressDialog;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.PopupMenu;

import com.stitbd.paddlecourierrider.Adaptar.ReturnParcelAdaptar.ReturnParcels;
import com.stitbd.paddlecourierrider.Model.PickupRequest.PickupRequestAccept;
import com.stitbd.paddlecourierrider.Model.Return.ReturnParcel;
import com.stitbd.paddlecourierrider.Network.Api;
import com.stitbd.paddlecourierrider.Network.RetrofitClient;
import com.stitbd.paddlecourierrider.R;
import com.stitbd.paddlecourierrider.Util.MyAlertDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReturnMenuClickListner implements View.OnClickListener {

    ReturnParcels percelListAdapter;
    ReturnParcels.OnItemClickListener listener;
    ReturnParcels.Viewholders viewHolders;
    ReturnParcel percel;
    ProgressDialog progressDialog;
    Api api;

    public ReturnMenuClickListner(ReturnParcels percelListAdapter, ReturnParcels.OnItemClickListener listener, ReturnParcels.Viewholders viewHolders, ReturnParcel percel) {
        this.percelListAdapter = percelListAdapter;
        this.listener = listener;
        this.viewHolders = viewHolders;
        this.percel = percel;

        api = RetrofitClient.get(viewHolders.itemView.getContext()).create(Api.class);
        progressDialog = new ProgressDialog(viewHolders.itemView.getContext());
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);
    }


    @Override
    public void onClick(View v) {


        PopupMenu popupMenu = new PopupMenu(viewHolders.itemView.getContext(), viewHolders.getoption());
        popupMenu.getMenuInflater().inflate(R.menu.parcel_pickup_menu, popupMenu.getMenu());

        if (percel.getParcelStatus().equals("Return Branch  Run Start")) {
            popupMenu.getMenu().findItem(R.id.m_request_complete).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_accept).setVisible(true);
            popupMenu.getMenu().findItem(R.id.m_request_reject).setVisible(true);
            popupMenu.getMenu().findItem(R.id.m_request_reschedule).setVisible(false);

        } else if (percel.getParcelStatus().equals("Return Rider Accept")) {
            popupMenu.getMenu().findItem(R.id.m_request_accept).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_reject).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_reschedule).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_complete).setVisible(false);
            // Log.e("request", "hghhhg");
        } else if (percel.getParcelStatus().equals("Return Rider Reject")) {
            popupMenu.getMenu().findItem(R.id.m_request_accept).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_reject).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_reschedule).setVisible(false);
            popupMenu.getMenu().findItem(R.id.m_request_complete).setVisible(false);
        }


        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.m_request_accept:
                        progressDialog.show();
                        api.getreturnaccept(String.valueOf(percel.getParcelId())).enqueue(new Callback<PickupRequestAccept>() {
                            @Override
                            public void onResponse(Call<PickupRequestAccept> call, Response<PickupRequestAccept> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    progressDialog.dismiss();
                                    listener.onItemClick(5);
                                }
                            }

                            @Override
                            public void onFailure(Call<PickupRequestAccept> call, Throwable t) {

                            }
                        });


                        //  Toast.makeText(viewHolders.itemView.getContext(), "accept", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.m_request_reject:


                        MyAlertDialog myAlertDialog = new MyAlertDialog(viewHolders.itemView.getContext());
                        myAlertDialog.showConfirmDialog("Complete Request", "Confirm", "");
                        myAlertDialog.button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                myAlertDialog.cancel();
                                progressDialog.show();
                                api.getreturnreject(String.valueOf(percel.getParcelId())).enqueue(new Callback<PickupRequestAccept>() {
                                    @Override
                                    public void onResponse(Call<PickupRequestAccept> call, Response<PickupRequestAccept> response) {
                                        if (response.isSuccessful() && response.body() != null) {
                                            progressDialog.dismiss();
                                            listener.onItemClick(6);
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<PickupRequestAccept> call, Throwable t) {

                                    }
                                });
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
}
