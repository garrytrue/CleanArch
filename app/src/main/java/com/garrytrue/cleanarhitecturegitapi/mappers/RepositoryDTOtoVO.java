package com.garrytrue.cleanarhitecturegitapi.mappers;

import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by garrytrue on 25.06.16.
 */
public class RepositoryDTOtoVO implements Func1<List<RepositoryDTO>, List<RepositoryVO>> {
    @Inject
    public RepositoryDTOtoVO() {}

    @Override
    public List<RepositoryVO> call(List<RepositoryDTO> repositoryDTOs) {
        return Observable.from(repositoryDTOs)
                .map(repositoryDTO -> new RepositoryVO(repositoryDTO.getName(), repositoryDTO.getOwner().getLogin(), repositoryDTO.getBranchesUrl()))
                .toList()
                .toBlocking()
                .first();
    }
}
