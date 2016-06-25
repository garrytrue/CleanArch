package com.garrytrue.cleanarhitecturegitapi.presenter;

import com.garrytrue.cleanarhitecturegitapi.model.Model;
import com.garrytrue.cleanarhitecturegitapi.model.ModelImpl;
import com.garrytrue.cleanarhitecturegitapi.model.data.Repo;
import com.garrytrue.cleanarhitecturegitapi.view.IView;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by garrytrue on 25.06.16.
 */
public class RepoListPresenter implements Presenter {
    private final Model model = new ModelImpl();
    private Subscription subscription = Subscriptions.empty();
    private IView view;

    public RepoListPresenter(IView view) {
        this.view = view;
    }

    @Override
    public void onSearchClick() {
        makeUnsubscribe();
        
        subscription = model.getRepoByUser(view.getUserName())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        if (repos != null && !repos.isEmpty()) {
                            view.showList(repos);
                        } else {
                            view.showEmptyList();
                        }
                    }
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
