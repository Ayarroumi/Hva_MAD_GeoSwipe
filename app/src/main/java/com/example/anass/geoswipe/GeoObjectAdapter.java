package com.example.anass.geoswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder> {

    private Context context;
    public List<GeoObject> listGeoObject;

    public GeoObjectAdapter(Context context, List<GeoObject> listGeoObject) {
        this.context = context;
        this.listGeoObject = listGeoObject;
    }

    @NonNull
    @Override
    public GeoObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new GeoObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GeoObjectViewHolder holder, int position) {
        final GeoObject geoObject = listGeoObject.get(position);
        Glide.with(context)
                .load(geoObject.getImageName())
                .into(holder.geoImage);

        holder.view.setBackgroundColor(geoObject.getBackgroundColor());
    }

    @Override
    public int getItemCount() {
        return listGeoObject.size();
    }

}
