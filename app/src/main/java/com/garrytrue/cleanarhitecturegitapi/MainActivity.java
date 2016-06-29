package com.garrytrue.cleanarhitecturegitapi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.garrytrue.cleanarhitecturegitapi.adapters.RepoListAdapter;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;
import com.garrytrue.cleanarhitecturegitapi.presenter.RepoListPresenter;
import com.garrytrue.cleanarhitecturegitapi.view.IRepoView;
import com.garrytrue.cleanarhitecturegitapi.view.RepoListFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        switchFragments();

    }

    private void switchFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(RepoListFragment.TAG);
        if(fragment == null){
            fragmentManager.beginTransaction().replace(R.id.fragment_container, RepoListFragment.newInstance(), RepoListFragment.TAG).commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initViews() {
        container = (FrameLayout) findViewById(R.id.fragment_container);
    }

}
