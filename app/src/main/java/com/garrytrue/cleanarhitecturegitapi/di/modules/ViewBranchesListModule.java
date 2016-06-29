package com.garrytrue.cleanarhitecturegitapi.di.modules;

import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoInfoPresenter;
import com.garrytrue.cleanarhitecturegitapi.view.IRepoInfoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tiv on 29.06.2016.
 */
@Module
public class ViewBranchesListModule {
    IRepoInfoView view;
    RepositoryVO repositoryVO;

    public ViewBranchesListModule(IRepoInfoView view, RepositoryVO repositoryVO) {
        this.view = view;
        this.repositoryVO = repositoryVO;
    }

    @Provides
    RepoInfoPresenter provideRepoInfoPresenter() {
        return new RepoInfoPresenter(view, repositoryVO);
    }
}
