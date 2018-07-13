package com.stackroute.movieapp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stackroute.movieapp.domain.Movie;
@Service
public interface MovieService {

	public Movie saveMovie(Movie movie);
	public Iterable<Movie> getAllMovies();
	public boolean deleteMovie(int id);
	public Movie updateMovie(Movie movie,int id);
	public Optional<Movie> getMovieById(int id);
	public Iterable<Movie> getByName(String name);
}
