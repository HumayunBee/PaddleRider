package com.stitbd.paddlecourierrider.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stitbd.paddlecourierrider.Activity.CollectionParcel.CollectionParcelActivity;
import com.stitbd.paddlecourierrider.Activity.DeliveryParcel.AcceptDeliveryActivity;
import com.stitbd.paddlecourierrider.Activity.DeliveryParcel.DeliveryParcelListActivity;
import com.stitbd.paddlecourierrider.Activity.DeliveryParcel.RequestDeliveryActivity;
import com.stitbd.paddlecourierrider.Activity.PaidAmount.PaidAmountActivity;
import com.stitbd.paddlecourierrider.Activity.PickupParcel.AcceptPickActivity;
import com.stitbd.paddlecourierrider.Activity.PickupParcel.PickupParcelActivity;
import com.stitbd.paddlecourierrider.Activity.PickupParcel.RequestPickupActivity;
import com.stitbd.paddlecourierrider.Activity.ReturnParcel.RequestReturnActivity;
import com.stitbd.paddlecourierrider.Activity.ReturnParcel.ReturnAcceptParcelActivity;
import com.stitbd.paddlecourierrider.Activity.ReturnParcel.ReturnActivity;
import com.stitbd.paddlecourierrider.Model.Dashboard.DashBordDataContainer;
import com.stitbd.paddlecourierrider.Model.RiderProfile.RiderContainer;
import com.stitbd.paddlecourierrider.Network.Api;
import com.stitbd.paddlecourierrider.Network.RetrofitClient;
import com.stitbd.paddlecourierrider.R;
import com.stitbd.paddlecourierrider.Util.Constant;
import com.stitbd.paddlecourierrider.Util.MySharedPreference;
import com.google.android.material.navigation.NavigationView;
import com.skydoves.expandablelayout.ExpandableAnimation;
import com.skydoves.expandablelayout.ExpandableLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    Api api;
    TextView textView, textView2, toolbar, requst, CollectionParcel, Logout, PaidParcel;
    ImageView imageView, imageView2, imageView3;
    NavigationView nav;
    //    RecyclerView recyclerView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    ProgressDialog progressDialog;
    SwipeRefreshLayout swipeRefreshLayout;

    TextView TodayPickupRe, TodayPicDone, TodayDeRequest, TodayDeDone, TodayDeliPend, TodayDeliveryCan, TotalPicParcel, TotalDeliveryParcel,
            BalanceAmount, TotalCollectionAm, TotalPaidBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TodayPickupRe=findViewById(R.id.today_pickup_parcel);
        TodayPicDone=findViewById(R.id.today_pickup_done);
        TodayDeRequest=findViewById(R.id.today_delivery_parcel);
        TodayDeDone=findViewById(R.id.today_delivery_done);
        TodayDeliPend=findViewById(R.id.today_delivery_pending);
        TodayDeliveryCan=findViewById(R.id.today_delivery_cancle);
        TotalPicParcel=findViewById(R.id.total_pickup_parcel);
        TotalDeliveryParcel=findViewById(R.id.total_delivery_parcel);
        BalanceAmount=findViewById(R.id.balance_amount);
        TotalCollectionAm=findViewById(R.id.total_collection_amount);
        TotalPaidBranch=findViewById(R.id.total_paid_branch);
        swipeRefreshLayout=findViewById(R.id.swip);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setDashBoardData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        toolbar = findViewById(R.id.tv_toolbar_title);
        toolbar.setText("Dashboard");
//        recyclerView = findViewById(R.id.rv_list);
        CollectionParcel = findViewById(R.id.tv_nav_collection_parcel_list);

        requst = findViewById(R.id.tv_nav_pickup_parcel_list);


        ExpandableLayout expandableLayout
                = findViewById(R.id.expandable);
        expandableLayout.setExpandableAnimation(ExpandableAnimation.NORMAL);

        ExpandableLayout expandableLayoutd
                = findViewById(R.id.expandable_delivery);
        expandableLayoutd.setExpandableAnimation(ExpandableAnimation.NORMAL);

        ExpandableLayout expandableLayoutr
                = findViewById(R.id.expandable_return);
        expandableLayoutd.setExpandableAnimation(ExpandableAnimation.NORMAL);


        imageView2 = findViewById(R.id.tv_back);
        imageView3 = findViewById(R.id.iv_nav);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.VISIBLE);
        textView = findViewById(R.id.tv_user_name);
        textView2 = findViewById(R.id.tv_phone);
        Logout = findViewById(R.id.tv_nav_logout);
        PaidParcel = findViewById(R.id.tv_nav_paid_parcel_list);
        nav = (NavigationView) findViewById(R.id.navbar);
        drawerLayout = findViewById(R.id.drawerlayout);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        progressDialog = new ProgressDialog(DashboardActivity.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);


        PaidParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Pintent = new Intent(DashboardActivity.this, PaidAmountActivity.class);
                startActivity(Pintent);
            }
        });


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySharedPreference.editor(getApplicationContext()).clear().commit();
                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                finish();
            }
        });


        CollectionParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cintent = new Intent(DashboardActivity.this, CollectionParcelActivity.class);
                startActivity(cintent);
            }
        });

