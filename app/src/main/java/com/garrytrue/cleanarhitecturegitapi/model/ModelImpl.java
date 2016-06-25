package com.garrytrue.cleanarhitecturegitapi.model;

import com.garrytrue.cleanarhitecturegitapi.api.ApiInterface;
import com.garrytrue.cleanarhitecturegitapi.api.ApiModule;
import com.garrytrue.cleanarhitecturegitapi.model.data.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.ContributorDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.RepositoryDTO;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by garrytrue on 24.06.16.
 */
public class ModelImpl implements Model {
    ApiInterface apiInterface = ApiModule.getApiInterface();

    @Override
    public Observable<List<RepositoryDTO>> getRepoByUser(String name) {
        return apiInterface.getRepositories(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<BranchDTO>> getRepoBranches(String owner, String name) {
        return null;
    }

    @Override
    public Observable<List<ContributorDTO>> getRepoContributors(String owner, String name) {
        return null;
    }
}
