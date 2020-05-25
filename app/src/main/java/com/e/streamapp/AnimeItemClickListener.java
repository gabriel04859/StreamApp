package com.e.streamapp;

import android.widget.ImageView;

import com.e.streamapp.Model.Anime;

public interface AnimeItemClickListener {
    void onAnimeClick(Anime anime, ImageView animeImageView);
}
