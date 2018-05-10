package com.example.root.testapplicationo.mvvmtestnew.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.mvvmtestnew.models.repository.api.responsemodel.JoinedResponseData;
import com.example.root.testapplicationo.mvvmtestnew.models.repository.api.responsemodel.SearchResponseTemplateModel;

import java.util.ArrayList;

public class JoinedAdapter extends RecyclerView.Adapter<JoinedAdapter.ViewHolder> {

    ArrayList<SearchResponseTemplateModel> joinedResponseData ;

    public OnJoinedItemClickListener getmOnJoinedItemClickListener() {
        return mOnJoinedItemClickListener;
    }

    public void setmOnJoinedItemClickListener(OnJoinedItemClickListener mOnJoinedItemClickListener) {
        this.mOnJoinedItemClickListener = mOnJoinedItemClickListener;
    }

    OnJoinedItemClickListener mOnJoinedItemClickListener ;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view =
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.joined_recyler_view,null,false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SearchResponseTemplateModel searchResponseTemplateModel = (SearchResponseTemplateModel)joinedResponseData.get(position);
       // holder.tvBranch.setText();


    }

    @Override
    public int getItemCount() {
        return joinedResponseData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBranch ;

        public ViewHolder(View itemView) {
            super(itemView);
            tvBranch = itemView.findViewById(R.id.join_recycle_company);

        }
    }

    public interface  OnJoinedItemClickListener
    {
      void onClick(RecyclerView rv , View v , int postion );

    }
}
