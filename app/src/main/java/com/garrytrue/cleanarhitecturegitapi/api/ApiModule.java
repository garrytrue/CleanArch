package com.garrytrue.cleanarhitecturegitapi.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by garrytrue on 24.06.16.
 */
public class ApiModule {
    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = "***"; //your code here
    public static final String BASE_URL = "https://api.github.com/";

    public static ApiInterface getApiInterface(String baseUrl) {
        OkHttpClient okHttpClient = new OkHttpClient();
        if (ENABLE_AUTH) {
            okHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                                .header("Authorization", AUTH_64)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });
        }
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);
        ApiInterface apiInterface = builder.build().create(ApiInterface.class);
        return apiInterface;
    }
}
