package com.garrytrue.cleanarhitecturegitapi.view;

import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;

import java.util.List;

/**
 * Created by garrytrue on 25.06.16.
 */
public interface IView {
    void showError(String error);

    void showLoading();

    void hideLoading();
}
