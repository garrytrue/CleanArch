package com.garrytrue.cleanarhitecturegitapi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garrytrue.cleanarhitecturegitapi.model.data.vo.BranchVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiv on 29.06.2016.
 */
public class BranchesAdapter extends RecyclerView.Adapter<BranchesAdapter.BranchViewHolder> implements RecyclerAdapter<BranchVO> {
    List<BranchVO> branchVOs = new ArrayList<>();

    @Override
    public BranchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BranchViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    @Override
    public void onBindViewHolder(BranchViewHolder holder, int position) {
        holder.setBranchName(branchVOs.get(position).getBranchName());
    }

    @Override
    public int getItemCount() {
        return branchVOs.isEmpty() ? 0 : branchVOs.size();
    }

    @Override
    public void setData(List<BranchVO> data) {
        branchVOs.clear();
        branchVOs.addAll(data);
        notifyDataSetChanged();
    }

    class BranchViewHolder extends RecyclerView.ViewHolder {
        private TextView branchName;

        public BranchViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            branchName = (TextView) itemView.findViewById(android.R.id.text1);
        }

        void setBranchName(String name) {
            branchName.setText(name);
        }

    }
}
