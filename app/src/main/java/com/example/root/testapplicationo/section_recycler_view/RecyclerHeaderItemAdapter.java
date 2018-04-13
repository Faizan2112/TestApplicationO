/*
package com.example.root.testapplicationo.section_recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.root.testapplicationo.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

*/
/**
 * Created by root on 3/12/18.
 *//*


public class RecyclerHeaderItemAdapter extends RecyclerItemAdapter implements StickyRecyclerHeadersAdapter {

    private List mList ;
    private Context context;

    RecyclerHeaderItemAdapter(Context context, List list ){
        this.mList = list;
        this.context = context;
    }


    @Override
    public long getHeaderId(int position) {
        if (position == 0) {
            return -1;
        } else {
            return getItemId(position);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);
        return new ItemHeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHeaderViewHolder) {
            if (getItem(position).getName() != null) {
                String header = String.valueOf(getItem(position).getName().charAt(0));
                ((ItemHeaderViewHolder) holder).header.setText(header);
            }
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemModel itemModel = (ItemModel) mList.get(position);
        ((ItemViewHolder)holder).name.setText(itemModel.getName());
        String imageUrl = itemModel.getImagePath();
        if (imageUrl != null){
            Glide.with(context)
                    .load(imageUrl)
                    .into(((ItemViewHolder)holder).imageView);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public ItemModel getItem(int position) {
        return (ItemModel) mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        //@BindView(R.id.name)
        TextView name;

        //@BindView(R.id.imageView)
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
          //  ButterKnife.bind(this, itemView);
        name = (TextView)itemView.findViewById(R.id.name);
        imageView = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }

    public static class ItemHeaderViewHolder extends RecyclerView.ViewHolder {

       // @BindView(R.id.header)

        TextView header;

        public ItemHeaderViewHolder(View itemView) {
            super(itemView);

        header = (TextView)itemView.findViewById(R.id.header);
          //  ButterKnife.bind(this, itemView);
        }
    }

}
*/
