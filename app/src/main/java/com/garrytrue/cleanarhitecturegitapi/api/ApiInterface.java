package com.garrytrue.cleanarhitecturegitapi.api;

import com.garrytrue.cleanarhitecturegitapi.model.data.RepositoryDTO;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by garrytrue on 24.06.16.
 */
public interface ApiInterface {
    @GET("users/{username}/repos")
    Observable<List<RepositoryDTO>> getRepositories(@Path("username") String userName);
}
