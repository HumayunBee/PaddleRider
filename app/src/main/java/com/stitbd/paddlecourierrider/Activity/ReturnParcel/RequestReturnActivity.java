package com.stitbd.paddlecourierrider.Activity.ReturnParcel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.stitbd.paddlecourierrider.Adaptar.ReturnParcelAdaptar.RequestReturnAdaptar;
import com.stitbd.paddlecourierrider.Model.Return.ReturnListContainer;
import com.stitbd.paddlecourierrider.Model.Return.ReturnParcel;
import com.stitbd.paddlecourierrider.Network.Api;
import com.stitbd.paddlecourierrider.Network.RetrofitClient;
import com.stitbd.paddlecourierrider.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestReturnActivity extends AppCompatActivity {

    Api api;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_return);
        recyclerView = findViewById(R.id.rv_pickup_list);

        TextView toolbar = findViewById(R.id.tv_toolbar_title);
        toolbar.setText("Request Return Parcel");
        ImageView toolbarBack = findViewById(R.id.tv_back);

        toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        progressDialog = new ProgressDialog(RequestReturnActivity.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        api.getReturnparcellist().enqueue(new Callback<ReturnListContainer>() {
            @Override
            public void onResponse(Call<ReturnListContainer> call, Response<ReturnListContainer> response) {
                if (response.isSuccessful() && response.body() != null) {
                    progressDialog.dismiss();

                    List<ReturnParcel> parcelInfos = new ArrayList<>();
                    for (int i = 0; i < response.body().getParcels().size(); i++) {
                        ReturnParcel orderInfo = response.body().getParcels().get(i);
                        if (orderInfo.getStatus() == 34) {
                            parcelInfos.add(orderInfo);
                        }
                    }
                    if (parcelInfos.size() > 0) {
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    RequestReturnAdaptar adaptar = new RequestReturnAdaptar(parcelInfos, getApplicationContext());
                    recyclerView.setAdapter(adaptar);
                    Log.e("ddd",String.valueOf(response.body().getParcels().size()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ReturnListContainer> call, Throwable t) {

            }
        });
    }

}