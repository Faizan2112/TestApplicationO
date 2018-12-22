package com.example.root.testapplicationo.coverflow.it.moondroid.coverflow.components.coverflowdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {

    private ArrayList<RecentUpdateResponseModal.RecentUpdateResponseModalResult> mData = new ArrayList<>();
    private Context mContext;
    private ViewHolder holder;
    private LayoutInflater inflater;

    public HomeAdapter(Context context, ArrayList<RecentUpdateResponseModal.RecentUpdateResponseModalResult> data) {
        mContext = context;
        mData = data;
    }

    public void setData() {

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int pos) {
        return mData.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public int getItemViewType(int position) {
        RecentUpdateResponseModal.RecentUpdateResponseModalResult modalResult = mData.get(position);
        if(Integer.parseInt(modalResult.getViewType())==  RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_SCEME) {
            return 1 ;
        }
        else if(Integer.parseInt(modalResult.getViewType())==  RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_NEWS)
        {
            return 2 ;

        }

        else if(Integer.parseInt(modalResult.getViewType())==  RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_RECENT_NOTIFICATION)
        {

            return 3 ;
        }
        return  0 ;
    }
    // String item = (String) getItem(position);
    // if(item.equals("a"))return =0;



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        String item = (String) getItem(position);
        View rowView = convertView;

        if (rowView == null) {

            holder = new ViewHolder();

            if (type == 0) {
                rowView = inflater.inflate(R.layout.list_home_recent_update, null);

                holder.text = (TextView) rowView.findViewById(R.id.home_recent_order_id);

            }else if(type ==1){

                rowView = inflater.inflate(R.layout.list_home_recent_update, null);

                holder.txtTwo = (TextView) rowView.findViewById(R.id.home_recent_order_id);

            }

            else {

                rowView = inflater.inflate(R.layout.list_home_recent_update, null);

                holder.txtThree = (TextView) rowView.findViewById(R.id.home_recent_order_id);

            }

            holder.type = type;

            rowView.setTag(holder);

        } else {

            holder = (ViewHolder) rowView.getTag();

            Log.d("Adapter test", " holder ::" + holder);

        }

        String items = (String) getItem(position);

        if (item != null) {

            if (type == 0) {

                holder.text.setText(items);



            } else if(type ==1 ) {

                holder.txtTwo.setText(items);

            }else{

                holder.txtThree.setText(items);

            }

        }

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_home_recent_update, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.home_recent_order_id);
            viewHolder.image = (ImageView) rowView
                    .findViewById(R.id.image);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

       // holder.image.setImageResource(mData.get(position).getSId());
        holder.text.setText(mData.get(position).getFromName());

        return rowView;
    }


    static class ViewHolder {

        public int type;
        public TextView text;
        public TextView txtTwo;
        public TextView txtThree;
        public ImageView image;
    }
}


/*extends BaseAdapter {

    private ArrayList<HomeActivity.GameEntity> mData = new ArrayList<>();
    private Context mContext;

    public HomeAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<HomeActivity.GameEntity> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int pos) {
        return mData.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_home_recent_update, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.home_recent_order_id);
          *//*  viewHolder.image = (ImageView) rowView
                    .findViewById(R.id.image);
      *//*      rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

       // holder.image.setImageResource(mData.get(position).imageResId);
        holder.text.setText(mData.get(position).titleResId);

        return rowView;
    }


    static class ViewHolder {
        public TextView text;
        public ImageView image;
    }
}
*/


