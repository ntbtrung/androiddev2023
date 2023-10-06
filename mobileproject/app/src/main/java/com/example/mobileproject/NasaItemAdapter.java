package com.example.mobileproject;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NasaItemAdapter extends RecyclerView.Adapter<NasaItemAdapter.ViewHolder> {
    private final List<NasaItem> nasaItemList;

    private NasaItem nasaItem;

    public NasaItemAdapter(List<NasaItem> nasaItemList, NasaItem nasaItem) {
        this.nasaItemList = nasaItemList;
        this.nasaItem = nasaItem;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView imageTitle, imageID, imageDescription, imageDate, imageCenter, imageKeywords;
        ImageView imageViewFull;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTitle = itemView.findViewById(R.id.imageTitle);
            imageID = itemView.findViewById(R.id.imageID);
            imageDescription = itemView.findViewById(R.id.imageDescription);
            imageDate = itemView.findViewById(R.id.imageDate);
            imageKeywords = itemView.findViewById(R.id.imageKeywords);
            imageViewFull = itemView.findViewById(R.id.imageViewFull);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_images, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        imagesItemsData Data = nasaItemList.get(position).getData().get(0);

        // Set the title, description, and image using Picasso
        holder.imageTitle.setText(Data.getTitle());
        holder.imageID.setText(Data.getNasaId());
        holder.imageDescription.setText(Data.getDescription());
        holder.imageDate.setText(Data.getDateCreated());
        holder.imageCenter.setText(Data.getCenter());

        String[] keywordsArray = Data.getKeywords(); // Assuming keywordsArray is an array of keywords
        String keywordsText = TextUtils.join(", ", keywordsArray); // Convert array to a single string

        holder.imageKeywords.setText(keywordsText); // Set the single string to the TextView

        // Load the image using Picasso from the URL associated with nasaData
        Picasso.get().load((Uri) nasaItem.getLinks()).into(holder.imageViewFull);
    }

    @Override
    public int getItemCount() {
        return nasaItemList.size();
    }


}
