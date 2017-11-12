package com.thereza.retrofitintro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.thereza.retrofitintro.data.Movie;

import java.util.List;

/**
 * Created by theReza on 11/11/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    public List<Movie> movies;
    private int rowLayout;
    private Context context;



    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        //TextView poster, production_companies,release_date,revenue,tagline;

        public MovieViewHolder(View v, Context context, final List<Movie> movies) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            context = v.getContext();
            final Context finalContext = context;
            final Context finalContext1 = context;
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(finalContext1,"clicked="+movies.get(getPosition()).getRevenue(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(finalContext,DetailsAcitivity.class);
                    i.putExtra("id",movies.get(getPosition()).getId().toString());
                    i.putExtra("movieName",movies.get(getPosition()).getTitle()).toString();
                    i.putExtra("producerName",movies.get(getPosition()).getTagline()).toString();
                    i.putExtra("releaseDate",movies.get(getPosition()).getReleaseDate()).toString();
                    i.putExtra("budget",movies.get(getPosition()).getBudget()).toString();
                    i.putExtra("revenue",movies.get(getPosition()).getRevenue()).toString();
                    i.putExtra("rating",movies.get(getPosition()).getVoteAverage()).toString();
                    i.putExtra("description",movies.get(getPosition()).getOverview()).toString();
                    i.putExtra("posterPath",movies.get(getPosition()).getPosterPath()).toString();
                    finalContext.startActivity(i);

                }
            });


        }

    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view,context,movies);

    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        Toast.makeText(context,"clicked="+movies.get(position).getRevenue(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
