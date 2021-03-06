package com.garrytrue.cleanarhitecturegitapi.presenter;

import android.os.Bundle;

import com.garrytrue.cleanarhitecturegitapi.di.CleanArchApp;
import com.garrytrue.cleanarhitecturegitapi.model.Model;
import com.garrytrue.cleanarhitecturegitapi.model.ModelImpl;
import com.garrytrue.cleanarhitecturegitapi.view.IView;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tiv on 29.06.2016.
 */
public abstract class BasePresenter implements Presenter {

    public BasePresenter() {
        CleanArchApp.getAppComponent().inject(this);
    }
    @Inject
    Model model;

    @Inject
    CompositeSubscription compositeSubscription;

    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }

    protected abstract IView getView();

    protected void showLoadingState() {
        getView().showLoading();
    }

    protected void hideLoadingState() {
        getView().hideLoading();
    }

    protected void showError(Throwable error){getView().showError(error.getMessage());}

    public abstract void onCreate(Bundle savedInstanceState);

    public abstract void onSavedInstanceState(Bundle outState);

}
