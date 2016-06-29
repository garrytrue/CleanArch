package com.garrytrue.cleanarhitecturegitapi.presenter;

import android.os.Bundle;
import android.util.Log;

import com.garrytrue.cleanarhitecturegitapi.di.CleanArchApp;
import com.garrytrue.cleanarhitecturegitapi.mappers.BranchesDTOtoVO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.BranchVO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;
import com.garrytrue.cleanarhitecturegitapi.view.IRepoInfoView;
import com.garrytrue.cleanarhitecturegitapi.view.IView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by tiv on 29.06.2016.
 */
public class RepoInfoPresenter extends BasePresenter {
    private static final String TAG = RepoInfoPresenter.class.getSimpleName();
    private static final String BUNDLE_BRANCHES_KEY = "BUNDLE_BRANCHES_KEY";
    private IRepoInfoView view;
    private RepositoryVO repositoryVO;
    private List<BranchVO> branchList;
    @Inject
    BranchesDTOtoVO branchesMapper;

    public RepoInfoPresenter(IRepoInfoView view, RepositoryVO repositoryVO) {
        this.view = view;
        this.repositoryVO = repositoryVO;
        CleanArchApp.getAppComponent().inject(this);
    }

    @Override
    protected IView getView() {
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            branchList = savedInstanceState.getParcelableArrayList(BUNDLE_BRANCHES_KEY);
        }
        if (branchList == null) {
            loadData();
        } else {
            view.showBranchesList(branchList);
        }
    }

    private void loadData() {
        Log.d(TAG, "loadData: " + repositoryVO);
        showLoadingState();
        Subscription subscription = model.getRepoBranches(repositoryVO.getOwnerName(), repositoryVO.getRepoName())
                .map(branchesMapper).subscribe(
                        branchVOs -> {
                            Log.d(TAG, "loadData: " + branchVOs);
                            branchList = branchVOs;
                            view.showBranchesList(branchList);
                        },
                        error -> {
                            Log.d(TAG, "loadData: " +error);
                            view.showError(error.getLocalizedMessage());},
                        this::hideLoadingState);
        addSubscription(subscription);
    }

    @Override
    public void onSavedInstanceState(Bundle outState) {
        if (branchList != null && !branchList.isEmpty()) {
            outState.putParcelableArrayList(BUNDLE_BRANCHES_KEY, new ArrayList<>(branchList));
        }
    }
}
