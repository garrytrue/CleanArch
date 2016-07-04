package com.garrytrue.cleanarhitecturegitapi.di.components;

import com.garrytrue.cleanarhitecturegitapi.di.modules.DataTestModule;
import com.garrytrue.cleanarhitecturegitapi.di.modules.ModelTestModule;
import com.garrytrue.cleanarhitecturegitapi.di.modules.PresenterTestModule;
import com.garrytrue.cleanarhitecturegitapi.model.ModelTestImpl;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoInfoPresenterTest;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoListPresenterTest;
import com.garrytrue.cleanarhitecturegitapi.presenter.mappers.RepoBranchesMapperTest;
import com.garrytrue.cleanarhitecturegitapi.presenter.mappers.RepoListMapperTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tiv on 30.06.2016.
 */
@Singleton
@Component(modules = {ModelTestModule.class, PresenterTestModule.class, DataTestModule.class})
public interface TestComponent extends AppComponent {
    void inject(ModelTestImpl modelTest);

    void inject(RepoInfoPresenterTest repoInfoPresenterTest);

    void inject(RepoListPresenterTest repoListPresenterTest);

    void inject(RepoBranchesMapperTest repoBranchesMapperTest);

    void inject(RepoListMapperTest userReposMapperTest);

//    void inject(RepoInfoFragmentTest repoInfoFragmentTest);
//
//    void inject(RepoListFragmentTest repoListFragmentTest);
//
//    void inject(BaseFragmentTest baseFragmentTest);
}
