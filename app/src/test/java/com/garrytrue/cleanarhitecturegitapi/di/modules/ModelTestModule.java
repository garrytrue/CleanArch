package com.garrytrue.cleanarhitecturegitapi.di.modules;


import com.garrytrue.cleanarhitecturegitapi.api.ApiInterface;
import com.garrytrue.cleanarhitecturegitapi.model.ModelImpl;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.mock;

@Module
public class ModelTestModule {

    @Provides
    @Singleton
    ApiInterface provideApiInterface() {
        return mock(ApiInterface.class);
    }

    @Provides
    @Singleton
    @Named(ModelImpl.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return Schedulers.immediate();
    }

    @Provides
    @Singleton
    @Named(ModelImpl.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.immediate();
    }
}
