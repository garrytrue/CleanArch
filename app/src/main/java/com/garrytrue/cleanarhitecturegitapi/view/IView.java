package com.garrytrue.cleanarhitecturegitapi.view;

import com.garrytrue.cleanarhitecturegitapi.model.data.Repo;

import java.util.List;

/**
 * Created by garrytrue on 25.06.16.
 */
public interface IView {
    void showList(List<Repo> repos);
    void showError(String error);
    void showEmptyList();
    String getUserName();
}
