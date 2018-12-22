package com.example.root.testapplicationo.infiniterecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.horizontal_recycler_view.sample_directory.shop.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context mCtx;
    private List<ResponseModel.Item> items ;

    public ItemAdapter(Context mCtx, List<ResponseModel.Item> items) {
        this.mCtx = mCtx;
        this.items = items;
    }


    public void setAdapterItem(List<ResponseModel.Item> item )
    {
        items.addAll(item);
        notifyDataSetChanged();

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
      ResponseModel.Item pos = items.get(position) ;

          holder.textView.setText(String.valueOf(pos.getLastActivityDate()));
          //holder.textView.setText(String.valueOf(position));
        //Glide.with(mCtx)
        //        .load(item.owner.profile_image)
        //        .into(holder.imageView);

       // Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);

                textView = itemView.findViewById(R.id.textViewName);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }


/*

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = getItem(position);

        if (item != null) {
            holder.textView.setText(item.owner.display_name);
            Glide.with(mCtx)
                    .load(item.owner.profile_image)
                    .into(holder.imageView);
        }else{
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

   */
/* private static DiffUtil.ItemCallback<Item> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Item>() {
                @Override
                public boolean areItemsTheSame(Item oldItem, Item newItem) {
                    return oldItem.question_id == newItem.question_id;
                }

                @Override
                public boolean areContentsTheSame(Item oldItem, Item newItem) {
                    return oldItem.equals(newItem);
                }
            };*//*


    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}*/