///////return parcel list start

        expandableLayoutr.parentLayout.findViewById(R.id.tv_nav_return_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rintent = new Intent(DashboardActivity.this, ReturnActivity.class);
                startActivity(rintent);
            }
        });

        expandableLayoutr.parentLayout.findViewById(R.id.Rdown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayoutr.expand();
                expandableLayoutr.collapse();
            }
        });

        expandableLayoutr.secondLayout.findViewById(R.id.tv_nav_pickup_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reqintent = new Intent(DashboardActivity.this, RequestReturnActivity.class);
                startActivity(reqintent);
            }
        });

        expandableLayoutr.secondLayout.findViewById(R.id.tv_nav_accept_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reqintent = new Intent(DashboardActivity.this, ReturnAcceptParcelActivity.class);
                startActivity(reqintent);
            }
        });


        ///////return parcel list end


        /////////   Pickup Parcel List and sub list start

        expandableLayout.parentLayout.findViewById(R.id.tv_nav_pickup_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, PickupParcelActivity.class);
                startActivity(intent);
            }
        });

        expandableLayout.secondLayout.findViewById(R.id.tv_nav_rpickup_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(DashboardActivity.this, RequestPickupActivity.class);
                startActivity(inte);
            }
        });

        expandableLayout.secondLayout.findViewById(R.id.tv_nav_accept_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(DashboardActivity.this, AcceptPickActivity.class);
                startActivity(inte);
            }
        });

        expandableLayout.parentLayout.findViewById(R.id.down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout.expand();
                expandableLayout.collapse();
            }
        });
        /////////   Pickup Parcel List and sub list end


        ///////////delivery parcel list and sub menu start
        expandableLayoutd.parentLayout.findViewById(R.id.tv_nav_delivery_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, DeliveryParcelListActivity.class);
                startActivity(intent);
            }
        });

        expandableLayoutd.parentLayout.findViewById(R.id.Ddown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayoutd.expand();
                expandableLayoutd.collapse();
            }
        });

        expandableLayoutd.secondLayout.findViewById(R.id.tv_nav_dpickup_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, RequestDeliveryActivity.class);
                startActivity(intent);
            }
        });
        expandableLayoutd.secondLayout.findViewById(R.id.tv_nav_daccept_parcel_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AcceptDeliveryActivity.class);
                startActivity(intent);
            }
        });

        ///////////delivery parcel list and sub menu end

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        api.getprofile().enqueue(new Callback<RiderContainer>() {
            @Override
            public void onResponse(Call<RiderContainer> call, Response<RiderContainer> response) {
                if (response.isSuccessful() && response.body() != null) {

                    imageView = findViewById(R.id.iv_user_image);
                    Glide.with(DashboardActivity.this).load(response.body().getRider().getImage()).into(imageView);
                }
            }

            @Override
            public void onFailure(Call<RiderContainer> call, Throwable t) {


            }
        });


        textView.setText(MySharedPreference.getInstance(getApplicationContext()).getString(Constant.NAME, "not found"));
        textView2.setText(MySharedPreference.getInstance(getApplicationContext()).getString(Constant.PHONE, "not found"));

//        progressDialog.show();


    }

    @Override
    public void onResume() {
        super.onResume();
        // put your code here...
        setDashBoardData();

    }

    public void setDashBoardData() {
        progressDialog.show();
        api.getDashboarddata().enqueue(new Callback<DashBordDataContainer>() {
            @Override
            public void onResponse(Call<DashBordDataContainer> call, Response<DashBordDataContainer> response) {
                //  Log.e("datt",String.valueOf(response.body().getMessage()));
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {

                    TodayPickupRe.setText(String.valueOf(response.body().getDashBoardData().getTodayPickupParcel()));
                    TodayPicDone.setText(String.valueOf(response.body().getDashBoardData().getTodayPickupComplete()));
                    TodayDeRequest.setText(String.valueOf(response.body().getDashBoardData().getTodayDeliveryParcels()));
                    TodayDeDone.setText(String.valueOf(response.body().getDashBoardData().getTodayDeliveryComplete()));
                    TodayDeliPend.setText(String.valueOf(response.body().getDashBoardData().getTodayDeliveryPending()));
                    TodayDeliveryCan.setText(String.valueOf(response.body().getDashBoardData().getTodayDeliveryCancel()));
                    TotalPicParcel.setText(String.valueOf(response.body().getDashBoardData().getTotalPickupParcel()));
                    TotalDeliveryParcel.setText(String.format("%1$,.0f",response.body().getDashBoardData().getTotalDeliveryParcels()));
                    BalanceAmount.setText(String.valueOf(response.body().getDashBoardData().getEcourierBalanceCollectAmount()));
                    TotalCollectionAm.setText(String.valueOf(response.body().getDashBoardData().getEcourierTotalCollectAmount()));
                    TotalPaidBranch.setText(String.valueOf(response.body().getDashBoardData().getEcourierPaidToBranch()));

//                    recyclerView.setHasFixedSize(true);
//                    recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),
//                            2));
//                    DashBoardAdaptar adapter = new DashBoardAdaptar(response.body().getDashBoardData().getlist(), getApplicationContext());
//                    recyclerView.setAdapter(adapter);
                } else if (response.code() == 400) {
                    MySharedPreference.remove(getApplicationContext());
                    startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                }
            }

            @Override
            public void onFailure(Call<DashBordDataContainer> call, Throwable t) {
                progressDialog.dismiss();
                MySharedPreference.remove(getApplicationContext());
                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                Toast.makeText(DashboardActivity.this, "Please LogIn", Toast.LENGTH_SHORT).show();
                Log.d("tesst", t.toString());
            }
        });

    }
}