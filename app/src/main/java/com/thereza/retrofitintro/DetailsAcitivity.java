package com.thereza.retrofitintro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thereza.retrofitintro.data.Movie;

import java.util.List;

public class DetailsAcitivity extends AppCompatActivity {

    public List<Movie> movies;
    public MoviesAdapter mAdapter;
    ImageView posterImg;
    TextView movieTitle;
    TextView releaseDate;
    TextView movieDescription;
    TextView ratings;
    TextView budget,revenue,producertagline;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        posterImg= (ImageView) findViewById(R.id.poster);
        movieTitle= (TextView) findViewById(R.id.movieTitle);
        movieDescription=(TextView)findViewById(R.id.descriptionText);
        releaseDate = (TextView)findViewById(R.id.release_Date);
        ratings=(TextView)findViewById(R.id.rating);
        producertagline= (TextView) findViewById(R.id.producerName);
        revenue=(TextView) findViewById(R.id.revenue);
        budget=(TextView)findViewById(R.id.budget);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("movieName");
        String producer = intent.getStringExtra("producerName");
        String release_date = intent.getStringExtra("releaseDate");
        String budget_total = intent.getStringExtra("budget");
        String revenue_total = intent.getStringExtra("revenue");
        String avarage_rating = intent.getStringExtra("rating");
        String description = intent.getStringExtra("description");

       Toast.makeText(getApplicationContext(),"description: "+ revenue_total, Toast.LENGTH_LONG).show();
        movieTitle.setText(title);
        movieDescription.setText(description);
        releaseDate.setText(release_date);
        ratings.setText(avarage_rating);
        producertagline.setText(producer);
        revenue.setText(revenue_total);
        budget.setText(budget_total);





    }
}