/*extends BaseAdapter {

    private ArrayList<RecentUpdateResponseModal.RecentUpdateResponseModalResult> mData = new ArrayList<>(0);
    private Context mContext;
    private ViewHolder holder;
    private LayoutInflater inflater;

    public HomeAdapter(Context context,ArrayList<RecentUpdateResponseModal.RecentUpdateResponseModalResult> data) {
        mContext = context;
        mData = data;
    }

    public void setData() {

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int pos) {
        return mData.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public int getItemViewType(int position) {
        RecentUpdateResponseModal.RecentUpdateResponseModalResult modalResult = mData.get(position);
           if(Integer.parseInt(modalResult.getViewType())==  RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_SCEME) {
           return 1 ;
           }
               else if(Integer.parseInt(modalResult.getViewType())==  RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_NEWS)
               {
                   return 2 ;

               }

               else if(Integer.parseInt(modalResult.getViewType())==  RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_RECENT_NOTIFICATION)
               {

                   return 3 ;
               }
     return  0 ;
        }
       // String item = (String) getItem(position);
       // if(item.equals("a"))return =0;



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        String item = (String) getItem(position);
        View rowView = convertView;

        if (rowView == null) {
           
            holder = new ViewHolder();
         
            if (type == 0) {
                rowView = inflater.inflate(R.layout.list_home_recent_update, null);
               
                holder.txtOne = (TextView) rowView.findViewById(R.id.home_recent_order_id);
             
            }else if(type ==1){

                rowView = inflater.inflate(R.layout.list_home_recent_update, null);
               
                holder.txtTwo = (TextView) rowView.findViewById(R.id.home_recent_order_id);
               
            }
           
	                else {

                rowView = inflater.inflate(R.layout.list_home_recent_update, null);
               
                holder.txtThree = (TextView) rowView.findViewById(R.id.home_recent_order_id);
               
            }
           
            holder.type = type;

            rowView.setTag(holder);
            
        } else {
            
            holder = (ViewHolder) rowView.getTag();
            
            Log.d("Adapter test", " holder ::" + holder);
           
        }
        
        String items = (String) getItem(position);
       
        if (item != null) {
           
            if (type == 0) {
               
                holder.txtOne.setText(items);
                

                
            } else if(type ==1 ) {
                
                holder.txtTwo.setText(items);
                
            }else{
               
                holder.txtThree.setText(items);

            }
         
        }
*//*
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_coverflow, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.label);
            viewHolder.image = (ImageView) rowView
                    .findViewById(R.id.image);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

        holder.image.setImageResource(mData.get(position).imageResId);
        holder.text.setText(mData.get(position).titleResId);*//*

        return rowView;
    }


    static class ViewHolder {

            public int type;
        public TextView txtOne;
        public TextView txtTwo;
        public TextView txtThree;
        public ImageView image;
    }
}*/





