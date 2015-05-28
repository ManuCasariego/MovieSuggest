package com.suggest.manu.moviesuggest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.suggest.manu.moviesuggest.util.ManuAdapter;
import com.suggest.manu.moviesuggest.util.Movie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ManuAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initializeComponents();
    }

    private void initializeComponents() {
        progressDialog = new ProgressDialog(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ManuAdapter(new ArrayList<Movie>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




       /* Movie movie = new Movie();
        movie.setImage("http://pics.filmaffinity.com/Los_siete_samur_is-914194246-main.jpg");
        for (int i = 0; i < 10; i++) {
            adapter.add(movie);
        }*/

        new CargarLibros().execute("");


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


    private class CargarLibros extends AsyncTask<String, Integer, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Cargando...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(String... params) {

            try {
                Document document = Jsoup.connect("https://www.goodreads.com/list/show/264.Books_That_Everyone_Should_Read_At_Least_Once").get();
                Elements elements = document.select("a.bookTitle[itemprop=url]");
                Elements elements1 = document.select("img.bookSmallImg");
                for (Element element : elements1) {
                    Movie book = new Movie();
                    //book.setImage(element.attr("src"));
                    book.setImage("http://ia.media-imdb.com/images/M/MV5BMTkxMjgwMDM4Ml5BMl5BanBnXkFtZTgwMTk3NTIwNDE@._V1_SY317_CR0,0,214,317_AL_.jpg");
                    adapter.add(book);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            adapter.notifyDataSetChanged();
        }
    }
}
