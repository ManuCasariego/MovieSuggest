package com.suggest.manu.moviesuggest.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by manu on 25/05/15.
 */
public class ManuAdapter extends RecyclerView.Adapter<ManuAdapter.ManuHolder> {


    @Override
    public ManuHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(ManuHolder manuHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ManuHolder extends RecyclerView.ViewHolder {
        public ManuHolder(View itemView) {
            super(itemView);
        }
    }
}
