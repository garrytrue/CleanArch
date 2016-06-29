package com.garrytrue.cleanarhitecturegitapi.dataStorage;

import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;

import java.util.List;

/**
 * Created by tiv on 29.06.2016.
 */
public interface IDataStorage {
    List<RepositoryDTO> getAllReposDTOs(String holderName);
    void addRepositryDTOs(List<RepositoryDTO> repositoryDTOList, String holderName);
    RepositoryDTO getRepositoryDTOByIndex(String holderName, int index);
    boolean isStorageContainData(String holderName);
}
