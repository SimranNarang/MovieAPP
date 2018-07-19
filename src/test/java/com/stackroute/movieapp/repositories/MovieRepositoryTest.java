/*package com.stackroute.movieapp.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.movieapp.domain.Movie;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MovieRepositoryTest {


	@Autowired
    private transient MovieRepository repo;

    

    @Test
    public void testSaveMovie() throws Exception {
    	Movie saveMovie = new Movie("POC", "good Movie", "www.abc.com", "2015-03-23");
    	saveMovie.setId(1234);
        repo.save(saveMovie);
        final Movie movie = (Movie) repo.getByName("POC");
        assertThat(movie.getId()).isEqualTo(1);
    }
}
*/