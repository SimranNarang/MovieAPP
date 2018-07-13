package com.stackroute.movieapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);

	}

	@Override
	public Iterable<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public boolean deleteMovie(int id) {
		try {
			movieRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Movie updateMovie(Movie movie,int id) {
		movie.setId(id);
		return movieRepository.save(movie);
	}

	@Override
	public Optional<Movie> getMovieById(int id) {
		return movieRepository.findById(id);
	}
	@Override
    public Iterable<Movie> getByName(String name) {
        return movieRepository.getByName(name);
    }
	
	
}
