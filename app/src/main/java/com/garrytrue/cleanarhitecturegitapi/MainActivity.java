package com.garrytrue.cleanarhitecturegitapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.garrytrue.cleanarhitecturegitapi.adapters.RepoListAdapter;
import com.garrytrue.cleanarhitecturegitapi.model.data.RepositoryDTO;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoListPresenter;
import com.garrytrue.cleanarhitecturegitapi.view.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    private EditText mUserName;
    private ImageButton mSearch;
    private RecyclerView mRecyclerView;
    private RepoListPresenter mPresenter;
    private RepoListAdapter mRepoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mPresenter = new RepoListPresenter(this);
    }

    private void initViews() {
        mUserName = (EditText) findViewById(R.id.et_user_name);
        mSearch = (ImageButton) findViewById(R.id.search);
        mSearch.setOnClickListener((view) ->
                mPresenter.onSearchClick());
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRepoListAdapter = new RepoListAdapter();
        mRecyclerView.setAdapter(mRepoListAdapter);
    }


    @Override
    public void showList(List<RepositoryDTO> repositoryDTOs) {
        mRepoListAdapter.setData(repositoryDTOs);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showEmptyList() {
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public String getUserName() {
        return mUserName.getText().toString();
    }
}
