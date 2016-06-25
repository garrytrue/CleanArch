package com.garrytrue.cleanarhitecturegitapi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garrytrue.cleanarhitecturegitapi.model.data.Repo;

import java.util.List;

/**
 * Created by garrytrue on 25.06.16.
 */
public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> implements RecyclerAdapter<Repo> {
    private List<Repo> repos;

    @Override
    public RepoListAdapter.RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepoViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(android.R.layout.simple_list_item_2, parent, false));
    }

    @Override
    public void onBindViewHolder(RepoListAdapter.RepoViewHolder holder, int position) {
        holder.setTitle(repos.get(position).getOwner().getLogin());
        holder.setSubtitle(repos.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return (repos != null && !repos.isEmpty()) ? repos.size() : 0;
    }

    @Override
    public void setData(List<Repo> data) {
        repos = data;
        notifyDataSetChanged();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {
        private TextView title, subTitle;

        public RepoViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            title = (TextView) itemView.findViewById(android.R.id.text1);
            subTitle = (TextView) itemView.findViewById(android.R.id.text2);
        }

        void setTitle(String t) {
            title.setText(t);
        }

        void setSubtitle(String st) {
            subTitle.setText(st);
        }
    }

}
