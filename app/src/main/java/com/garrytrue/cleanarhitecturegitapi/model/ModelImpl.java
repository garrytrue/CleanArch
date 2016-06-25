package com.garrytrue.cleanarhitecturegitapi.model;

import com.garrytrue.cleanarhitecturegitapi.api.ApiInterface;
import com.garrytrue.cleanarhitecturegitapi.api.ApiModule;
import com.garrytrue.cleanarhitecturegitapi.model.data.Repo;

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
    public Observable<List<Repo>> getRepoByUser(String name) {
        return apiInterface.getRepositories(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
