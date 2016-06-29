package com.garrytrue.cleanarhitecturegitapi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.garrytrue.cleanarhitecturegitapi.R;
import com.garrytrue.cleanarhitecturegitapi.adapters.RepoListAdapter;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoListPresenter;

import java.util.List;

public class RepoListFragment extends Fragment implements IRepoView {
    public static final String TAG = RepoListFragment.class.getSimpleName();
    private EditText mUserName;
    private ImageButton mSearch;
    private RecyclerView mRecyclerView;
    private RepoListPresenter mPresenter;
    private RepoListAdapter mRepoListAdapter;
    private View mProgressBar;


    public static RepoListFragment newInstance() {
        RepoListFragment fragment = new RepoListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new RepoListPresenter(this);
        mPresenter.onCreate(savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mUserName = (EditText) view.findViewById(R.id.et_user_name);
        mSearch = (ImageButton) view.findViewById(R.id.search);
        mSearch.setOnClickListener((search) ->
                mPresenter.onSearchClick());
        mProgressBar = view.findViewById(R.id.progressBar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRepoListAdapter = new RepoListAdapter();
        mRepoListAdapter.setRepoClickListener(mPresenter);
        mRecyclerView.setAdapter(mRepoListAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSavedInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showList(List<RepositoryVO> repositoryVOs) {
        mRepoListAdapter.setData(repositoryVOs);
    }

    @Override
    public void showEmptyList() {

    }

    @Override
    public String getUserName() {
        return mUserName.getText().toString();
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
