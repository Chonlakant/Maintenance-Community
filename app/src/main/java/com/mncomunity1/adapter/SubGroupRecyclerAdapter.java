package com.mncomunity1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mncomunity1.R;
import com.mncomunity1.model.SubGroup;

import java.util.ArrayList;

public class SubGroupRecyclerAdapter extends RecyclerView.Adapter<SubGroupRecyclerAdapter.ContactViewHolder> {

    Context context;
    ArrayList<SubGroup> list = new ArrayList<>();
    public static OnItemClickListener mItemClickListener;

    public SubGroupRecyclerAdapter(Context context, ArrayList<SubGroup> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        SubGroup item = list.get(i);
        contactViewHolder.title_tv.setText(item.getTotal().get(i).getNameth());





        if(item.getTotal().get(i).getCover() != null){
            String url = "http://mn-community.com/web/"+item.getTotal().get(i).getCover();
            Log.e("url",url);
            Glide.with(context)
                    .load(url)
                    .centerCrop()
                    .crossFade()
                    .into(contactViewHolder.image_logo);

        }


    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_sub_group, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image_logo;
        TextView title_tv;
        LinearLayout ls_onclick;

        public ContactViewHolder(View v) {
            super(v);
           image_logo = (ImageView) v.findViewById(R.id.image_logo);
            title_tv = (TextView) v.findViewById(R.id.title_tv);
            ls_onclick = (LinearLayout) v.findViewById(R.id.ls_onclick);
            v.setOnClickListener(this);
            ls_onclick.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ls_onclick:
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(v, getPosition());
                    }

            }
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);

    }

    public void SetOnItemVideiosClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}