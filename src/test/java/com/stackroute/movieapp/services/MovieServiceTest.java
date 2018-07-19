package com.stackroute.movieapp.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp.repositories.MovieRepository;

@RunWith(SpringRunner.class)
public class MovieServiceTest {

	  @Mock
	    private transient MovieRepository movieRepo;
	    private transient Movie movie;

	    /**
	     * injecting mocks in MovieServiceImpl object
	     */
	    @InjectMocks
	    private transient MovieServiceImpl movieServiceImpl;

	    /**
	     * Initializing the declarations
	     */
	    @Before
	    public void setupMock() {
	        MockitoAnnotations.initMocks(this);
	        movie = new Movie("POC", "good Movie", "www.abc.com", "2015-03-31");
	        movie.setId(1);
	        Optional.of(movie);

	    }

	    /**
	     * testing mock creation
	     */
	    @Test
	    public void testMockCreation() {
	        assertNotNull("jpaRepository creation fails: use @injectMocks on movieServicempl", movieRepo);
	    }

	    /**
	     * testing the save method
	     * @throws MovieAlreadyExistsException
	     */
	    @Test
	    public void testSaveMovieSuccess() throws MovieAlreadyExistsException {
	        when(movieRepo.save(movie)).thenReturn(movie);
	        Movie flag = movieServiceImpl.saveMovie(movie);
	        assertEquals(movie,flag);
	        verify(movieRepo, times(1)).save(movie);
	       // verify(movieRepo, times(1)).findById(movie.getId());
	    }
}
