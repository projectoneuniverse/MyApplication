package com.alphalearning.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alphalearning.myapplication1.model.ResultsItemTV;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.MyViewHolder> {
    private Context context;
    private List<ResultsItemTV> adapterMovies = new ArrayList<>();

    public TVAdapter(Context context, List<ResultsItemTV> adapterMovies) {
        this.context = context;
        this.adapterMovies = adapterMovies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_movies, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tvJudul.setText(adapterMovies.get(i).getName());
        myViewHolder.tvJudul1.setText(adapterMovies.get(i).getOverview());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" +adapterMovies.get(i).getPosterPath()).into(myViewHolder.ivPoster);

    }

    @Override
    public int getItemCount() {
        return adapterMovies.size();
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
