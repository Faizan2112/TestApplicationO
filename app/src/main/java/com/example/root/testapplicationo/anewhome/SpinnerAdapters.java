package com.example.root.testapplicationo.anewhome;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.ArrayList;

public class SpinnerAdapters extends RecyclerView.Adapter<SpinnerAdapters.ViewHolder> {
    ArrayList<ProductResponseModel> resultCategoryDatas;

    public SpinnerAdapters(ArrayList<ProductResponseModel> resultCategoryDatas) {
        this.resultCategoryDatas = resultCategoryDatas;
    }

    public OnCategorySpinnerClickListener getOnCategorySpinnerClickListener() {
        return onCategorySpinnerClickListener;
    }

    public void setOnCategorySpinnerClickListener(OnCategorySpinnerClickListener onCategorySpinnerClickListener) {
        this.onCategorySpinnerClickListener = onCategorySpinnerClickListener;
    }

    OnCategorySpinnerClickListener onCategorySpinnerClickListener;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_categary_list, parent, false));
    }

    public void setAdapterItemList(ArrayList<ProductResponseModel> resultCategoryData) {
        resultCategoryDatas.clear();
        resultCategoryDatas.addAll(resultCategoryData);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ProductResponseModel resultCategoryData = (ProductResponseModel) resultCategoryDatas.get(position);
        ResultCategoryData resultCategoryData1 = (ResultCategoryData) resultCategoryData.getResultData();
        holder.mCatName.setText(resultCategoryData1.getCatName());
        holder.mCatId.setText(resultCategoryData1.getCatId());

        View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onCategorySpinnerClickListener.onClick(view,holder,position);

            }
        };

        holder.mCatId.setOnClickListener(mOnClickListener);
        holder.mCatName.setOnClickListener(mOnClickListener);


    }

    @Override
    public int getItemCount() {
        return resultCategoryDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mCatId, mCatName;

        public ViewHolder(View itemView) {
            super(itemView);
            mCatId = itemView.findViewById(R.id.cat_Id);
            mCatName = itemView.findViewById(R.id.cat_name);

        }
    }
}
