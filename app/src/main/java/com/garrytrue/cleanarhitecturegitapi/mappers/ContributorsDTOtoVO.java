package com.garrytrue.cleanarhitecturegitapi.mappers;

import com.garrytrue.cleanarhitecturegitapi.model.data.dto.ContributorDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.ContributorVO;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by garrytrue on 25.06.16.
 */
public class ContributorsDTOtoVO implements Func1<List<ContributorDTO> , List<ContributorVO>> {
    @Override
    public List<ContributorVO> call(List<ContributorDTO> contributorDTOs) {
        return Observable.from(contributorDTOs).map(contributorDTO -> new ContributorVO(contributorDTO.getLogin())).toList().toBlocking().first();
    }
}
