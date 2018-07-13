package com.stackroute.movieapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.movieapp.domain.Movie;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{
	@Query(value = "Select m From Movie m  Where m.title =?1")
    public Iterable<Movie> getByName(String name);

}