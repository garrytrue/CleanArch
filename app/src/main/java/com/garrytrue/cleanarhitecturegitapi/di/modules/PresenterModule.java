package com.garrytrue.cleanarhitecturegitapi.di.modules;

import com.garrytrue.cleanarhitecturegitapi.model.Model;
import com.garrytrue.cleanarhitecturegitapi.model.ModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tiv on 29.06.2016.
 */
@Module
public class PresenterModule {
    @Provides
    @Singleton
    Model provideModel(){
        return new ModelImpl();
    }
    @Provides
    CompositeSubscription provideCompositeSubscription(){
        return new CompositeSubscription();
    }
}
