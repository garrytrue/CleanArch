package com.garrytrue.cleanarhitecturegitapi.di.components;

import com.garrytrue.cleanarhitecturegitapi.di.modules.ViewBranchesListModule;
import com.garrytrue.cleanarhitecturegitapi.view.RepoInfoFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tiv on 29.06.2016.
 */
@Singleton
@Component(modules = ViewBranchesListModule.class)
public interface ViewBranchesListComponent {
    void inject(RepoInfoFragment repoInfoFragment);
}
