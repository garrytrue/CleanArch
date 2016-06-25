package com.garrytrue.cleanarhitecturegitapi.model;

import com.garrytrue.cleanarhitecturegitapi.model.data.Repo;

import java.util.List;

import rx.Observable;

/**
 * Created by garrytrue on 24.06.16.
 */
public interface Model {
    Observable<List<Repo>> getRepoByUser(String name);
}
