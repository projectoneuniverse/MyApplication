package com.alphalearning.myapplication1;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alphalearning.myapplication1.model.ResultsItem;
import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    public static final String MOVIE = "movies";
    public static final String DATAMOVIE = "movies1";
    private Context context;
    private List<ResultsItem> MovieData = new ArrayList<>();

    public MoviesAdapter(Context context, List<ResultsItem> MovieData) {
        this.context = context;
        this.MovieData = MovieData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_movies, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.tvJudul.setText(MovieData.get(i).getTitle());
        myViewHolder.tvJudul1.setText(MovieData.get(i).getOverview());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" +MovieData.get(i).getPosterPath()).into(myViewHolder.ivPoster);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(context, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(MOVIE, Parcels.wrap(MovieData.get(i)));
                data.putExtra(DATAMOVIE, bundle);
                context.startActivity(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MovieData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvJudul1;
        ImageView ivPoster;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvJudul1 = itemView.findViewById(R.id.tvStoryline);

            ivPoster = itemView.findViewById(R.id.ivPoster);
        }
    }
}
