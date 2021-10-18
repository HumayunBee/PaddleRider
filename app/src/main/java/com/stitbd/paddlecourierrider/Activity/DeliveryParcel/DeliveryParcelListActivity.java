package com.stitbd.paddlecourierrider.Activity.DeliveryParcel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.stitbd.paddlecourierrider.Adaptar.DeliveryParcelListAdaptar.DeliveryAdaptar;
import com.stitbd.paddlecourierrider.Model.DeliveryParcel.DeliveryContainer;
import com.stitbd.paddlecourierrider.Network.Api;
import com.stitbd.paddlecourierrider.Network.RetrofitClient;
import com.stitbd.paddlecourierrider.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeliveryParcelListActivity extends AppCompatActivity {

    Api api;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_parcel_list);

        recyclerView = findViewById(R.id.rv_pickup_list);
        progressDialog = new ProgressDialog(DeliveryParcelListActivity.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);
        TextView toolbar = findViewById(R.id.tv_toolbar_title);
        toolbar.setText("Delivery Parcel List");
        ImageView toolbarBack = findViewById(R.id.tv_back);

        toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
       // datainitialize();
    }

    @Override
    public void onResume() {
        super.onResume();
        datainitialize();

    }

    void datainitialize() {
        //Toast.makeText(PickupParcelActivity.this, "tessting", Toast.LENGTH_SHORT).show();



        api = RetrofitClient.get(getApplicationContext()).create(Api.class);
         progressDialog.show();
        api.getDeliveryparcel().enqueue(new Callback<DeliveryContainer>() {
            @Override
            public void onResponse(Call<DeliveryContainer> call, Response<DeliveryContainer> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    DeliveryAdaptar adaptar = new DeliveryAdaptar(response.body().getParcels(), getApplicationContext(), new DeliveryAdaptar.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            datainitialize();
                        }
                    });
                    recyclerView.setAdapter(adaptar);
                    Log.e("hhh", String.valueOf(response.body().getParcels().size()));
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<DeliveryContainer> call, Throwable t) {
                Log.e("hhh", "failur");
                progressDialog.dismiss();
            }
        });

    }
}