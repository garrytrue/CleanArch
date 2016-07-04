package com.garrytrue.cleanarhitecturegitapi.di.modules;



import com.garrytrue.cleanarhitecturegitapi.presenter.RepoInfoPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module
public class ViewTestModule {

    @Provides
    @Singleton
    RepoInfoPresenter provideRepoInfoPresenter() {
        return mock(RepoInfoPresenter.class);
    }

}
