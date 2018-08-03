package com.ryandro.sqlitesample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerviewAdapter{}/* extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    private ArrayList<ListItemDo> dataArrayList;
    private Context context;


    public RecyclerviewAdapter(Context context, ArrayList<ListItemDo> dataArrayList) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_cell, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItemDo listItemDo = dataArrayList.get(position);
        holder.tv_movieName.setText(listItemDo.getMovieName());
        holder.tv_director.setText(listItemDo.getDirectorName());
        holder.tv_writter.setText(listItemDo.getWriterName());
        holder.tv_releaseDate.setText(listItemDo.getReleaseDate());
        holder.iv_movie.setImageDrawable(context.getResources().getDrawable(listItemDo.getMovieImage()));
    }

    @Override
    public int getItemCount() {
        if (dataArrayList != null && dataArrayList.size() > 0)
            return dataArrayList.size();
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_movieName, tv_director, tv_writter, tv_releaseDate;
        private ImageView iv_movie;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_movieName = itemView.findViewById(R.id.tv_movieName);
            tv_director = itemView.findViewById(R.id.tv_director);
            tv_writter = itemView.findViewById(R.id.tv_writter);
            tv_releaseDate = itemView.findViewById(R.id.tv_releaseDate);
            iv_movie = itemView.findViewById(R.id.iv_movie);
        }

        @Override
        public void onClick(View v) {
           *//* Toast.makeText(context, "Clicked Position is: " + (getPosition() + 1), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("KEY", dataArrayList.get(getPosition()));
            context.startActivity(intent);*//*

        }
    }*/
//}


