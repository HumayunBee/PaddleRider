package com.stitbd.paddlecourierrider.Network;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient  {
    private static Retrofit retrofit = null;
    private static Retrofit retrofitWithDifBase = null;

    private static String BaseUrl="https://paddlecourier.com/";
    private static Retrofit retrofitWithNoIntercepter = null;

    private RetrofitClient() {
    }

    public static  Retrofit get(Context context) {

        if (retrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(new QueryParameterInterceptor(context));

            OkHttpClient client = httpClient.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public static Retrofit noInterceptor() {
        if (retrofitWithNoIntercepter == null) {
            retrofitWithNoIntercepter = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitWithNoIntercepter;
    }
    public static Retrofit difBaseUrle() {
        if (retrofitWithDifBase == null) {
            retrofitWithDifBase = new Retrofit.Builder()
                    .baseUrl("https://paddlecourier.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitWithDifBase;
    }
}
