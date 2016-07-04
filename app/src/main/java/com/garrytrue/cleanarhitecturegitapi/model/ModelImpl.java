package com.garrytrue.cleanarhitecturegitapi.model;

import com.garrytrue.cleanarhitecturegitapi.api.ApiInterface;
import com.garrytrue.cleanarhitecturegitapi.api.ApiModule;
import com.garrytrue.cleanarhitecturegitapi.di.CleanArchApp;
import com.garrytrue.cleanarhitecturegitapi.di.components.AppComponent;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.ContributorDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by garrytrue on 24.06.16.
 */
public class ModelImpl implements Model {
    public static final String UI_THREAD = "UI_THREAD";
    public static final String  IO_THREAD = "IO_THREAD";
   @Inject
   protected ApiInterface apiInterface;

    public ModelImpl() {
        CleanArchApp.getAppComponent().inject(this);
    }

    @Override
    public Observable<List<RepositoryDTO>> getRepoByUser(String name) {
        return apiInterface.getRepositories(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<BranchDTO>> getRepoBranches(String owner, String name) {
        return apiInterface.getBranches(owner, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
