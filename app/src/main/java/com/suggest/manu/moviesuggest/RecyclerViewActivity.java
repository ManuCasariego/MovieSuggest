package com.suggest.manu.moviesuggest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.suggest.manu.moviesuggest.util.ManuAdapter;
import com.suggest.manu.moviesuggest.util.Movie;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ManuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initializeComponents();
    }

    private void initializeComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ManuAdapter(fakeData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //adapter.notifyDataSetChanged();
    }

    private List<Movie> fakeData() {
        List<Movie> data = new ArrayList<>();
        Movie movie = new Movie();
        movie.setImage("http://pics.filmaffinity.com/Los_siete_samur_is-914194246-main.jpg");
        for (int i = 0; i < 10; i++) {
            data.add(movie);
        }
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
