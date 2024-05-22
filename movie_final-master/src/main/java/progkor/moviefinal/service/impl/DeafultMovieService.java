package progkor.moviefinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import progkor.moviefinal.data.model.Movie;
import progkor.moviefinal.data.repository.Repository;
import progkor.moviefinal.service.MovieService;


/**
 * This class provides implementations for the MovieService
 * interface by delegating operations to a Repository.
 */
@Service
public class DeafultMovieService implements MovieService {

    private final Repository<Movie, Long> movieRepository;

    /**
     * Constructs a DefaultMovieService with the provided movie repository.
     *
     * @param movieRepository The repository for managing Movie entities.
     */
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
