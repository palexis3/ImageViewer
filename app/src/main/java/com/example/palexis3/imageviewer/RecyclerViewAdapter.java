package com.example.palexis3.imageviewer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.palexis3.imageviewer.model.Business;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Business> businessList;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        businessList = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.businessRating.setText(businessList.get(i).getPrice());
        viewHolder.businessName.setText(businessList.get(i).getName());
        Glide.with(context).load(businessList.get(i).getImage_url()).into(viewHolder.imageView);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_row_item, viewGroup, false));
    }

    @Override
    public int getItemCount() {
        return businessList != null ? businessList.size() : 0;
    }

    public void setData(List<Business> businessList) {
        this.businessList.addAll(businessList);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView businessName;
        TextView businessRating;
        ImageView imageView;

        public ViewHolder(View viewItem) {
            super(viewItem);
            businessName = viewItem.findViewById(R.id.tvName);
            businessRating = viewItem.findViewById(R.id.tvRating);
            imageView = viewItem.findViewById(R.id.ivBiz);
        }
    }
}
