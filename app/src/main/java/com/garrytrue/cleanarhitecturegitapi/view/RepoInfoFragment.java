package com.garrytrue.cleanarhitecturegitapi.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.garrytrue.cleanarhitecturegitapi.R;
import com.garrytrue.cleanarhitecturegitapi.adapters.BranchesAdapter;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.BranchVO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoInfoPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RepoInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RepoInfoFragment extends Fragment implements IRepoInfoView {
    public static final String TAG = RepoInfoFragment.class.getSimpleName();
    private static final String CURRENT_REPO = "CURRENT_REPO";
    private RepositoryVO mRepositoryVO;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private RepoInfoPresenter mPresenter;
    private BranchesAdapter mAdapter;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mRepositoryVO
     * @return A new instance of fragment RepoInfoFragment.
     */
    public static RepoInfoFragment newInstance(RepositoryVO repositoryVO) {
        RepoInfoFragment fragment = new RepoInfoFragment();
        Bundle args = new Bundle();
        args.putParcelable(CURRENT_REPO, repositoryVO);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRepositoryVO = getArguments().getParcelable(CURRENT_REPO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repo_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        mAdapter = new BranchesAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mPresenter = new RepoInfoPresenter(this, mRepositoryVO);
        mPresenter.onCreate(savedInstanceState);

    }

    private void initView(View view) {
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
        super.onStop();
    }


    @Override
    public void showBranchesList(List<BranchVO> branchVOs) {
mAdapter.setData(branchVOs);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }
}
