package com.garrytrue.cleanarhitecturegitapi.view;

/**
 * Created by garrytrue on 25.06.16.
 */
public interface IView {
    void showError(String error);

    void showLoading();

    void hideLoading();
}
