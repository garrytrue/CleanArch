package com.garrytrue.cleanarhitecturegitapi.presenter;

import android.util.Log;

import com.garrytrue.cleanarhitecturegitapi.model.Model;
import com.garrytrue.cleanarhitecturegitapi.model.ModelImpl;
import com.garrytrue.cleanarhitecturegitapi.view.IView;

import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by garrytrue on 25.06.16.
 */
public class RepoListPresenter implements Presenter {
    private static final String TAG = "RepoListPresenter";
    private final Model model = new ModelImpl();
    private Subscription subscription = Subscriptions.empty();
    private IView view;

    public RepoListPresenter(IView view) {
        this.view = view;
    }

    @Override
    public void onSearchClick() {
        makeUnsubscribe();
        Log.d(TAG, "onSearchClick: ");
        subscription = model.getRepoByUser(view.getUserName())
                .subscribe(repos -> {
                    Log.d(TAG, "onNext: " + repos);
                    if (repos != null && !repos.isEmpty()) {
                        view.showList(repos);
                    } else {
                        view.showEmptyList();
                    }
                }, error -> {
                    Log.d(TAG, "onError: " + error.getMessage());
                    view.showError(error.getMessage());
                }, () -> {
                    Log.d(TAG, "onComplete: ");
                });
    }


    @Override
    public void onStop() {
        makeUnsubscribe();
    }

    private void makeUnsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
