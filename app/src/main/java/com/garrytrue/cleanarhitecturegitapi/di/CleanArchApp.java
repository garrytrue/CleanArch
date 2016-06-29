package com.garrytrue.cleanarhitecturegitapi.di;

import android.app.Application;

import com.garrytrue.cleanarhitecturegitapi.di.components.AppComponent;
import com.garrytrue.cleanarhitecturegitapi.di.components.DaggerAppComponent;

/**
 * Created by tiv on 29.06.2016.
 */
public class CleanArchApp extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().build();
    }
}
