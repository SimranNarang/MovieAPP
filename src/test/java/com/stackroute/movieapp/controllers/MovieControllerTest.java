package com.stackroute.movieapp.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.services.MovieService;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

	@Autowired
    private MockMvc movieMockMvc;
	private Movie movie;
	
	@MockBean
	private MovieService movieService;
	
	
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        
        movie = new Movie("..","..","..","..");
        movie.setId(1);
    }
	@Test
	public void testDeleteMovie() throws Exception {
	when(movieService.deleteMovie(movie.getId())).thenReturn(true);
	movieMockMvc.perform(delete("/api/v1/movie/{id}",movie.getId()).contentType(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk()).andDo(print());
	verify(movieService, times(1)).deleteMovie(movie.getId());

	}
	@Test
    public void displayMoviesTest() throws Exception {
        when(movieService.getAllMovies()).thenReturn(null);
        movieMockMvc.perform(get("/api/v1/movies")).andExpect(status().isOk());
    }
	@Test 
	public void saveMoviesTest() throws Exception {
          when(movieService.saveMovie(movie)).thenReturn(null);
          movieMockMvc.perform(post("/api/v1/movie")
        		  .contentType(MediaType.APPLICATION_JSON)
        		  .content(asJsonString(movie)))
          .andExpect(status().isCreated());
     }
	
	 @Test
	    public void getMovieByIdTest() throws Exception{
	        when(movieService.getMovieById(movie.getId())).thenReturn(null);
	        movieMockMvc.perform(get("/api/v1/movie/{id}",movie.getId())).andExpect(status().isOk());
	    }
	
	
	public static String asJsonString(final Object obj) {
		try {

			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
