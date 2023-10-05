package com.example.mobileproject;


import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class imagesAPODLoader {
        public static void loadImage(String imageUrl, ImageView targetImageView) {
            Picasso.get().load(imageUrl).into(targetImageView);
        }
}


