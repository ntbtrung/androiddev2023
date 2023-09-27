package com.example.mobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<latest_news> postList;
    Context context;

    public PostAdapter (Context context , List<latest_news>api ) {
        this.context = context;
        postList = api;
    }
    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_firstrow_newpage ,parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {

        latest_news post = postList.get(position);
        holder.title.setText("title: "+ post.getTitle());
        holder.name.setText("author: "+post.getName());
        //holder.body.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends  RecyclerView.ViewHolder{
        TextView title , body , name;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.newsTitle);
            name = itemView.findViewById(R.id.authorNews);
        }
    }
}
