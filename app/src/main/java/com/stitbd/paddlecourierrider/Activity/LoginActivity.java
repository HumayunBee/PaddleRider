package com.stitbd.paddlecourierrider.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.stitbd.paddlecourierrider.Network.Api;
import com.stitbd.paddlecourierrider.Network.RetrofitClient;
import com.stitbd.paddlecourierrider.Util.Constant;
import com.stitbd.paddlecourierrider.Util.MySharedPreference;
import com.stitbd.paddlecourierrider.databinding.ActivityLoginBinding;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    Api api;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String Token = MySharedPreference.getInstance(getApplicationContext()).getString(Constant.TOKEN, "not found");
        if (!Token.equals(new String("not found"))) {
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            finish();
        }
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(binding.etUserName.getText().toString())) {
//                    if (!TextUtils.isEmpty(binding.tvForgotPassword.getText().toString())) {
                        progressDialog.show();
                        api = RetrofitClient.noInterceptor().create(Api.class);
                        Call<JsonObject> call = api.login(binding.etUserName.getText().toString(),
                                binding.etPassword.getText().toString());
                        call.enqueue(new Callback<JsonObject>() {
                            @Override
                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                //  Log.e("tesst",response.toString());
                                progressDialog.dismiss();
                                if (response.isSuccessful() && response.body() != null) {
                                    String token = response.body().get("token").getAsString();
                                    JsonObject rider = response.body().getAsJsonObject("rider");
                                    Log.e("tesst", token);
                                    String name = rider.get("name").getAsString();
                                    String phn = rider.get("contact_number").getAsString();
                                    String MercentId = rider.get("id").getAsString();
                                    Log.e("tesst", response.body().toString());

                                    MySharedPreference.getInstance(LoginActivity.this).edit()
                                            .putString(Constant.TOKEN, token).putString(Constant.NAME, name).putString(Constant.PHONE, phn)
                                            .putString(Constant.MERCENTID, MercentId).apply();
                                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                                    finish();

                                } else {
                                    progressDialog.dismiss();
                                    try {
                                        Log.e("tesst", response.errorBody().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(LoginActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                progressDialog.dismiss();
                                Log.e("tesst", t.toString());
                                Toast.makeText(getApplicationContext(), "Network or Server Error", Toast.LENGTH_SHORT).show();
                            }
                        });
//                    } else {
//                        binding.etPassword.setError("Please Input Valid email!!");
//                        binding.etPassword.requestFocus();
//                    }
                } else {
                    binding.etUserName.setError("Please Input Valid password!!");
                    binding.etUserName.requestFocus();
                }
            }
        });

    }
}