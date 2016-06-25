package com.garrytrue.cleanarhitecturegitapi.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by garrytrue on 24.06.16.
 */
public class ApiModule {
    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = "***"; //your code here

    public static ApiInterface getApiInterface() {
        OkHttpClient okHttpClient = new OkHttpClient();
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

        return ;
    }
}
