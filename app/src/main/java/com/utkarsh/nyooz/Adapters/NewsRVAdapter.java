package com.utkarsh.nyooz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.utkarsh.nyooz.Articels;
import com.utkarsh.nyooz.NewsDetailActivity;
import com.utkarsh.nyooz.R;

import java.util.ArrayList;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {

    private ArrayList<Articels> articelsArrayList;
    private Context context;

    // Constructor
    public NewsRVAdapter(ArrayList<Articels> articelsArrayList, Context context) {
        this.articelsArrayList = articelsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
            return new NewsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.ViewHolder holder, int position) {
        Articels articels = articelsArrayList.get(position);
        holder.subTitleTV.setText(articels.getDescription());
        holder.titleTV.setText(articels.getTitle());
        Picasso.get().load(articels.getUrlToImage()).into(holder.newsIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context , NewsDetailActivity.class);
                i.putExtra("title",articels.getTitle());
                i.putExtra("content",articels.getContent());
                i.putExtra("desc",articels.getDescription());
                i.putExtra("image",articels.getUrlToImage());
                i.putExtra("url",articels.getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articelsArrayList.size();
    }

    // Inner Class
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV , subTitleTV;
        private ImageView newsIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsIV = itemView.findViewById(R.id.idIVNews);
            titleTV = itemView.findViewById(R.id.idTVNewsHeading);
            subTitleTV = itemView.findViewById(R.id.idTVSubTitle);
        }
    }
}
