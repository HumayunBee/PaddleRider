package com.stitbd.paddlecourierrider.Activity.CollectionParcel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.stitbd.paddlecourierrider.Adaptar.CollectionAdaptar.Collectionadaptar;
import com.stitbd.paddlecourierrider.Model.Collection.CollectionContainer;
import com.stitbd.paddlecourierrider.Network.Api;
import com.stitbd.paddlecourierrider.Network.RetrofitClient;
import com.stitbd.paddlecourierrider.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionParcelActivity extends AppCompatActivity {


    Api api;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_parcel);

        recyclerView = findViewById(R.id.rv_pickup_list);

        TextView toolbar = findViewById(R.id.tv_toolbar_title);
        toolbar.setText("Collection Parcel List");
        ImageView toolbarBack =  findViewById(R.id.tv_back);

        toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        progressDialog = new ProgressDialog(CollectionParcelActivity.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        api.getCollectionparcel().enqueue(new Callback<CollectionContainer>() {
            @Override
            public void onResponse(Call<CollectionContainer> call, Response<CollectionContainer> response) {
                if (response.isSuccessful() && response.body() != null) {
                    progressDialog.dismiss();
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    Collectionadaptar adaptar = new Collectionadaptar(response.body().getParcels(), getApplicationContext());
                    recyclerView.setAdapter(adaptar);
                    Log.e("ddd",String.valueOf(response.body().getParcels().size()));
                }
            }

            @Override
            public void onFailure(Call<CollectionContainer> call, Throwable t) {

            }
        });
    }
}