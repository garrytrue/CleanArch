package com.garrytrue.cleanarhitecturegitapi.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garrytrue.cleanarhitecturegitapi.callbacks.IRepoClickListener;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;

import java.util.List;

/**
 * Created by garrytrue on 25.06.16.
 */
public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> implements RecyclerAdapter<RepositoryVO> {
    private List<RepositoryVO> repos;
    private IRepoClickListener listener;

    @Override
    public RepoListAdapter.RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater
                .from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_2, parent, false);
        return new RepoViewHolder(item);
    }

    @Override
    public void onBindViewHolder(RepoListAdapter.RepoViewHolder holder, int position) {
        holder.setTitle(repos.get(position).getOwnerName());
        holder.setSubtitle(repos.get(position).getRepoName());
    }

    @Override
    public int getItemCount() {
        return (repos != null && !repos.isEmpty()) ? repos.size() : 0;
    }

    @Override
    public void setData(List<RepositoryVO> data) {
        repos = data;
        notifyDataSetChanged();
    }

    public void setRepoClickListener(IRepoClickListener listener) {
        this.listener = listener;
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {
        private TextView title, subTitle;

        public RepoViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
            itemView.setOnClickListener(view -> {
                if (listener != null)
                    listener.onRepoClicked(getAdapterPosition());
            });
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
