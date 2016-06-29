package com.garrytrue.cleanarhitecturegitapi.di.components;

import com.garrytrue.cleanarhitecturegitapi.di.modules.ModelModule;
import com.garrytrue.cleanarhitecturegitapi.di.modules.PresenterModule;
import com.garrytrue.cleanarhitecturegitapi.model.ModelImpl;
import com.garrytrue.cleanarhitecturegitapi.presenter.BasePresenter;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoInfoPresenter;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoListPresenter;
import com.garrytrue.cleanarhitecturegitapi.view.RepoInfoFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tiv on 29.06.2016.
 */
@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class})
public interface AppComponent {
    void inject(ModelImpl dataRepository);

    void inject(BasePresenter basePresenter);

    void inject(RepoListPresenter repoListPresenter);

    void inject(RepoInfoPresenter repoInfoPresenter);
}
