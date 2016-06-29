package com.garrytrue.cleanarhitecturegitapi.view;

import com.garrytrue.cleanarhitecturegitapi.model.data.vo.BranchVO;

import java.util.List;

/**
 * Created by tiv on 29.06.2016.
 */
public interface IRepoInfoView extends IView {
    void showBranchesList(List<BranchVO> branchVOs);
}
