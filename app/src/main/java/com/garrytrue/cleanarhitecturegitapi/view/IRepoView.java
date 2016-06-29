package com.garrytrue.cleanarhitecturegitapi.view;

import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;

import java.util.List;

/**
 * Created by tiv on 29.06.2016.
 */
public interface IRepoView extends IView {
    void showList(List<RepositoryVO> repositoryVOs);

    void showEmptyList();

    String getUserName();
    
}
