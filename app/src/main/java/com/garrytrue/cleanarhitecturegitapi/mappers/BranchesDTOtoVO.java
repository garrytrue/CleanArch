package com.garrytrue.cleanarhitecturegitapi.mappers;

import com.garrytrue.cleanarhitecturegitapi.model.data.dto.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.BranchVO;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by garrytrue on 25.06.16.
 */
public class BranchesDTOtoVO implements Func1<List<BranchDTO>, List<BranchVO>> {
    @Override
    public List<BranchVO> call(List<BranchDTO> branchDTOs) {
        return Observable.from(branchDTOs).map(branchDTO -> new BranchVO(branchDTO.getName())).toList().toBlocking().first();
    }
}
