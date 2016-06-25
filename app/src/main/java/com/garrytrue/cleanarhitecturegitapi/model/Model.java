package com.garrytrue.cleanarhitecturegitapi.model;

import com.garrytrue.cleanarhitecturegitapi.model.data.RepositoryDTO;

import java.util.List;

import rx.Observable;

/**
 * Created by garrytrue on 24.06.16.
 */
public interface Model {
    Observable<List<RepositoryDTO>> getRepoByUser(String name);
}