/*extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    ArrayList<RecentUpdateResponseModal.RecentUpdateResponseModalResult> recentUpdateResponseModals;
    Context mContext;
    private ViewHolder holders;
    private int positions;

    public OnHomeRecentUpdateClickListener getOnHomeRecentUpdateClickListener() {
        return onHomeRecentUpdateClickListener;
    }

    public void setOnHomeRecentUpdateClickListener(OnHomeRecentUpdateClickListener onHomeRecentUpdateClickListener) {
        this.onHomeRecentUpdateClickListener = onHomeRecentUpdateClickListener;
    }

    public OnHomeRecentUpdateClickListener onHomeRecentUpdateClickListener;

    public HomeAdapter(ArrayList<RecentUpdateResponseModal.RecentUpdateResponseModalResult> recentUpdateResponseModals, Context mContext) {
        this.recentUpdateResponseModals = recentUpdateResponseModals;
        this.mContext = mContext;
    }


    public class SchemeViewHolder extends HomeAdapter.ViewHolder {
        ImageView iv_scheme;


        public SchemeViewHolder(View itemView) {
            super(itemView);
            iv_scheme = itemView.findViewById(R.id.home_recent_update_iv);
            final RecentUpdateResponseModal.RecentUpdateResponseModalResult pos = recentUpdateResponseModals.get(positions);

        }


    }

    public class NewsViewHolder extends HomeAdapter.ViewHolder {
        ImageView iv_news;

        public NewsViewHolder(View itemView) {
            super(itemView);
            iv_news = itemView.findViewById(R.id.home_recent_update_iv);

        }
    }

    public class RecentOrderViewHolder extends HomeAdapter.ViewHolder {
        ImageView iv_recent_order;
        TextView tv_OrderId ,tvOrderFrom ,tv_OrderDate;


        public RecentOrderViewHolder(View itemView) {
            super(itemView);
            iv_recent_order = itemView.findViewById(R.id.home_recent_update_iv);
            tv_OrderId = itemView.findViewById(R.id.home_recent_order_id);
            tvOrderFrom = itemView.findViewById(R.id.home_recent_order_from);
            tv_OrderDate = itemView.findViewById(R.id.home_recent_order_date);
        }
    }


    public void setAdapterView(ArrayList<RecentUpdateResponseModal> recentUpdateResponseModal) {
        recentUpdateResponseModals.clear();
        //    this.recentUpdateResponseModals = recentUpdateResponseModal;

    }

    @Override
    public int getItemViewType(int position) {


        RecentUpdateResponseModal.RecentUpdateResponseModalResult modalResult = recentUpdateResponseModals.get(position);
        // RecentUpdateResponseModal.RecentUpdateResponseModalResult modalResult = recentUpdateResponseModals.get(position).getResult();
        switch (modalResult.getViewType()) {
            case "1":
                return RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_SCEME;

            case "2":
                return RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_NEWS;


            case "3":
                return RecentUpdateResponseModal.RecentUpdateResponseModalResult.VIEW_TYPE_RECENT_NOTIFICATION;


            default:
                return -1;
        }

    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home_recent_update, parent, false);

        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home_recent_update, parent, false);
                return new HomeAdapter.SchemeViewHolder(view);

            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home_recent_update, parent, false);
                return new HomeAdapter.NewsViewHolder(view);
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home_recents_update, parent, false);
                return new HomeAdapter.RecentOrderViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String path = "http://webworldindia.com/freshup_oms/uploads";
        holders = holder;
        positions = position;
        String url1 = "http://faizandream21.000webhostapp.com/PhotoUploadWithText/uploads/abstract-abstract-expressionism-abstract-painting-1223341.jpg";
        String url2 = "http://faizandream21.000webhostapp.com/PhotoUploadWithText/uploads/abstract-abstract-expressionism-abstract-painting-1234853.jpg";
        String url3 = "http://faizandream21.000webhostapp.com/PhotoUploadWithText/uploads/abstract-art-artistic-1020315.jpg";
        int pos = holder.getAdapterPosition();
        if (position == recentUpdateResponseModals.size() - 2) {
            position = position + 1;

        }
        final RecentUpdateResponseModal.RecentUpdateResponseModalResult object = recentUpdateResponseModals.get(position);

        //  if (object != null)
        if (object != null) {
            switch (object.getViewType()) {
                case "1":
                    try {
                        Glide.with(mContext).load(path + "/schemes/" + object.getImage()).into(((SchemeViewHolder) holder).iv_scheme);

                    } catch (ClassCastException c) {
                        c.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        Glide.with(mContext).load(path + "/news/" + object.getImage()).into(((NewsViewHolder) holder).iv_news);
                    } catch (ClassCastException c) {
                        c.printStackTrace();
                    }

                    break;
                case "3":
                    try {
                        Glide.with(mContext).load(url3).into(((RecentOrderViewHolder) holder).iv_recent_order);
                        ((RecentOrderViewHolder) holder).tv_OrderId.setText(object.getOrderId());
                        ((RecentOrderViewHolder) holder).tvOrderFrom.setText(object.getFromName());
                        ((RecentOrderViewHolder) holder).tv_OrderDate.setText(object.getDate());
                    }catch (ClassCastException c){c.printStackTrace();}

                    break;

            }
        }
    }

    @Override
    public int getItemCount() {
        return recentUpdateResponseModals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
*/