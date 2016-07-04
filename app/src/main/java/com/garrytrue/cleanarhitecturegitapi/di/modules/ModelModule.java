package com.garrytrue.cleanarhitecturegitapi.di.modules;

import com.garrytrue.cleanarhitecturegitapi.api.ApiInterface;
import com.garrytrue.cleanarhitecturegitapi.api.ApiModule;
import com.garrytrue.cleanarhitecturegitapi.model.ModelImpl;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tiv on 29.06.2016.
 */
@Module
public class ModelModule {
    @Provides
    @Singleton
    ApiInterface provideApiInterface(){
        return ApiModule.getApiInterface(ApiModule.BASE_URL);
    }
    @Provides
    @Singleton
    @Named(ModelImpl.IO_THREAD)
    Scheduler provideIOScheduler(){
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named(ModelImpl.UI_THREAD)
    Scheduler provideMainThreadScheduler(){
        return AndroidSchedulers.mainThread();
    }
}
