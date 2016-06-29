package com.garrytrue.cleanarhitecturegitapi.di.components;

import com.garrytrue.cleanarhitecturegitapi.di.modules.ViewRepoListModule;
import com.garrytrue.cleanarhitecturegitapi.view.RepoListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tiv on 29.06.2016.
 */
@Singleton
@Component(modules = ViewRepoListModule.class)
public interface ViewRepoListComponent {
    void inject (RepoListFragment repoListFragment);
}
