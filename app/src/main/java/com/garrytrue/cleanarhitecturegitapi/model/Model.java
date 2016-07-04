package com.garrytrue.cleanarhitecturegitapi.model;

import com.garrytrue.cleanarhitecturegitapi.model.data.dto.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.ContributorDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;

import java.util.List;

import rx.Observable;

/**
 * Created by garrytrue on 24.06.16.
 */
public interface Model {
    Observable<List<RepositoryDTO>> getRepoByUser(String name);

    Observable<List<BranchDTO>> getRepoBranches(String owner, String name);
}
