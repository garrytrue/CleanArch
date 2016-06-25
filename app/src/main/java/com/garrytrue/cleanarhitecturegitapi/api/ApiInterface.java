package com.garrytrue.cleanarhitecturegitapi.api;

import com.garrytrue.cleanarhitecturegitapi.model.data.dto.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.ContributorDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;

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

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<ContributorDTO>> getContributors(@Path("owner") String owner, @Path("repo") String repo);

    @GET("/repos/{owner}/{repo}/branches")
    Observable<List<BranchDTO>> getBranches(@Path("owner") String owner, @Path("repo") String repo);

}
