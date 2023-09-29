package com.example.mobileproject;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class newsAdapter extends RecyclerView.Adapter<newsAdapter.ViewHolder> {

    Context context;
    ArrayList<newsModelClass> newsModelClassArrayList;

    public newsAdapter(Context context, ArrayList<newsModelClass> newsModelClassArrayList) {
        this.context = context;
        this.newsModelClassArrayList = newsModelClassArrayList;
    }
    @NonNull
    @Override
    public newsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_news_layout_item,null,false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull newsAdapter.ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, newsWebView.class);
                intent.putExtra("url", newsModelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.mtime.setText("Published At:-" + newsModelClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(newsModelClassArrayList.get(position).getAuthor());
        holder.mheading.setText(newsModelClassArrayList.get(position).getTitle());
        holder.mcontent.setText(newsModelClassArrayList.get(position).getDescription());
        Glide.with(context).load(newsModelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return newsModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
