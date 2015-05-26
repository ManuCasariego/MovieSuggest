package com.suggest.manu.moviesuggest.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.suggest.manu.moviesuggest.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by manu on 25/05/15.
 */
public class ManuAdapter extends RecyclerView.Adapter<ManuAdapter.ManuHolder> {

    private List<Movie> data = Collections.emptyList();

    public ManuAdapter(List<Movie> data) {
        this.data = data;
    }

    @Override
    public ManuHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_item, viewGroup, false);
        ManuHolder manuHolder = new ManuHolder(view);
        return manuHolder;
    }

    @Override
    public void onBindViewHolder(ManuHolder manuHolder, int i) {
        Picasso.with(manuHolder.imageView.getContext()).load(data.get(i).getImage()).into(manuHolder.imageView);
        Log.i("ManuAdapter", "Intento cargar la foto " + i + " de link " + data.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(Movie movie) {
        data.add(movie);
    }

    public class ManuHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ManuHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.rectangleImageViewRecycler);

        }
    }
}
