package com.example.root.testapplicationo.custom_layout_manager;

import android.support.v7.widget.RecyclerView;


//A custom RecyclerView.LayoutManager extends from
public class CustomRecyView extends RecyclerView.LayoutManager {

   // This method will supply the default layout parameters for the child views in your RecyclerView
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;


    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);


    }
  //The first call your LayoutManager will receive will be to its on onLayoutChildren
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);


    }

    @Override
    public boolean canScrollVertically() {
        return super.canScrollVertically();
    }

    @Override
    public boolean canScrollHorizontally() {
        return super.canScrollHorizontally();
    }


}
