package com.mncomunity1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mncomunity1.R;
import com.mncomunity1.model.HistoryOrder;

import java.util.ArrayList;

public class GetHistoryOrderRecyclerAdapter extends RecyclerView.Adapter<GetHistoryOrderRecyclerAdapter.ContactViewHolder> {

    Context context;
    ArrayList<HistoryOrder> list = new ArrayList<>();
    public static OnItemClickListener mItemClickListener;

    public GetHistoryOrderRecyclerAdapter(Context context, ArrayList<HistoryOrder> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        HistoryOrder item = list.get(i);
        contactViewHolder.title_tv.setText(item.getTotal().get(i).getNameth());
        contactViewHolder.txt_total.setText(item.getTotal().get(i).getTs());
        if(item.getTotal().get(i).getStatus().equals("1")){
            contactViewHolder.txt_status.setText("ยืนยันแล้ว");
        }else{
            contactViewHolder.txt_status.setText("รอการยืนยัน");
        }
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_history2, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image_logo;
        TextView title_tv,txt_status;
        LinearLayout ls_onclick;
        TextView txt_total;

        public ContactViewHolder(View v) {
            super(v);
            image_logo = (ImageView) v.findViewById(R.id.image_logo);
            title_tv = (TextView) v.findViewById(R.id.title);
            ls_onclick = (LinearLayout) v.findViewById(R.id.ls_onclick);
            txt_total = (TextView) v.findViewById(R.id.txt_total);
            txt_status = (TextView) v.findViewById(R.id.txt_status);
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