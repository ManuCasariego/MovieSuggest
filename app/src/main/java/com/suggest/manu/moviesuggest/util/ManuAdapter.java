package com.suggest.manu.moviesuggest.util;

import android.support.v7.widget.RecyclerView;
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

    List<Movie> data = Collections.emptyList();

    public ManuAdapter(List<Movie> data) {
        this.data = data;
    }

    @Override
    public ManuHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_item, viewGroup);
        ManuHolder manuHolder = new ManuHolder(view);
        return manuHolder;
    }

    @Override
    public void onBindViewHolder(ManuHolder manuHolder, int i) {
        Picasso.with(manuHolder.imageView.getContext()).load(data.get(i).getImage()).into(manuHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ManuHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ManuHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.rectangleImageViewRecycler);

        }
    }
}
