package com.example.root.testapplicationo.horizontal_catalogue_view.sample_catalog;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.root.testapplicationo.R;

import java.util.List;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {

    private RecyclerView parentRecycler;
    private List<CatalogModel> data;

    public CatalogAdapter(List<CatalogModel> data) {
        this.data = data;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    parentRecycler = recyclerView ;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup holder, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int iconTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.grayIconTint);
        CatalogModel productData = data.get(position);
        Glide.with(holder.itemView.getContext())
                .load(productData.getProductIcon())
                //.listener(new TintOnLoad(holder.imageView, iconTint))
                .into(holder.imageView);
        holder.textView.setText(productData.getProductName());

    }

    @Override
    public int getItemCount() {
        return  data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.city_image);
            textView = (TextView) itemView.findViewById(R.id.city_name);

            itemView.findViewById(R.id.container).setOnClickListener(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void showText() {
            int parentHeight = ((View) imageView.getParent()).getHeight();
            float scale = (parentHeight - textView.getHeight()) / (float) imageView.getHeight();
            imageView.setPivotX(imageView.getWidth() * 0.5f);
            imageView.setPivotY(0);
            imageView.animate().scaleX(scale)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            textView.setVisibility(View.VISIBLE);
                            imageView.setColorFilter(Color.BLACK);
                        }
                    })
                    .scaleY(scale).setDuration(200)
                    .start();
        }

        public void hideText() {
            imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), R.color.grayIconTint));
            textView.setVisibility(View.INVISIBLE);
            imageView.animate().scaleX(1f).scaleY(1f)
                    .setDuration(200)
                    .start();
        }


        @Override
        public void onClick(View view) {

        }
    }

    /*private class TintOnLoad implements RequestListener<? super String, GlideDrawable> {
        public TintOnLoad(ImageView imageView, int iconTint) {
        }

        @Override
        public boolean onException(Exception e, Object model, Target<GlideDrawable> target, boolean isFirstResource) {
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, Object model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            return false;
        }
    }
*/

   /* private static class TintOnLoad implements RequestListener<Integer, GlideDrawable> {

        private ImageView imageView;
        private int tintColor;

        public TintOnLoad(ImageView view, int tintColor) {
            this.imageView = view;
            this.tintColor = tintColor;
        }

        @Override
        public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            imageView.setColorFilter(tintColor);
            return false;
        }*/
    }




