package com.garrytrue.cleanarhitecturegitapi.dataStorage;

import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tiv on 29.06.2016.
 */
public class InternalDataStorage implements IDataStorage {
    private final Map<String, List<RepositoryDTO>> internalStorage = new HashMap<>();

    @Override
    public List<RepositoryDTO> getAllReposDTOs(String holderName) {
        return internalStorage.get(holderName);
    }

    @Override
    public void addRepositryDTOs(List<RepositoryDTO> repositoryDTOList, String holderName) {
        internalStorage.put(holderName, repositoryDTOList);
    }

    @Override
    public RepositoryDTO getRepositoryDTOByIndex(String holderName, int index) {
        return internalStorage.get(holderName).get(index);
    }

    @Override
    public boolean isStorageContainData(String holderName) {
        return internalStorage.containsKey(holderName);
    }
}
