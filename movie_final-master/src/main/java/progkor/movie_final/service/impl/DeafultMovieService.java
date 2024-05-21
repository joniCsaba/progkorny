package progkor.movie_final.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progkor.movie_final.data.model.Movie;
import progkor.movie_final.data.repository.Repository;
import progkor.movie_final.service.MovieService;

import java.util.List;
/*
* This class delegates operations to Repository
* */

@Service
public class DeafultMovieService implements MovieService {

    private final Repository<Movie, Long> movieRepository;
    @Autowired
    public DeafultMovieService(Repository<Movie, Long> movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie retrieveByMovieId(Long id) {
        return movieRepository.getById(id);
    }

    @Override
    public List<Movie> retrieveAllMovie() {
        return movieRepository.getAll();
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.update(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}
