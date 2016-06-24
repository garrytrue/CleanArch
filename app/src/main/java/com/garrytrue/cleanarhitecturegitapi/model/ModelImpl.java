package com.garrytrue.cleanarhitecturegitapi.model;

import java.util.List;

import rx.Observable;

/**
 * Created by garrytrue on 24.06.16.
 */
public class ModelImpl implements Model {
    @Override
    public Observable<List<Repo>> getRepoByUser(String name) {
        return null;
    }
}
