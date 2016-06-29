package com.garrytrue.cleanarhitecturegitapi.presenter;

import android.os.Bundle;
import android.util.Log;

import com.garrytrue.cleanarhitecturegitapi.callbacks.IRepoClickListener;
import com.garrytrue.cleanarhitecturegitapi.mappers.RepositoryDTOtoVO;
import com.garrytrue.cleanarhitecturegitapi.model.Model;
import com.garrytrue.cleanarhitecturegitapi.model.ModelImpl;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;
import com.garrytrue.cleanarhitecturegitapi.view.IRepoView;
import com.garrytrue.cleanarhitecturegitapi.view.IView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by garrytrue on 25.06.16.
 */
public class RepoListPresenter extends BasePresenter implements IRepoClickListener {
    private static final String TAG = RepoListPresenter.class.getSimpleName();
    private IRepoView view;
    private static final String BUNDLE_REPO_LIST_KEY = "BUNDLE_REPO_LIST_KEY";
    private List<RepositoryVO> repoList;


    public RepoListPresenter(IRepoView view) {
        this.view = view;
    }

    public void onSearchClick() {
        Log.d(TAG, "onSearchClick: ");
        showLoadingState();
        Subscription subscription = model.getRepoByUser(view.getUserName()).map(new RepositoryDTOtoVO())
                .subscribe(repos -> {
                    Log.d(TAG, "onNext: " + repos);
                    repoList = repos;
                    if (isRepoListNotEmpty()) {
                        view.showList(repoList);
                    } else {
                        view.showEmptyList();
                    }
                }, error -> {
                    Log.d(TAG, "onError: " + error.getMessage());
                    view.showError(error.getMessage());
                }, () -> {
                    hideLoadingState();
                    Log.d(TAG, "onComplete: ");
                });
        addSubscription(subscription);
    }


    @Override
    protected IRepoView getView() {
        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            repoList = savedInstanceState.getParcelableArrayList(BUNDLE_REPO_LIST_KEY);
        }
        if (isRepoListNotEmpty()) {
            view.showList(repoList);
        }
    }

    private boolean isRepoListNotEmpty() {
        return (repoList != null && !repoList.isEmpty());
    }

    public void onSavedInstanceState(Bundle outState) {
        if (isRepoListNotEmpty()) {
            outState.putParcelableArrayList(BUNDLE_REPO_LIST_KEY, new ArrayList<>(repoList));
        }
    }

    @Override
    public void onRepoClicked(RepositoryVO repositoryVO) {
        Log.d(TAG, "onRepoClicked: " + repositoryVO);
        view.openRepoInfo(repositoryVO);
    }
}
