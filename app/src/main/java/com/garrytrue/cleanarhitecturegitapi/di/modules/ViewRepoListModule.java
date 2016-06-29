package com.garrytrue.cleanarhitecturegitapi.di.modules;

import com.garrytrue.cleanarhitecturegitapi.presenter.RepoListPresenter;
import com.garrytrue.cleanarhitecturegitapi.view.IRepoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tiv on 29.06.2016.
 */
@Module
public class ViewRepoListModule {
    IRepoView view;

    public ViewRepoListModule(IRepoView view) {
        this.view = view;
    }

    @Provides
    RepoListPresenter provideRepoListPresenter() {
        return new RepoListPresenter(view);
    }

}
